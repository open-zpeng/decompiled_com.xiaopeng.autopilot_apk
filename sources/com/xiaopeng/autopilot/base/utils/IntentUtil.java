package com.xiaopeng.autopilot.base.utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import com.xiaopeng.autopilot.base.AutopilotService;
import com.xiaopeng.autopilot.base.a;
import com.xiaopeng.autopilot.base.c;
import com.xiaopeng.autopilot.base.h;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.libconfig.ipc.bean.MessageCenterBean;
import com.xiaopeng.libconfig.ipc.bean.MessageContentBean;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class IntentUtil {
    private static final int CARD_TYPE = 29;
    private static final String CHANNEL_ID = "Autopilot";
    private static final String CHANNEL_NAME = "sendAutopilotMsg";
    public static final int INFO_FLOW_CARD_TYPE_AUTOMATIC_LEARNING_AVAILABLE = 3;
    public static final int INFO_FLOW_CARD_TYPE_AUTOMATIC_LEARNING_UPDATE = 4;
    public static final int INFO_FLOW_CARD_TYPE_LEARNING_AVAILABLE = 2;
    public static final int INFO_FLOW_CARD_TYPE_LEARNING_SUMMON = 9;
    public static final int INFO_FLOW_CARD_TYPE_MEMORY_PARKING_ACTIVATED = 1;
    public static final int INFO_FLOW_CARD_TYPE_TERMINAL_ATTR_CHARGING_PIE = 5;
    public static final int INFO_FLOW_CARD_TYPE_TERMINAL_ATTR_ELEVATOR = 6;
    public static final int INFO_FLOW_CARD_TYPE_TERMINAL_ATTR_OTHER = 8;
    public static final int INFO_FLOW_CARD_TYPE_TERMINAL_ATTR_STAIR = 7;
    private static final int MSG_ID = 1;
    private static final String TAG = "IntentUtil";
    public static final int TIP_NAV_INFOFLOW = -2;
    private static String mMemoryParkingMsgId = null;
    private static ade mSendInfoFlowObservable = null;
    private static int mTips = -1;
    private static String sLastAutopilotServiceAction;
    private static Bundle sLastAutopilotServiceBundle;
    private static ConcurrentLinkedQueue<MessageToAiBean> mAiMessageQueue = new ConcurrentLinkedQueue<>();
    private static volatile boolean mShowLearningSummonCard = false;
    private static volatile boolean mLearningSummonCardIsShow = false;

    public static void apFinishPageShowLearningSummonBtnShow() {
    }

    public static void startAutopilotService(Context context, String str) {
        startAutopilotService(context, str, null);
    }

    public static void startAutopilotService(Context context, String str, Bundle bundle) {
        Intent intent = new Intent(context, AutopilotService.class);
        intent.setPackage(context.getPackageName());
        intent.setAction(str);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startService(intent);
        sLastAutopilotServiceAction = str;
        sLastAutopilotServiceBundle = bundle;
    }

    public static void startActivityByApp(Context context, Intent intent) {
        intent.addFlags(335544320);
        context.startActivity(intent);
    }

    public static boolean isRunningExitSuperParkCheckR() {
        Bundle bundle;
        if (sLastAutopilotServiceAction != null && (bundle = sLastAutopilotServiceBundle) != null) {
            boolean z = bundle.getBoolean("isDelayCheckR", false);
            Log.i(TAG, "resetExitSuperParkCheckR() sLastAutopilotServiceAction=" + sLastAutopilotServiceAction + "， isDelayCheckR=" + z);
            if ("com.xiaopeng.action.ACTION_EXIT_SUPER_PARK".equals(sLastAutopilotServiceAction) && z) {
                return true;
            }
        }
        return false;
    }

    public static void resetExitSuperParkCheckR() {
        Log.i(TAG, "resetExitSuperParkCheckR() 还原B过程延迟关闭的变量");
        sLastAutopilotServiceAction = null;
        sLastAutopilotServiceBundle = null;
    }

    public static void sendInfoFlowCard(int i) {
        Log.i(TAG, "sendInfoFlowCard.show = " + i);
        int i2 = mTips;
        if (i2 != i) {
            if (i2 == -2 && i == 0) {
                LogUtils.i(TAG, "ignore send close infoflow as in nav flow tips");
                return;
            }
            if (i > 0 && mTips != 0) {
                sendCloseInfoFlowCard();
            }
            mTips = i;
            memoryParkingGuideToAi(i);
            if (i != 0) {
                i.a(i.al.class, false);
            }
        }
    }

    public static void sendNavStartFlowCard(int i) {
        String string;
        String string2;
        if (mTips != 0) {
            sendCloseInfoFlowCard();
        }
        LogUtils.i(TAG, "sendNavStartFlowCard:" + i);
        Resources resources = a.g().getApplicationContext().getResources();
        String str = "";
        mTips = -2;
        switch (i) {
            case 1:
                str = resources.getString(h.i.memory_parking_share_type_charging_pie);
                break;
            case 2:
                str = resources.getString(h.i.memory_parking_share_type_elevator);
                break;
            case 3:
                str = resources.getString(h.i.memory_parking_share_type_stair);
                break;
        }
        if (TextUtils.isEmpty(str)) {
            string = resources.getString(h.i.nav_guide_infoflow_to_other_addr);
        } else {
            string = resources.getString(h.i.nav_guide_infoflow_to_specific_addr, str);
        }
        if (TextUtils.isEmpty(str)) {
            string2 = resources.getString(h.i.nav_start_notification_other_tts);
        } else {
            string2 = resources.getString(h.i.nav_start_notification_specific_addr_tts, str);
        }
        addAiMessageToSend(string, "", string2, "ACTION_NAV_START_POINT", 28009, true);
    }

    public static int getTips() {
        return mTips;
    }

    public static void sendInfoFlowCard(int i, boolean z) {
        Log.i(TAG, "sendInfoFlowCard.show true = " + i);
        if (z || mTips != i) {
            mTips = i;
            sendCloseInfoFlowCard();
        }
    }

    public static void sendCloseInfoFlowCard() {
        addAiMessageToSend("", "", "*", "", 28001, false);
    }

    public static void showLearningSummonCard() {
        if (mShowLearningSummonCard && ((i.at) i.a(i.at.class)).d().intValue() == 33) {
            sendInfoFlowCard(9);
            mLearningSummonCardIsShow = true;
        }
    }

    public static void onTrainingTipsChange(int i, boolean z) {
        Log.d(TAG, "onTrainingTipsChange tips = " + i + " ; viewIsVisible = " + z);
        if (i != 33) {
            mShowLearningSummonCard = false;
            if (mLearningSummonCardIsShow) {
                sendInfoFlowCard(0, true);
                mLearningSummonCardIsShow = false;
            }
        } else if (!z) {
            sendInfoFlowCard(9);
            mShowLearningSummonCard = false;
            mLearningSummonCardIsShow = true;
        } else {
            mShowLearningSummonCard = true;
        }
    }

    public static void memoryParkingGuideToAi(int i) {
        String str;
        String str2;
        Resources resources = a.g().getApplicationContext().getResources();
        String str3 = "*";
        int i2 = 28001;
        boolean z = false;
        switch (i) {
            case 1:
                String string = resources.getString(h.i.memory_parking_activated_title);
                str3 = resources.getString(h.i.memory_parking_activated_tts);
                str = "ACTION_MEMORY_PARKING_ACTIVATED";
                i2 = 28002;
                z = true;
                str2 = string;
                break;
            case 2:
                str3 = "*";
                str = "ACTION_ROUTE_LEARNING_AVAILABLE";
                str2 = resources.getString(h.i.route_learning_available_title);
                z = true;
                break;
            case 3:
                String string2 = resources.getString(h.i.automatic_learning_available_title);
                str3 = resources.getString(h.i.automatic_learning_available_tts);
                str = "ACTION_AUTOMATIC_LEARNING_AVAILABLE";
                i2 = 28003;
                z = true;
                str2 = string2;
                break;
            case 4:
                String string3 = resources.getString(h.i.automatic_learning_update_title);
                str3 = resources.getString(h.i.automatic_learning_update_tts);
                str = "ACTION_AUTOMATIC_LEARNING_UPDATE";
                i2 = 28004;
                z = true;
                str2 = string3;
                break;
            case 5:
                String string4 = resources.getString(h.i.memory_parking_share_type_charging_pie);
                String format = String.format(resources.getString(h.i.memory_parking_activated_share_title), string4);
                str3 = String.format(resources.getString(h.i.memory_parking_activated_share_tts), string4);
                str = "ACTION_AUTOMATIC_LEARNING_AVAILABLE";
                i2 = 28005;
                z = true;
                str2 = format;
                break;
            case 6:
                String string5 = resources.getString(h.i.memory_parking_share_type_elevator);
                String format2 = String.format(resources.getString(h.i.memory_parking_activated_share_title), string5);
                str3 = String.format(resources.getString(h.i.memory_parking_activated_share_tts), string5);
                str = "ACTION_AUTOMATIC_LEARNING_AVAILABLE";
                i2 = 28006;
                z = true;
                str2 = format2;
                break;
            case 7:
                String string6 = resources.getString(h.i.memory_parking_share_type_stair);
                String format3 = String.format(resources.getString(h.i.memory_parking_activated_share_title), string6);
                str3 = String.format(resources.getString(h.i.memory_parking_activated_share_tts), string6);
                str2 = format3;
                i2 = 28007;
                z = true;
                str = "ACTION_AUTOMATIC_LEARNING_AVAILABLE";
                break;
            case 8:
                String string7 = resources.getString(h.i.memory_parking_activated_share_title_other);
                str3 = resources.getString(h.i.memory_parking_activated_share_tts_other);
                str2 = string7;
                i2 = 28007;
                z = true;
                str = "ACTION_AUTOMATIC_LEARNING_AVAILABLE";
                break;
            default:
                str = "";
                str2 = "";
                break;
        }
        if (mTips != -2) {
            addAiMessageToSend(str2, "", str3, str, i2, z);
        }
    }

    /* loaded from: classes.dex */
    public static class MessageToAiBean {
        private String mAction;
        private String mContent;
        private int mSceneId;
        private boolean mShow;
        private String mTitle;
        private String mTts;

        public MessageToAiBean(String str, String str2, String str3, String str4, int i, boolean z) {
            this.mTitle = str;
            this.mContent = str2;
            this.mTts = str3;
            this.mAction = str4;
            this.mSceneId = i;
            this.mShow = z;
        }

        public String getTitle() {
            return this.mTitle;
        }

        public String getContent() {
            return this.mContent;
        }

        public String getTts() {
            return this.mTts;
        }

        public String getAction() {
            return this.mAction;
        }

        public int getSceneId() {
            return this.mSceneId;
        }

        public void setTts(String str) {
            this.mTts = str;
        }

        public boolean isShow() {
            return this.mShow;
        }
    }

    public static void addAiMessageToSend(String str, String str2, String str3, String str4, int i, boolean z) {
        mAiMessageQueue.offer(new MessageToAiBean(str, str2, str3, str4, i, z));
        ade adeVar = mSendInfoFlowObservable;
        if (adeVar == null || adeVar.isDisposed()) {
            mSendInfoFlowObservable = acy.a(1L, TimeUnit.SECONDS).a(afe.b()).b(afe.b()).a(new adr<Long>() { // from class: com.xiaopeng.autopilot.base.utils.IntentUtil.1
                @Override // defpackage.adr
                public void accept(Long l) {
                    if (IntentUtil.mAiMessageQueue.isEmpty()) {
                        IntentUtil.mSendInfoFlowObservable.dispose();
                        return;
                    }
                    MessageToAiBean messageToAiBean = (MessageToAiBean) IntentUtil.mAiMessageQueue.poll();
                    boolean c = rf.a(a.g().getApplicationContext()).c();
                    if (c && messageToAiBean.getSceneId() != 28009) {
                        messageToAiBean.setTts("*");
                    }
                    IntentUtil.sendMessageToAi(messageToAiBean.getTitle(), messageToAiBean.getContent(), messageToAiBean.getTts(), messageToAiBean.getAction(), messageToAiBean.getSceneId(), messageToAiBean.isShow());
                    if (c || !messageToAiBean.isShow() || messageToAiBean.getSceneId() == 28009) {
                        return;
                    }
                    rf.a(a.g().getApplicationContext()).b(true);
                }
            }, aea.a());
        }
    }

    public static void sendMessageToAi(String str, String str2, String str3, String str4, int i, boolean z) {
        Log.d(TAG, "title = " + str + " ;action = " + str4 + " ;tts = " + str3 + " ;sceneId = " + i + " ;show = " + z);
        if (z) {
            MessageContentBean createContent = MessageContentBean.createContent();
            createContent.setSensingType(MessageContentBean.SENSING_TYPE_SYSTEM);
            createContent.setPermanent(1);
            createContent.addTitle(str);
            createContent.addTitle(str2);
            createContent.setTts(str3);
            MessageContentBean.MsgButton create = MessageContentBean.MsgButton.create(a.g().getApplicationContext().getString(h.i.training_up_down_out_btn), IpcConfig.App.CAR_AUTOPILOT, str4, true);
            create.setResponseWord("");
            createContent.addButton(create);
            MessageCenterBean create2 = MessageCenterBean.create(1, createContent);
            create2.setScene(i);
            mMemoryParkingMsgId = create2.getMessageId();
            create2.setValidStartTs(System.currentTimeMillis());
            create2.setValidEndTs(System.currentTimeMillis() + 86400000);
            create2.getContentBean().setValidTime(0L);
            Bundle bundle = new Bundle();
            bundle.putString(IpcConfig.IPCKey.STRING_MSG, new Gson().toJson(create2));
            c.a().a(IpcConfig.MessageCenterConfig.IPC_ID_APP_PUSH_MESSAGE, bundle, "com.xiaopeng.aiassistant");
        } else if (mMemoryParkingMsgId != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(IpcConfig.IPCKey.STRING_MSG, mMemoryParkingMsgId);
            c.a().a(IpcConfig.AIAssistantConfig.IPC_MESSAGE_CLOSE, bundle2, "com.xiaopeng.aiassistant");
        }
    }
}
