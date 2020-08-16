package designPattern.creationalPatterns.factory;

import designPattern.creationalPatterns.factory.firm.MobilePhone;

/**
 * 工厂模式的用户调用实例
 */
public class Demo {

    public static void main(String[] args) throws Exception {
        //1.我们需要一个手机
        MobilePhone mobilePhone;

        //2，我们需要得到一个手机工厂才能得到手机
        MobileFactory mobileFactory = new MobileFactory();

        //3.然后我们可以通过型号买手机了
        mobileFactory.BuyMobilePhone("MI6");

        //4.比如我们购买MI6后用它打电话,拍照等
        mobilePhone = mobileFactory.BuyMobilePhone("MI6");
        mobilePhone.startUp();
        mobilePhone.phone();
        mobilePhone.photograph();
        mobilePhone.shutDown();

        //或者我们得到一个MI10用MI10打电话,拍照等
        mobilePhone = mobileFactory.BuyMobilePhone("MI10");
        mobilePhone.startUp();
        mobilePhone.phone();
        mobilePhone.photograph();
        mobilePhone.shutDown();

    }
}