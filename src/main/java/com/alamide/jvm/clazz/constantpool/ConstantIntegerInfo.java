package com.alamide.jvm.clazz.constantpool;

import java.nio.ByteBuffer;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-09
 **/
public class ConstantIntegerInfo extends ConstantBaseInfo {
    private byte[] bytes;

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public int tag() {
        return 0x03;
    }

    @Override
    public String print(int index) {
        return String.format("%4s = %-20s%s", "#"+index, "Integer", this);
    }

    @Override
    public String content() {
        return toString();
    }

    @Override
    public String toString() {
        Integer d = (bytes[0] & 0xFF << 24) |(bytes[1]&0xFF << 16) |(bytes[2] &0xFF << 8) | bytes[3] & 0xFF;
        return String.valueOf(d);
    }

    @Override
    protected void readInternal(ByteBuffer byteBuffer) {
        this.bytes = new byte[4];
        byteBuffer.get(bytes);
    }
}
