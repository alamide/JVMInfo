package com.alamide.jvm.clazz.constantpool;

import com.alamide.jvm.clazz.BaseInfo;
import com.alamide.jvm.clazz.Read;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-09
 **/
public abstract class ConstantBaseInfo extends BaseInfo {

    public abstract int tag();

    public boolean isMatch(byte byteTag) {
        return (byteTag & 0xFF) == tag();
    }

    protected int twoBytesToInteger(byte byte1, byte byte2) {
        return ((byte1 & 0xFF) << 8) | (byte2 & 0xFF);
    }

    public ConstantBaseInfo cloneBean() {

        try {
            return (ConstantBaseInfo) BeanUtils.cloneBean(this);
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract String print(int index);

    public abstract String content();
}
