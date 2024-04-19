package defpackage;

import java.nio.Buffer;
import java.nio.IntBuffer;
/* compiled from: GL20Interceptor.java */
/* renamed from: nt  reason: default package */
/* loaded from: classes.dex */
public class nt extends nw implements kg {
    protected final kg a;

    /* JADX INFO: Access modifiers changed from: protected */
    public nt(nx nxVar, kg kgVar) {
        super(nxVar);
        this.a = kgVar;
    }

    private void g() {
        int glGetError = this.a.glGetError();
        while (glGetError != 0) {
            this.g.c().a(glGetError);
            glGetError = this.a.glGetError();
        }
    }

    @Override // defpackage.kg
    public void glActiveTexture(int i) {
        this.b++;
        this.a.glActiveTexture(i);
        g();
    }

    @Override // defpackage.kg
    public void glBindTexture(int i, int i2) {
        this.c++;
        this.b++;
        this.a.glBindTexture(i, i2);
        g();
    }

    @Override // defpackage.kg
    public void glBlendFunc(int i, int i2) {
        this.b++;
        this.a.glBlendFunc(i, i2);
        g();
    }

    @Override // defpackage.kg
    public void glClear(int i) {
        this.b++;
        this.a.glClear(i);
        g();
    }

    @Override // defpackage.kg
    public void glClearColor(float f, float f2, float f3, float f4) {
        this.b++;
        this.a.glClearColor(f, f2, f3, f4);
        g();
    }

    @Override // defpackage.kg
    public void glCompressedTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, Buffer buffer) {
        this.b++;
        this.a.glCompressedTexImage2D(i, i2, i3, i4, i5, i6, i7, buffer);
        g();
    }

    @Override // defpackage.kg
    public void glCullFace(int i) {
        this.b++;
        this.a.glCullFace(i);
        g();
    }

    @Override // defpackage.kg
    public void glDeleteTexture(int i) {
        this.b++;
        this.a.glDeleteTexture(i);
        g();
    }

    @Override // defpackage.kg
    public void glDepthFunc(int i) {
        this.b++;
        this.a.glDepthFunc(i);
        g();
    }

    @Override // defpackage.kg
    public void glDepthMask(boolean z) {
        this.b++;
        this.a.glDepthMask(z);
        g();
    }

    @Override // defpackage.kg
    public void glDepthRangef(float f, float f2) {
        this.b++;
        this.a.glDepthRangef(f, f2);
        g();
    }

    @Override // defpackage.kg
    public void glDisable(int i) {
        this.b++;
        this.a.glDisable(i);
        g();
    }

    @Override // defpackage.kg
    public void glDrawArrays(int i, int i2, int i3) {
        this.f.a(i3);
        this.d++;
        this.b++;
        this.a.glDrawArrays(i, i2, i3);
        g();
    }

    @Override // defpackage.kg
    public void glDrawElements(int i, int i2, int i3, Buffer buffer) {
        this.f.a(i2);
        this.d++;
        this.b++;
        this.a.glDrawElements(i, i2, i3, buffer);
        g();
    }

    @Override // defpackage.kg
    public void glEnable(int i) {
        this.b++;
        this.a.glEnable(i);
        g();
    }

    @Override // defpackage.kg
    public int glGenTexture() {
        this.b++;
        int glGenTexture = this.a.glGenTexture();
        g();
        return glGenTexture;
    }

    @Override // defpackage.kg
    public int glGetError() {
        this.b++;
        return this.a.glGetError();
    }

    @Override // defpackage.kg
    public void glGetIntegerv(int i, IntBuffer intBuffer) {
        this.b++;
        this.a.glGetIntegerv(i, intBuffer);
        g();
    }

    @Override // defpackage.kg
    public String glGetString(int i) {
        this.b++;
        String glGetString = this.a.glGetString(i);
        g();
        return glGetString;
    }

    @Override // defpackage.kg
    public void glLineWidth(float f) {
        this.b++;
        this.a.glLineWidth(f);
        g();
    }

    @Override // defpackage.kg
    public void glPixelStorei(int i, int i2) {
        this.b++;
        this.a.glPixelStorei(i, i2);
        g();
    }

    @Override // defpackage.kg
    public void glScissor(int i, int i2, int i3, int i4) {
        this.b++;
        this.a.glScissor(i, i2, i3, i4);
        g();
    }

    @Override // defpackage.kg
    public void glTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Buffer buffer) {
        this.b++;
        this.a.glTexImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
        g();
    }

    @Override // defpackage.kg
    public void glTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Buffer buffer) {
        this.b++;
        this.a.glTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
        g();
    }

    @Override // defpackage.kg
    public void glViewport(int i, int i2, int i3, int i4) {
        this.b++;
        this.a.glViewport(i, i2, i3, i4);
        g();
    }

    @Override // defpackage.kg
    public void glAttachShader(int i, int i2) {
        this.b++;
        this.a.glAttachShader(i, i2);
        g();
    }

    @Override // defpackage.kg
    public void glBindBuffer(int i, int i2) {
        this.b++;
        this.a.glBindBuffer(i, i2);
        g();
    }

    @Override // defpackage.kg
    public void glBindFramebuffer(int i, int i2) {
        this.b++;
        this.a.glBindFramebuffer(i, i2);
        g();
    }

    @Override // defpackage.kg
    public void glBindRenderbuffer(int i, int i2) {
        this.b++;
        this.a.glBindRenderbuffer(i, i2);
        g();
    }

    @Override // defpackage.kg
    public void glBlendFuncSeparate(int i, int i2, int i3, int i4) {
        this.b++;
        this.a.glBlendFuncSeparate(i, i2, i3, i4);
        g();
    }

    @Override // defpackage.kg
    public void glBufferData(int i, int i2, Buffer buffer, int i3) {
        this.b++;
        this.a.glBufferData(i, i2, buffer, i3);
        g();
    }

    @Override // defpackage.kg
    public void glBufferSubData(int i, int i2, int i3, Buffer buffer) {
        this.b++;
        this.a.glBufferSubData(i, i2, i3, buffer);
        g();
    }

    @Override // defpackage.kg
    public int glCheckFramebufferStatus(int i) {
        this.b++;
        int glCheckFramebufferStatus = this.a.glCheckFramebufferStatus(i);
        g();
        return glCheckFramebufferStatus;
    }

    @Override // defpackage.kg
    public void glCompileShader(int i) {
        this.b++;
        this.a.glCompileShader(i);
        g();
    }

    @Override // defpackage.kg
    public int glCreateProgram() {
        this.b++;
        int glCreateProgram = this.a.glCreateProgram();
        g();
        return glCreateProgram;
    }

    @Override // defpackage.kg
    public int glCreateShader(int i) {
        this.b++;
        int glCreateShader = this.a.glCreateShader(i);
        g();
        return glCreateShader;
    }

    @Override // defpackage.kg
    public void glDeleteBuffer(int i) {
        this.b++;
        this.a.glDeleteBuffer(i);
        g();
    }

    @Override // defpackage.kg
    public void glDeleteFramebuffer(int i) {
        this.b++;
        this.a.glDeleteFramebuffer(i);
        g();
    }

    @Override // defpackage.kg
    public void glDeleteProgram(int i) {
        this.b++;
        this.a.glDeleteProgram(i);
        g();
    }

    @Override // defpackage.kg
    public void glDeleteRenderbuffer(int i) {
        this.b++;
        this.a.glDeleteRenderbuffer(i);
        g();
    }

    @Override // defpackage.kg
    public void glDeleteShader(int i) {
        this.b++;
        this.a.glDeleteShader(i);
        g();
    }

    @Override // defpackage.kg
    public void glDisableVertexAttribArray(int i) {
        this.b++;
        this.a.glDisableVertexAttribArray(i);
        g();
    }

    @Override // defpackage.kg
    public void glDrawElements(int i, int i2, int i3, int i4) {
        this.f.a(i2);
        this.d++;
        this.b++;
        this.a.glDrawElements(i, i2, i3, i4);
        g();
    }

    @Override // defpackage.kg
    public void glEnableVertexAttribArray(int i) {
        this.b++;
        this.a.glEnableVertexAttribArray(i);
        g();
    }

    @Override // defpackage.kg
    public void glFramebufferRenderbuffer(int i, int i2, int i3, int i4) {
        this.b++;
        this.a.glFramebufferRenderbuffer(i, i2, i3, i4);
        g();
    }

    @Override // defpackage.kg
    public void glFramebufferTexture2D(int i, int i2, int i3, int i4, int i5) {
        this.b++;
        this.a.glFramebufferTexture2D(i, i2, i3, i4, i5);
        g();
    }

    @Override // defpackage.kg
    public int glGenBuffer() {
        this.b++;
        int glGenBuffer = this.a.glGenBuffer();
        g();
        return glGenBuffer;
    }

    @Override // defpackage.kg
    public void glGenerateMipmap(int i) {
        this.b++;
        this.a.glGenerateMipmap(i);
        g();
    }

    @Override // defpackage.kg
    public int glGenFramebuffer() {
        this.b++;
        int glGenFramebuffer = this.a.glGenFramebuffer();
        g();
        return glGenFramebuffer;
    }

    @Override // defpackage.kg
    public int glGenRenderbuffer() {
        this.b++;
        int glGenRenderbuffer = this.a.glGenRenderbuffer();
        g();
        return glGenRenderbuffer;
    }

    @Override // defpackage.kg
    public String glGetActiveAttrib(int i, int i2, IntBuffer intBuffer, Buffer buffer) {
        this.b++;
        String glGetActiveAttrib = this.a.glGetActiveAttrib(i, i2, intBuffer, buffer);
        g();
        return glGetActiveAttrib;
    }

    @Override // defpackage.kg
    public String glGetActiveUniform(int i, int i2, IntBuffer intBuffer, Buffer buffer) {
        this.b++;
        String glGetActiveUniform = this.a.glGetActiveUniform(i, i2, intBuffer, buffer);
        g();
        return glGetActiveUniform;
    }

    @Override // defpackage.kg
    public int glGetAttribLocation(int i, String str) {
        this.b++;
        int glGetAttribLocation = this.a.glGetAttribLocation(i, str);
        g();
        return glGetAttribLocation;
    }

    @Override // defpackage.kg
    public void glGetProgramiv(int i, int i2, IntBuffer intBuffer) {
        this.b++;
        this.a.glGetProgramiv(i, i2, intBuffer);
        g();
    }

    @Override // defpackage.kg
    public String glGetProgramInfoLog(int i) {
        this.b++;
        String glGetProgramInfoLog = this.a.glGetProgramInfoLog(i);
        g();
        return glGetProgramInfoLog;
    }

    @Override // defpackage.kg
    public void glGetShaderiv(int i, int i2, IntBuffer intBuffer) {
        this.b++;
        this.a.glGetShaderiv(i, i2, intBuffer);
        g();
    }

    @Override // defpackage.kg
    public String glGetShaderInfoLog(int i) {
        this.b++;
        String glGetShaderInfoLog = this.a.glGetShaderInfoLog(i);
        g();
        return glGetShaderInfoLog;
    }

    @Override // defpackage.kg
    public int glGetUniformLocation(int i, String str) {
        this.b++;
        int glGetUniformLocation = this.a.glGetUniformLocation(i, str);
        g();
        return glGetUniformLocation;
    }

    @Override // defpackage.kg
    public void glLinkProgram(int i) {
        this.b++;
        this.a.glLinkProgram(i);
        g();
    }

    @Override // defpackage.kg
    public void glRenderbufferStorage(int i, int i2, int i3, int i4) {
        this.b++;
        this.a.glRenderbufferStorage(i, i2, i3, i4);
        g();
    }

    @Override // defpackage.kg
    public void glShaderSource(int i, String str) {
        this.b++;
        this.a.glShaderSource(i, str);
        g();
    }

    @Override // defpackage.kg
    public void glTexParameteri(int i, int i2, int i3) {
        this.b++;
        this.a.glTexParameteri(i, i2, i3);
        g();
    }

    @Override // defpackage.kg
    public void glUniform1f(int i, float f) {
        this.b++;
        this.a.glUniform1f(i, f);
        g();
    }

    @Override // defpackage.kg
    public void glUniform1i(int i, int i2) {
        this.b++;
        this.a.glUniform1i(i, i2);
        g();
    }

    @Override // defpackage.kg
    public void glUniform2f(int i, float f, float f2) {
        this.b++;
        this.a.glUniform2f(i, f, f2);
        g();
    }

    @Override // defpackage.kg
    public void glUniform3f(int i, float f, float f2, float f3) {
        this.b++;
        this.a.glUniform3f(i, f, f2, f3);
        g();
    }

    @Override // defpackage.kg
    public void glUniform3fv(int i, int i2, float[] fArr, int i3) {
        this.b++;
        this.a.glUniform3fv(i, i2, fArr, i3);
        g();
    }

    @Override // defpackage.kg
    public void glUniform4f(int i, float f, float f2, float f3, float f4) {
        this.b++;
        this.a.glUniform4f(i, f, f2, f3, f4);
        g();
    }

    @Override // defpackage.kg
    public void glUniformMatrix3fv(int i, int i2, boolean z, float[] fArr, int i3) {
        this.b++;
        this.a.glUniformMatrix3fv(i, i2, z, fArr, i3);
        g();
    }

    @Override // defpackage.kg
    public void glUniformMatrix4fv(int i, int i2, boolean z, float[] fArr, int i3) {
        this.b++;
        this.a.glUniformMatrix4fv(i, i2, z, fArr, i3);
        g();
    }

    @Override // defpackage.kg
    public void glUseProgram(int i) {
        this.e++;
        this.b++;
        this.a.glUseProgram(i);
        g();
    }

    @Override // defpackage.kg
    public void glVertexAttribPointer(int i, int i2, int i3, boolean z, int i4, Buffer buffer) {
        this.b++;
        this.a.glVertexAttribPointer(i, i2, i3, z, i4, buffer);
        g();
    }

    @Override // defpackage.kg
    public void glVertexAttribPointer(int i, int i2, int i3, boolean z, int i4, int i5) {
        this.b++;
        this.a.glVertexAttribPointer(i, i2, i3, z, i4, i5);
        g();
    }
}
