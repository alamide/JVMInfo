package com.alamide.jvm.clazz.constantpool;

import java.nio.ByteBuffer;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-09
 **/
public class ConstantMethodRefInfo extends ConstantBaseInfo {
    /**
     * 指向类描述符 Constant_Class_Info
     */
    private int constantClassInfoIndex;
    /**
     * 指向名称及类型描述符 Constant_Class_Info
     */
    private int constantNameAndTypeInfoIndex;

    public int getConstantClassInfoIndex() {
        return constantClassInfoIndex;
    }

    public void setConstantClassInfoIndex(int constantClassInfoIndex) {
        this.constantClassInfoIndex = constantClassInfoIndex;
    }

    public int getConstantNameAndTypeInfoIndex() {
        return constantNameAndTypeInfoIndex;
    }

    public void setConstantNameAndTypeInfoIndex(int constantNameAndTypeInfoIndex) {
        this.constantNameAndTypeInfoIndex = constantNameAndTypeInfoIndex;
    }

    @Override
    public int tag() {
        return 0x0A;
    }

    @Override
    public String print(int index) {
        return String.format("%4s = %-20s%-20s// %s",
                "#" + index,
                "MethodRef",
                "#" + constantClassInfoIndex + ".#" + constantNameAndTypeInfoIndex,
                content());
    }

    @Override
    public String content() {
        return String.format(
                "%s.%s",
                ConstantPoolInfo.CONSTANT_POOL_INFOS.get(constantClassInfoIndex).content(),
                ConstantPoolInfo.CONSTANT_POOL_INFOS.get(constantNameAndTypeInfoIndex).content()
        );
    }

    @Override
    protected void readInternal(ByteBuffer byteBuffer) {
        this.constantClassInfoIndex = twoBytesToInteger(byteBuffer.get(), byteBuffer.get());
        this.constantNameAndTypeInfoIndex = twoBytesToInteger(byteBuffer.get(), byteBuffer.get());
    }
}
