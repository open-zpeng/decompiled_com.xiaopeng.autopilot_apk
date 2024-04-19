package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.graphics.glutils.d;
import defpackage.ko;
/* compiled from: FrameBuffer.java */
/* loaded from: classes.dex */
public class c extends d<ko> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.badlogic.gdx.graphics.glutils.d
    /* renamed from: a */
    public ko b(d.b bVar) {
        ko koVar = new ko(new e(this.k.a, this.k.b, 0, bVar.a, bVar.b, bVar.c));
        koVar.setFilter(ko.a.Linear, ko.a.Linear);
        koVar.setWrap(ko.b.ClampToEdge, ko.b.ClampToEdge);
        return koVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.badlogic.gdx.graphics.glutils.d
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void b(ko koVar) {
        koVar.dispose();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.badlogic.gdx.graphics.glutils.d
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public void a(ko koVar) {
        io.h.glFramebufferTexture2D(36160, 36064, 3553, koVar.getTextureObjectHandle(), 0);
    }
}
