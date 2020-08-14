package designPattern.creationalPatterns.singleton;

public class Demo {
    public static void main(String[] args) {
        SingleObject object = SingleObject.getInstance();
        object.showMessage();

        Singleton1 singleton1 = Singleton1.getInstance();
        singleton1.showMessage();

        Singleton2 singleton2 = Singleton2.getInstance();
        singleton2.showMessage();

        Singleton3 singleton3= Singleton3.getInstance();
        singleton3.showMessage();

        Singleton4 singleton4 = Singleton4.getSingleton();
        singleton4.showMessage();

        Singleton5 singleton5 = Singleton5.getInstance();
        singleton5.showMessage();

        Singleton6 singleton6 = Singleton6.INSTANCE;
        singleton6.showMessage();
    }
}