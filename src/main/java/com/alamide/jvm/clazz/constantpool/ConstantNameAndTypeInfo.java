package com.alamide.jvm.clazz.constantpool;

import java.nio.ByteBuffer;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-09
 **/
public class ConstantNameAndTypeInfo extends ConstantBaseInfo {

    private int nameIndex;

    private int descIndex;

    public int getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(int nameIndex) {
        this.nameIndex = nameIndex;
    }

    public int getDescIndex() {
        return descIndex;
    }

    public void setDescIndex(int descIndex) {
        this.descIndex = descIndex;
    }


    @Override
    public int tag() {
        return 0x0C;
    }

    @Override
    public String print(int index) {
        return String.format("%4s = %-20s%-20s// %s",
                "#" + index,
                "NameAndType",
                "#" + nameIndex + ".#" + descIndex,
                content());
    }

    @Override
    public String content() {
        return String.format(
                "%s:%s",
                ConstantPoolInfo.CONSTANT_POOL_INFOS.get(nameIndex).content(),
                ConstantPoolInfo.CONSTANT_POOL_INFOS.get(descIndex).content()
        );
    }

    @Override
    protected void readInternal(ByteBuffer byteBuffer) {
        this.nameIndex = twoBytesToInteger(byteBuffer.get(), byteBuffer.get());
        this.descIndex = twoBytesToInteger(byteBuffer.get(), byteBuffer.get());
    }
}
