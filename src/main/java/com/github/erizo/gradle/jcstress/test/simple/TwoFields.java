package com.github.erizo.gradle.jcstress.test.simple;

public class TwoFields {

    long x;
    long y;

    public TwoFields(int x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }
}
