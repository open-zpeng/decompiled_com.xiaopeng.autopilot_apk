package com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket;

import okio.ByteString;
/* loaded from: classes.dex */
public abstract class WebSocketSubscriber implements ada<IWebSocketInfo> {
    private ade disposable;
    private boolean hasOpened;

    protected void onClose() {
    }

    protected void onClosed(int i, String str) {
    }

    protected void onMessage(String str) {
    }

    protected void onMessage(ByteString byteString) {
    }

    protected void onOpen() {
    }

    protected void onReconnect() {
    }

    @Override // defpackage.ada
    public final void onNext(IWebSocketInfo iWebSocketInfo) {
        if (iWebSocketInfo.isOnOpen()) {
            this.hasOpened = true;
            onOpen();
        } else if (iWebSocketInfo.isClosed()) {
            this.hasOpened = false;
            onClosed(iWebSocketInfo.closedReasonCode(), iWebSocketInfo.closedReason());
        } else if (iWebSocketInfo.stringMessage() != null) {
            onMessage(iWebSocketInfo.stringMessage());
        } else if (iWebSocketInfo.byteStringMessage() != null) {
            onMessage(iWebSocketInfo.byteStringMessage());
        } else if (iWebSocketInfo.isOnReconnect()) {
            onReconnect();
        }
    }

    @Override // defpackage.ada
    public final void onSubscribe(ade adeVar) {
        this.disposable = adeVar;
    }

    public final void dispose() {
        ade adeVar = this.disposable;
        if (adeVar != null) {
            adeVar.dispose();
        }
    }

    @Override // defpackage.ada
    public final void onComplete() {
        if (this.hasOpened) {
            onClose();
        }
    }

    @Override // defpackage.ada
    public void onError(Throwable th) {
        th.printStackTrace();
    }
}
