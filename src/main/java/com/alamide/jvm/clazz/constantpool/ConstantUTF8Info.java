package com.alamide.jvm.clazz.constantpool;

import java.nio.ByteBuffer;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-09
 **/
public class ConstantUTF8Info extends ConstantBaseInfo {
    private int length;
    private byte[] bytes;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }


    @Override
    public int tag() {
        return 0x01;
    }

    @Override
    public String print(int index) {
        return String.format("%4s = %-20s%s", "#" + index, "Utf8", this);
    }

    @Override
    public String toString() {
        return new String(bytes);
    }

    @Override
    public String content() {
        return this.toString();
    }

    @Override
    protected void readInternal(ByteBuffer byteBuffer) {
        this.length = twoBytesToInteger(byteBuffer.get(), byteBuffer.get());
        this.bytes = new byte[this.length];
        byteBuffer.get(bytes);
    }
}
