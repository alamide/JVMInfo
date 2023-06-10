package com.alamide.jvm.clazz.fieldinfo;

import com.alamide.jvm.clazz.BaseInfo;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-09
 **/
public class FieldsInfo extends BaseInfo {
    private int fieldsCount;
    private List<FInfo> fieldsInfo;

    @Override
    protected void readInternal(ByteBuffer byteBuffer) {
        fieldsCount = readU2(byteBuffer);
        if (fieldsCount > 0) {
            fieldsInfo = new ArrayList<>(fieldsCount);
            for (int i = 0; i < fieldsCount; i++) {
                FInfo fInfo = new FInfo();
                fInfo.read(byteBuffer);
                fieldsInfo.add(fInfo);
            }
        }
    }

    @Override
    protected String partName() {
        return "fields_info";
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (FInfo info : fieldsInfo) {
            stringBuilder.append(info).append("\n");
        }
        return super.toString() + stringBuilder;
    }
}
