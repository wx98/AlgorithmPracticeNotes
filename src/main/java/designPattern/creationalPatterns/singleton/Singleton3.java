package designPattern.creationalPatterns.singleton;

/**
 * 3、饿汉式
 */
public class Singleton3 {
    private static Singleton3 instance = new Singleton3();

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        return instance;
    }
    public void showMessage() {
        System.out.println("Singleton3 Message");
    }
}