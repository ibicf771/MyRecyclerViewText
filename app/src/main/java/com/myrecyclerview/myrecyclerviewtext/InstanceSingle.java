package com.myrecyclerview.myrecyclerviewtext;

public class InstanceSingle {

    private static volatile InstanceSingle singleton;

    private InstanceSingle() {
    }

    public static InstanceSingle getInstance() {
        if (singleton == null) {
            synchronized (InstanceSingle.class) {
                if (singleton == null) {
                    singleton = new InstanceSingle();
                }
            }
        }
        return singleton;
    }
}