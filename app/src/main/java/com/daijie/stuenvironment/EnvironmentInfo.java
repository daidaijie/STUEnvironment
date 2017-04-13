package com.daijie.stuenvironment;

import android.support.annotation.DrawableRes;

/**
 * Created by liyujie on 2017/4/13.
 */

public class EnvironmentInfo {

    private final String name;

    private final String unit;

    @DrawableRes
    private final int icon;

    private double number;

    public EnvironmentInfo(String name, String unit, @DrawableRes int icon) {
        this.name = name;
        this.unit = unit;
        this.icon = icon;
    }

    public double getNumber() {
        return number;
    }

    public EnvironmentInfo setNumber(double number) {
        this.number = number;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int getIcon() {
        return icon;
    }
}
