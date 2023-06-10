package com.alamide.jvm.clazz.attributeinfo;

import com.alamide.jvm.clazz.BaseInfo;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-10
 **/
public class LastPartAttrInfo extends BaseInfo {
    private int attributesCount;
    private List<AttrInfo> attrInfoList = new ArrayList<>();

    @Override
    protected void readInternal(ByteBuffer byteBuffer) {
        attributesCount = readU2(byteBuffer);
        attrInfoList = AttrInfoManager.readAttrs(attributesCount, byteBuffer);
    }

    @Override
    protected String partName() {
        return "attribute_info";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
