package com.alamide.jvm.clazz.attributeinfo;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-10
 **/
public class AttrInfoLineNumberTable extends AttrInfo {
    private int lineNumberTableLength;
    private List<LineNumberTable> lineNumberTableList = new ArrayList<>();

    private static class LineNumberTable {
        int startPC;
        int lineNumber;
    }

    @Override
    protected void readInternal(ByteBuffer byteBuffer) {
        attributeLength = readU4(byteBuffer);
        lineNumberTableLength = readU2(byteBuffer);
        for (int i = 0; i < lineNumberTableLength; i++) {
            LineNumberTable lineNumberTable = new LineNumberTable();
            lineNumberTable.startPC = readU2(byteBuffer);
            lineNumberTable.lineNumber = readU2(byteBuffer);
            lineNumberTableList.add(lineNumberTable);
        }
    }

    @Override
    public String name() {
        return "LineNumberTable";
    }
}
