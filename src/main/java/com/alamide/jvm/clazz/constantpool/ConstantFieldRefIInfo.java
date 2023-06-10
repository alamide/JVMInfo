package com.alamide.jvm.clazz.constantpool;

import java.nio.ByteBuffer;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-09
 **/
public class ConstantFieldRefIInfo extends ConstantBaseInfo {
    private int constantClassInfoIndex;
    private int constantNameAndTypeIndex;


    @Override
    public String toString() {
        return "ConstantFieldRefIInfo{" +
                "constantClassInfoIndex=" + constantClassInfoIndex +
                ", constantNameAndTypeIndex=" + constantNameAndTypeIndex +
                '}';
    }

    public void setConstantClassInfoIndex(int constantClassInfoIndex) {
        this.constantClassInfoIndex = constantClassInfoIndex;
    }

    public void setConstantNameAndTypeIndex(int constantNameAndTypeIndex) {
        this.constantNameAndTypeIndex = constantNameAndTypeIndex;
    }

    public int getConstantClassInfoIndex() {
        return constantClassInfoIndex;
    }

    public int getConstantNameAndTypeIndex() {
        return constantNameAndTypeIndex;
    }

    @Override
    public int tag() {
        return 0x09;
    }

    @Override
    public String print(int index) {
        return String.format("%4s = %-20s%-20s// %s",
                "#" + index,
                "FieldRef",
                "#" + constantClassInfoIndex + ".#" + constantNameAndTypeIndex,
                content());
    }

    @Override
    public String content() {
        return String.format(
                "%s.%s",
                ConstantPoolInfo.CONSTANT_POOL_INFOS.get(constantClassInfoIndex).content(),
                ConstantPoolInfo.CONSTANT_POOL_INFOS.get(constantNameAndTypeIndex).content()
        );
    }

    @Override
    protected void readInternal(ByteBuffer byteBuffer) {
        this.constantClassInfoIndex = twoBytesToInteger(byteBuffer.get(), byteBuffer.get());
        this.constantNameAndTypeIndex = twoBytesToInteger(byteBuffer.get(), byteBuffer.get());
    }
}
