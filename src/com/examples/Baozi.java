package com.examples;

public class Baozi {
    public static void main(String[] args) {
        Bao lock = new Bao();
        new Thread(() -> {
            System.out.println("need BeefBaozi");
            synchronized (lock) {
                while (!Bao.hasBeefBaozi) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Ear BeefBaozi");
                Bao.hasBeefBaozi = false;
            }
        }).start();

        new Thread(() -> {
            System.out.println("need PorkBaozi");
            synchronized (lock) {
                while (!Bao.hasPorkBaozi) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Ear PorkBaozi");
                Bao.hasPorkBaozi = false;
            }
        }).start();
        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (Bao.hasPorkBaozi || Bao.hasBeefBaozi) {
                        lock.notifyAll();
                    } else {
                        System.out.println("No baozi, wait...");
                        try {
                            lock.wait(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (Math.random() % 2 == 0) {
                            System.out.println("make BeefBaozi");
                            Bao.makeBao("Beef");
                        } else {
                            System.out.println("make PorkBaozi");
                            Bao.makeBao("Pork");
                        }
                        lock.notifyAll();
                    }
                }
            }
        }).start();
    }
}

class Bao {
    public static boolean hasBeefBaozi = false;
    public static boolean hasPorkBaozi = false;

    public static void makeBao(String xian) {
        if (xian.equals("Beef")) {
            hasBeefBaozi = true;
        }
        if (xian.equals("Pork")) {
            hasPorkBaozi = true;
        }

    }
}

