package com.yuen;

import com.yuen.observer.ObserverController;

/**
 * @author: yuen.cy
 * @description:
 * @since 9:45 2021/4/30
 */
public class Start {
    public static void main(String[] args) {
        ObserverController controller = new ObserverController();
        new Thread(() -> {
            controller.attachForEver(Start.Event.class, () -> System.out.println("1"));
        }).start();
        new Thread(() -> {
            controller.attachOne(Start.Event.class, () -> System.out.println("2"));
        }).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            controller.fire(Start.Event.class);
        }).start();
        new Thread(() -> {
            controller.fire(Start.Event.class);
        }).start();

    }

    public static interface Event {
    }
}

