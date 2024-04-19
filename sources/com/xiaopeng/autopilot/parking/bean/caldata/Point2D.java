package com.xiaopeng.autopilot.parking.bean.caldata;
/* loaded from: classes.dex */
public class Point2D {
    public float x;
    public float y;

    public Point2D() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.x = 0.0f;
        this.y = 0.0f;
    }

    public Point2D(float f, float f2) {
        this.x = 0.0f;
        this.y = 0.0f;
        this.x = f;
        this.y = f2;
    }

    public static Point2D operatorAdd(Point2D point2D, Point2D point2D2) {
        Point2D point2D3 = new Point2D();
        point2D3.x = point2D.x + point2D2.x;
        point2D3.y = point2D.y + point2D2.y;
        return point2D3;
    }

    public static Point2D operatorSub(Point2D point2D, Point2D point2D2) {
        Point2D point2D3 = new Point2D();
        point2D3.x = point2D.x - point2D2.x;
        point2D3.y = point2D.y - point2D2.y;
        return point2D3;
    }

    public static float operatorMul(Point2D point2D, Point2D point2D2) {
        return (point2D.x * point2D2.x) + (point2D.y * point2D2.y);
    }

    public static Point2D xlShucheng(Point2D point2D, float f) {
        Point2D point2D2 = new Point2D();
        point2D2.x = point2D.x * f;
        point2D2.y = point2D.y * f;
        return point2D2;
    }

    public static float xlJi(Point2D point2D, Point2D point2D2) {
        return (point2D.x * point2D2.y) - (point2D.y * point2D2.x);
    }
}
