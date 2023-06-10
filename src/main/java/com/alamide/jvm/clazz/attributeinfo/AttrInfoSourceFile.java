package com.alamide.jvm.clazz.attributeinfo;

import java.nio.ByteBuffer;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-10
 **/
public class AttrInfoSourceFile extends AttrInfo{
    private int sourceFileIndex;
    private String sourceFileName;

    @Override
    protected void readInternal(ByteBuffer byteBuffer) {
        attributeLength = readU4(byteBuffer);
        sourceFileIndex = readU2(byteBuffer);
        sourceFileName = readConstantPool(sourceFileIndex);
    }

    @Override
    public String name() {
        return "SourceFile";
    }
}
