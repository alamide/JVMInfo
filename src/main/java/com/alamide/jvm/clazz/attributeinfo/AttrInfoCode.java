package com.alamide.jvm.clazz.attributeinfo;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-10
 **/
public class AttrInfoCode extends AttrInfo {
    private int maxStack;
    private int maxLocals;
    private int codeLength;
    private List<Integer> codes = new ArrayList<>();
    private int exceptionTableLength;
    private List<ExceptionTable> exceptionTables = new ArrayList<>();
    private int attributesCount;
    private List<AttrInfo> attrInfoList = new ArrayList<>();

    private static class ExceptionTable {
        int startPC;
        int endPC;
        int handlePC;
        int catchType;
    }

    @Override
    protected void readInternal(ByteBuffer byteBuffer) {
        attributeLength = readU4(byteBuffer);
        maxStack = readU2(byteBuffer);
        maxLocals = readU2(byteBuffer);
        codeLength = readU4(byteBuffer);
        for (int i = 0; i < codeLength; i++) {
            codes.add(readU1(byteBuffer));
        }
        exceptionTableLength = readU2(byteBuffer);
        for (int i = 0; i < exceptionTableLength; i++) {
            ExceptionTable exceptionTable = new ExceptionTable();
            exceptionTable.startPC = readU2(byteBuffer);
            exceptionTable.endPC = readU2(byteBuffer);
            exceptionTable.handlePC = readU2(byteBuffer);
            exceptionTable.catchType = readU2(byteBuffer);
            exceptionTables.add(exceptionTable);
        }

        attributesCount = readU2(byteBuffer);
        attrInfoList = AttrInfoManager.readAttrs(attributesCount, byteBuffer);
    }

    @Override
    public String name() {
        return "Code";
    }
}
