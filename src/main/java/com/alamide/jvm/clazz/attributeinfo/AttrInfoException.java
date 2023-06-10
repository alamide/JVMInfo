package com.alamide.jvm.clazz.attributeinfo;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-10
 **/
public class AttrInfoException extends AttrInfo {
    private int numberOfExceptions;
    private List<Integer> exceptionIndexList;
    private List<String> exceptions;

    @Override
    protected void readInternal(ByteBuffer byteBuffer) {
        attributeLength = readU4(byteBuffer);
        numberOfExceptions = readU2(byteBuffer);
        if (numberOfExceptions > 0) {
            exceptionIndexList = new ArrayList<>();
            exceptions = new ArrayList<>(numberOfExceptions);
            for (int i = 0; i < numberOfExceptions; i++) {
                int index = readU2(byteBuffer);
                exceptionIndexList.add(index);
                exceptions.add(readConstantPool(index));
            }
        }
    }

    @Override
    public String name() {
        return "";
    }
}
