package designPattern.creationalPatterns.factory.firm.xiaomi;

import designPattern.creationalPatterns.factory.firm.MobilePhone;

public class Mi10 implements MobilePhone {
    @Override
    public void phone() {
        System.out.println(this.getClass() + "打电话");
    }

    @Override
    public void photograph() {
        System.out.println(this.getClass() + "拍照");
    }

    @Override
    public void startUp() {
        System.out.println(this.getClass() + "开机");
    }

    @Override
    public void shutDown() {
        System.out.println(this.getClass() + "关机");
    }
}
