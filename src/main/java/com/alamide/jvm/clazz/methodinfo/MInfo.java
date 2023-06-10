package com.alamide.jvm.clazz.methodinfo;

import com.alamide.jvm.clazz.BaseInfo;
import com.alamide.jvm.clazz.attributeinfo.AttrInfo;
import com.alamide.jvm.clazz.attributeinfo.AttrInfoManager;
import com.alamide.jvm.clazz.common.AccessFlags;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-10
 **/
public class MInfo extends BaseInfo {
    private int accessFlags;
    private String accessFlagsConcat;
    private int nameIndex;
    private String name;
    private int descriptorIndex;
    private String descriptor;
    private int attributesCount;
    private List<AttrInfo> attributes = new ArrayList<>();

    @Override
    protected void readInternal(ByteBuffer byteBuffer) {
        accessFlags = readU2(byteBuffer);
        accessFlagsConcat = AccessFlags.deCompose(accessFlags);
        nameIndex = readU2(byteBuffer);
        name = readConstantPool(nameIndex);
        descriptorIndex = readU2(byteBuffer);
        descriptor = readConstantPool(descriptorIndex);
        attributesCount = readU2(byteBuffer);
        attributes = AttrInfoManager.readAttrs(attributesCount, byteBuffer);
    }

    @Override
    public String toString() {
        return name + ":" + descriptor;
    }
}
