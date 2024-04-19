package defpackage;
/* compiled from: StartNaviBean.java */
/* renamed from: aac  reason: default package */
/* loaded from: classes.dex */
public class aac {
    private zw a;
    private int b;
    private a c;
    private int d;
    private int e;

    /* compiled from: StartNaviBean.java */
    /* renamed from: aac$a */
    /* loaded from: classes.dex */
    public enum a {
        POI,
        WAYPOINT
    }

    public aac() {
    }

    public aac(zw zwVar, String str, String str2) {
        this.a = zwVar;
        this.b = a(str);
        if ("waypoint".equals(str2)) {
            this.c = a.WAYPOINT;
        } else {
            this.c = a.POI;
        }
    }

    public String toString() {
        return "StartNaviBean{poiBean=" + this.a + ", naviType=" + this.d + ", routeSelectRef=" + this.e + ", pathRef='" + this.b + "'}";
    }

    public void a(int i) {
        this.d = i;
    }

    public void b(int i) {
        this.e = i;
    }

    private int a(String str) {
        if (aak.a()) {
            return zt.b(str);
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -482414100:
                if (str.equals("躲避收费和拥堵")) {
                    c = 5;
                    break;
                }
                break;
            case -154630622:
                if (str.equals("不走高速躲避收费和拥堵")) {
                    c = 6;
                    break;
                }
                break;
            case 35696354:
                if (str.equals("费用少")) {
                    c = 0;
                    break;
                }
                break;
            case 631315594:
                if (str.equals("不走高速")) {
                    c = 3;
                    break;
                }
                break;
            case 1124620989:
                if (str.equals("躲避拥堵")) {
                    c = 2;
                    break;
                }
                break;
            case 1217019831:
                if (str.equals("高速优先")) {
                    c = 1;
                    break;
                }
                break;
            case 2036169147:
                if (str.equals("不走高速且避免收费")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 6;
            case 4:
                return 7;
            case 5:
                return 8;
            case 6:
                return 9;
            default:
                return 0;
        }
    }
}
