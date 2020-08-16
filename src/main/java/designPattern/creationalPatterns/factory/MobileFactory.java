package designPattern.creationalPatterns.factory;

import designPattern.creationalPatterns.factory.firm.MobilePhone;
import designPattern.creationalPatterns.factory.firm.xiaomi.Mi10;
import designPattern.creationalPatterns.factory.firm.xiaomi.Mi6;
import designPattern.creationalPatterns.factory.firm.xiaomi.Mi8;

/**
 * 手机工厂
 */
public class MobileFactory {

    /**
     * 用户调用此方法得到手机
     *
     * @param model - 手机型号
     * @return
     */
    public MobilePhone BuyMobilePhone(String model) throws Exception {
        if (model == null) {
            throw new Exception("手机型号为空");
        }
        if ("MI6".equalsIgnoreCase(model)) {
            return new Mi6();
        } else if ("MI8".equalsIgnoreCase(model)) {
            return new Mi8();
        } else if ("MI10".equalsIgnoreCase(model)) {
            return new Mi10();
        } else {
            throw new Exception("手机型号不存在");
        }
    }
}