package com.alamide.jvm.clazz.attributeinfo;

import com.alamide.jvm.clazz.utils.ByteUtils;
import com.alamide.jvm.clazz.BaseInfo;
import com.alamide.jvm.clazz.constantpool.ConstantPoolInfo;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-09
 **/
public abstract class AttrInfo extends BaseInfo {

    protected int attributeNameIndex;
    protected String attributeName;

    protected int attributeLength;

    public boolean isMatch(byte byte1, byte byte2) {
        attributeNameIndex = ByteUtils.twoBytesToInteger(byte1, byte2);
        attributeName = ConstantPoolInfo.CONSTANT_POOL_INFOS.get(attributeNameIndex).content();
        return Objects.equals(attributeName, name());
    }

    public abstract String name();

    public int getAttributeNameIndex() {
        return attributeNameIndex;
    }

    public void setAttributeNameIndex(int attributeNameIndex) {
        this.attributeNameIndex = attributeNameIndex;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public int getAttributeLength() {
        return attributeLength;
    }

    public void setAttributeLength(int attributeLength) {
        this.attributeLength = attributeLength;
    }

    public AttrInfo cloneBean() {
        try {
            return (AttrInfo) BeanUtils.cloneBean(this);
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
