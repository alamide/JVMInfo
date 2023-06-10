package com.alamide.jvm.clazz.methodinfo;

import com.alamide.jvm.clazz.BaseInfo;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-09
 **/
public class MethodsInfo extends BaseInfo {
    private int methodsCount;
    private List<MInfo> methodsInfoList = new ArrayList<>();

    @Override
    protected void readInternal(ByteBuffer byteBuffer) {
        methodsCount = readU2(byteBuffer);
        for (int i = 0; i < methodsCount; i++) {
            MInfo mInfo = new MInfo();
            mInfo.read(byteBuffer);
            methodsInfoList.add(mInfo);
        }
    }

    @Override
    protected String partName() {
        return "method_info";
    }

    @Override
    public String toString() {
        return super.toString() + methodsInfoList.toString();
    }
}
