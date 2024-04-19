package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounterFactory;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder;
import java.util.List;
/* compiled from: DataLogService.java */
/* renamed from: vj  reason: default package */
/* loaded from: classes.dex */
public class vj implements IDataLog {
    private Context a;

    public vj(Context context) {
        vs.a(context);
        this.a = context;
        Module.register(vi.class, new vi(context));
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendCanData(String str) {
        vs.a().a(str);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatData(String str, String str2) {
        vs.a().a(str, str2);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatOriginData(String str, String str2) {
        vs.a().b(str, str2);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatData(IStatEvent iStatEvent) {
        vs.a().a(iStatEvent);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatData(IMoleEvent iMoleEvent) {
        vs.a().a(iMoleEvent);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatData(IStatEvent iStatEvent, List<String> list) {
        vs.a().a(iStatEvent, list);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendFiles(List<String> list) {
        vs.a().a(list);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public String sendRecentSystemLog() {
        return vs.a().b();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public IStatEventBuilder buildStat() {
        return new b(this.a);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public IMoleEventBuilder buildMoleEvent() {
        return new a(this.a);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public ICounterFactory counterFactory() {
        return vm.a();
    }

    /* compiled from: DataLogService.java */
    /* renamed from: vj$b */
    /* loaded from: classes.dex */
    private class b implements IStatEventBuilder {
        private IStatEvent b;

        b(Context context) {
            this.b = new vl(context);
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setEventName(String str) {
            this.b.setEventName(str);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setProperty(String str, String str2) {
            this.b.put(str, str2);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setProperty(String str, Number number) {
            this.b.put(str, number);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setProperty(String str, boolean z) {
            this.b.put(str, Boolean.valueOf(z));
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setProperty(String str, char c) {
            this.b.put(str, Character.valueOf(c));
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEvent build() {
            if (TextUtils.isEmpty(this.b.getEventName())) {
                throw new IllegalStateException("Please call setEventName first!");
            }
            return this.b;
        }
    }

    /* compiled from: DataLogService.java */
    /* renamed from: vj$a */
    /* loaded from: classes.dex */
    private class a implements IMoleEventBuilder {
        vk a;

        private a(Context context) {
            this.a = new vk(context);
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setPageId(String str) {
            this.a.a("page_id", str);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setButtonId(String str) {
            this.a.a("button_id", str);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setModule(String str) {
            this.a.a(IStatEvent.CUSTOM_MODULE, str);
            vk vkVar = this.a;
            vkVar.a(IStatEvent.CUSTOM_EVENT, str + "_page_button");
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setEvent(String str) {
            this.a.a(IStatEvent.CUSTOM_MODULE, vl.a(str));
            this.a.a(IStatEvent.CUSTOM_EVENT, str);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setProperty(String str, String str2) {
            this.a.a(str, str2);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setProperty(String str, Number number) {
            this.a.a(str, number);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setProperty(String str, boolean z) {
            this.a.a(str, Boolean.valueOf(z));
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setProperty(String str, char c) {
            this.a.a(str, Character.valueOf(c));
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEvent build() {
            this.a.a();
            return this.a;
        }
    }
}
