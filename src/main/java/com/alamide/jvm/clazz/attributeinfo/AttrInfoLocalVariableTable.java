package com.alamide.jvm.clazz.attributeinfo;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-10
 **/
public class AttrInfoLocalVariableTable extends AttrInfo {
    private int localVariableTableLength;
    private List<LocalVariableTable> localVariableTableList = new ArrayList<>();

    private static class LocalVariableTable {
        int startPC;
        int length;
        int nameIndex;
        int descriptorIndex;
        int index;
    }

    @Override
    protected void readInternal(ByteBuffer byteBuffer) {
        attributeLength = readU4(byteBuffer);
        localVariableTableLength = readU2(byteBuffer);

        for (int i = 0; i < localVariableTableLength; i++) {
            LocalVariableTable table = new LocalVariableTable();
            table.startPC = readU2(byteBuffer);
            table.length = readU2(byteBuffer);
            table.nameIndex = readU2(byteBuffer);
            table.descriptorIndex = readU2(byteBuffer);
            table.index = readU2(byteBuffer);
            localVariableTableList.add(table);
        }
    }

    @Override
    public String name() {
        return "LocalVariableTable";
    }
}
