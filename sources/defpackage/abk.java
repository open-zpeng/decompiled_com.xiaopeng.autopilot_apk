package defpackage;

import android.os.Handler;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.xiaopeng.sr.bean.UrlBean;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
/* compiled from: WebSocketClient.java */
/* renamed from: abk  reason: default package */
/* loaded from: classes.dex */
public final class abk extends WebSocketListener {
    private abe k;
    private final Gson e = new Gson();
    private final OkHttpClient f = new OkHttpClient.Builder().retryOnConnectionFailure(true).connectTimeout(3, TimeUnit.SECONDS).readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).pingInterval(60, TimeUnit.SECONDS).build();
    private Request g = null;
    private final String h = "WebSocketClient";
    private WebSocket i = null;
    private String j = null;
    public String a = "wsc";
    public boolean b = true;
    Handler c = new Handler();
    Runnable d = new Runnable() { // from class: abk.1
        @Override // java.lang.Runnable
        public void run() {
            abk.this.a();
            if (abk.this.i == null) {
                abk.this.c.postDelayed(this, 1000L);
            }
        }
    };

    private String d(String str) {
        try {
            return ((UrlBean) this.e.fromJson(new JsonReader(new FileReader(str)), UrlBean.class)).getUrl();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(abe abeVar) {
        this.k = abeVar;
        String d = d("/sdcard/maps/url.json");
        if (d != null) {
            String str = "ws://" + d;
            Log.i("WebSocketClient", "sr_url: " + str);
            c("bye");
            this.a = "fromPK";
            a(str);
        }
    }

    public void a(String str) {
        this.j = str;
        this.g = null;
        this.c.postDelayed(this.d, 100L);
    }

    public void b(String str) {
        WebSocket webSocket = this.i;
        if (webSocket != null) {
            try {
                webSocket.send(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void c(String str) {
        WebSocket webSocket = this.i;
        if (webSocket != null) {
            webSocket.close(1000, str);
            this.i = null;
        }
    }

    @Override // okhttp3.WebSocketListener
    public void onOpen(WebSocket webSocket, Response response) {
        super.onOpen(webSocket, response);
        Log.d("WebSocketClient", "onOpen");
        this.b = true;
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket webSocket, String str) {
        super.onMessage(webSocket, str);
        Log.d("WebSocketClient", "onMessage: " + str.length() + "  " + str);
        abe abeVar = this.k;
        if (abeVar != null) {
            abeVar.a(str);
        }
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket webSocket, ByteString byteString) {
        super.onMessage(webSocket, byteString);
        Log.d("WebSocketClient", "onMessage(byte): " + byteString.size());
        abe abeVar = this.k;
        if (abeVar != null) {
            abeVar.a(byteString);
        }
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(WebSocket webSocket, int i, String str) {
        super.onClosed(webSocket, i, str);
        Log.d("WebSocketClient", "onClosed: " + i + " / " + str);
        this.i = null;
        this.c.postDelayed(this.d, 100L);
    }

    @Override // okhttp3.WebSocketListener
    public void onClosing(WebSocket webSocket, int i, String str) {
        super.onClosing(webSocket, i, str);
        webSocket.close(1000, null);
        Log.d("WebSocketClient", "onClosing: " + i + " / " + str);
    }

    @Override // okhttp3.WebSocketListener
    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
        super.onFailure(webSocket, th, response);
        Log.d("WebSocketClient", "onFailure: " + th + " / " + response);
        this.i = null;
        this.c.postDelayed(this.d, 1000L);
        if (this.b) {
            this.b = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.g == null) {
            this.g = new Request.Builder().url(this.j).build();
        }
        if (this.i == null) {
            this.i = this.f.newWebSocket(this.g, this);
            Log.d("WebSocketClient", "connected to: " + this.j);
        }
    }
}
