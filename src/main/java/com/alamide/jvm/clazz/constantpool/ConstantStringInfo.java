package com.alamide.jvm.clazz.constantpool;

import java.nio.ByteBuffer;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-09
 **/
public class ConstantStringInfo extends ConstantBaseInfo {
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    @Override
    public int tag() {
        return 0x08;
    }

    @Override
    public String print(int index) {
        return String.format("%4s = %-20s%-20s// %s",
                "#" + index,
                "String",
                "#" + this.index,
                content());
    }

    @Override
    public String content() {
        return String.format(
                "%s",
                ConstantPoolInfo.CONSTANT_POOL_INFOS.get(this.index).content()
        );
    }

    @Override
    protected void readInternal(ByteBuffer byteBuffer) {
        this.index = twoBytesToInteger(byteBuffer.get(), byteBuffer.get());
    }
}
