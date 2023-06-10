package com.alamide.jvm.clazz.attributeinfo;

import java.nio.ByteBuffer;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-09
 **/
public class AttrInfoConstantValue extends AttrInfo {
    private int constantValueIndex;
    private String constantValue;

    @Override
    public String name() {
        return "ConstantValue";
    }

    @Override
    protected void readInternal(ByteBuffer byteBuffer) {
        //多于，肯定为 2
        attributeLength = readU4(byteBuffer);
        if(attributeLength != 2){
            throw new IllegalStateException("ConstantValue length must = 2");
        }
        constantValueIndex = readU2(byteBuffer);
        constantValue = readConstantPool(constantValueIndex);
    }

    public int getConstantValueIndex() {
        return constantValueIndex;
    }

    public void setConstantValueIndex(int constantValueIndex) {
        this.constantValueIndex = constantValueIndex;
    }

    public String getConstantValue() {
        return constantValue;
    }

    public void setConstantValue(String constantValue) {
        this.constantValue = constantValue;
    }
}
