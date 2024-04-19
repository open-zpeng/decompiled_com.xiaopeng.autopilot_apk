package com.xiaopeng.speech.protocol.node.context;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class ContextNode_Processor implements ICommandProcessor {
    private ContextNode a;

    public ContextNode_Processor(ContextNode contextNode) {
        this.a = contextNode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        switch (str.hashCode()) {
            case -1780364159:
                if (str.equals("context.widget.topping.page")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case -1771180897:
                if (str.equals("context.widget.prev.page")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case -1131091804:
                if (str.equals("context.tips.text")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1045691198:
                if (str.equals("jarvis.context.input")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -690587803:
                if (str.equals("context.widget.cancel")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case -671951780:
                if (str.equals("context.widget.custom")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -420795744:
                if (str.equals("context.say.welcome")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case -397592754:
                if (str.equals("context.list.item.focus")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -229200237:
                if (str.equals("context.widget.search")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 50079459:
                if (str.equals("context.widget.list.expend")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case 104831985:
                if (str.equals("context.widget.recommend")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 287472607:
                if (str.equals("context.widget.next.page")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 319661844:
                if (str.equals("context.widget.low.page")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 391447827:
                if (str.equals("context.exit.recommend.card")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case 402709913:
                if (str.equals("context.widget.media")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 843973307:
                if (str.equals("context.widget.card")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 844249161:
                if (str.equals("context.widget.list")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 844483800:
                if (str.equals("context.widget.text")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 921064215:
                if (str.equals("context.list.item.scroll")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 922722630:
                if (str.equals("context.list.item.select")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 970800010:
                if (str.equals("context.widget.list.stop.countdown")) {
                    c = 26;
                    break;
                }
                c = 65535;
                break;
            case 1588160567:
                if (str.equals("context.expression")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 1815394606:
                if (str.equals("context.list.item.cancel.focus")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 1996065910:
                if (str.equals("context.script.status")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case 2004051806:
                if (str.equals("context.script.start")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 2121665289:
                if (str.equals("jarvis.context.output")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 2140852870:
                if (str.equals("context.widget.list.fold")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                this.a.onInputText(str, str2);
                return;
            case 1:
                this.a.onOutputText(str, str2);
                return;
            case 2:
                this.a.onTipsText(str, str2);
                return;
            case 3:
                this.a.onWidgetCustom(str, str2);
                return;
            case 4:
                this.a.onWidgetText(str, str2);
                return;
            case 5:
                this.a.onWidgetList(str, str2);
                return;
            case 6:
                this.a.onWidgetListFocus(str, str2);
                return;
            case 7:
                this.a.onWidgetMedia(str, str2);
                return;
            case '\b':
                this.a.onWidgetCard(str, str2);
                return;
            case '\t':
                this.a.onWidgetRecommend(str, str2);
                return;
            case '\n':
                this.a.onWidgetSearch(str, str2);
                return;
            case 11:
                this.a.onExpression(str, str2);
                return;
            case '\f':
                this.a.onSayWelcome(str, str2);
                return;
            case '\r':
                this.a.onWidgetScroll(str, str2);
                return;
            case 14:
                this.a.onWidgetListSelect(str, str2);
                return;
            case 15:
                this.a.onWidgetCancel(str, str2);
                return;
            case 16:
                this.a.onPageNext(str, str2);
                return;
            case 17:
                this.a.onPagePrev(str, str2);
                return;
            case 18:
                this.a.onPageTopping(str, str2);
                return;
            case 19:
                this.a.onPageSetLow(str, str2);
                return;
            case 20:
                this.a.onWidgetListCancelFocus(str, str2);
                return;
            case 21:
                this.a.onScript(str, str2);
                return;
            case 22:
                this.a.onScriptStatus(str, str2);
                return;
            case 23:
                this.a.onExitRecommendCard(str, str2);
                return;
            case 24:
                this.a.onWidgetListFold(str, str2);
                return;
            case 25:
                this.a.onWidgetListExpend(str, str2);
                return;
            case 26:
                this.a.onWidgetListStopCountdown(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"jarvis.context.input", "jarvis.context.output", "context.tips.text", "context.widget.custom", "context.widget.text", "context.widget.list", "context.list.item.focus", "context.widget.media", "context.widget.card", "context.widget.recommend", "context.widget.search", "context.expression", "context.say.welcome", "context.list.item.scroll", "context.list.item.select", "context.widget.cancel", "context.widget.next.page", "context.widget.prev.page", "context.widget.topping.page", "context.widget.low.page", "context.list.item.cancel.focus", "context.script.start", "context.script.status", "context.exit.recommend.card", "context.widget.list.fold", "context.widget.list.expend", "context.widget.list.stop.countdown"};
    }
}
