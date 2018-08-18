package com.sda.MapyGoogle;

public class Place {
    private static double lan;
    private static double lng;
    private String name;

    public static double getLan() {
        return lan;
    }

    public void setLan(double lan) {
        this.lan = lan;
    }

    public static double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return name + "{" +
                "lan=" + lan +
                ", lng=" + lng +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
