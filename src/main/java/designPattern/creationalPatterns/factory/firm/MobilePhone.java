package designPattern.creationalPatterns.factory.firm;

public interface MobilePhone {
    /**
     * 打电话
     */
    public void phone();

    /**
     * 拍照
     */
    public void photograph();

    /**
     * 开机
     */
    public void startUp();

    /**
     * 关机
     */
    public void shutDown();
}