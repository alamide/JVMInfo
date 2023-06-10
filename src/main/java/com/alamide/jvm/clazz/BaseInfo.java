package com.alamide.jvm.clazz;

import com.alamide.jvm.clazz.constantpool.ConstantPoolInfo;
import com.alamide.jvm.clazz.utils.ByteUtils;
import com.alamide.jvm.clazz.utils.PrintUtils;

import java.nio.ByteBuffer;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-09
 **/
public abstract class BaseInfo implements Read {
    protected int startIndex = -1;
    protected int endIndex = -1;

    protected abstract void readInternal(ByteBuffer byteBuffer);

    protected String partName(){
        return "Not Set";
    };

    @Override
    public String toString() {
        String startOffset = PrintUtils.calculateOffset(startIndex);
        String endOffset = PrintUtils.calculateOffset(endIndex);
        return PrintUtils.divider() + "\n" +
                "This part is " + partName() + ", byte index from " + startIndex + " to " + endIndex + "\n" +
                "Start location is " + startOffset + "\n" +
                "End   location is " + endOffset + "\n\n";
    }

    @Override
    public final int read(ByteBuffer byteBuffer) {
        startIndex = byteBuffer.position();
        readInternal(byteBuffer);
        endIndex = byteBuffer.position();
        return endIndex - startIndex;
    }

    protected String readConstantPool(int index) {
        return ConstantPoolInfo.CONSTANT_POOL_INFOS.get(index).content();
    }

    protected String readConstantPool(byte byte1, byte byte2) {
        return readConstantPool(ByteUtils.twoBytesToInteger(byte1, byte2));
    }

    protected int readU4(byte byte1, byte byte2, byte byte3, byte byte4) {
        return ByteUtils.fourBytesToInteger(byte1, byte2, byte3, byte4);
    }

    protected int readU4(ByteBuffer byteBuffer) {
        return readU4(byteBuffer.get(), byteBuffer.get(), byteBuffer.get(), byteBuffer.get());
    }

    protected int readU2(byte byte1, byte byte2) {
        return ByteUtils.twoBytesToInteger(byte1, byte2);
    }

    protected int readU2(ByteBuffer byteBuffer) {
        return readU2(byteBuffer.get(), byteBuffer.get());
    }

    protected int readU1(byte byte1) {
        return ByteUtils.oneBytesToInteger(byte1);
    }

    protected int readU1(ByteBuffer byteBuffer) {
        return readU1(byteBuffer.get());
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
}
