package com.alamide.jvm.clazz.fieldinfo;

import com.alamide.jvm.clazz.BaseInfo;
import com.alamide.jvm.clazz.attributeinfo.AttrInfo;
import com.alamide.jvm.clazz.attributeinfo.AttrInfoConstantValue;
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
public class FInfo extends BaseInfo {
    private int accessFlags;
    private String accessFlagConcat;
    private int nameIndex;
    private String name;
    private int descriptorIndex;
    private String descriptor;
    private int attributeCount;
    private List<AttrInfo> attrInfos;


    @Override
    protected void readInternal(ByteBuffer byteBuffer) {
        accessFlags = readU2(byteBuffer);
        accessFlagConcat = AccessFlags.deCompose(accessFlags);

        nameIndex = readU2(byteBuffer);
        descriptorIndex = readU2(byteBuffer);
        name = readConstantPool(nameIndex);
        descriptor = readConstantPool(descriptorIndex);
        attributeCount = readU2(byteBuffer);
        attrInfos = AttrInfoManager.readAttrs(attributeCount, byteBuffer);
    }

    public int getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(int accessFlags) {
        this.accessFlags = accessFlags;
    }

    public String getAccessFlagConcat() {
        return accessFlagConcat;
    }

    public void setAccessFlagConcat(String accessFlagConcat) {
        this.accessFlagConcat = accessFlagConcat;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(int nameIndex) {
        this.nameIndex = nameIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(int descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public int getAttributeCount() {
        return attributeCount;
    }

    public void setAttributeCount(int attributeCount) {
        this.attributeCount = attributeCount;
    }

    public List<AttrInfo> getAttrInfos() {
        return attrInfos;
    }

    public void setAttrInfos(List<AttrInfo> attrInfos) {
        this.attrInfos = attrInfos;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AccessFlags: ").append(accessFlagConcat).append("\n")
                .append("Descriptor: ").append(descriptor).append("\n")
                .append("Name: ").append(name).append("\n")
                .append(accessFlagConcat).append(" ").append(descriptor).append(" ").append(name);
        return stringBuilder.toString();
    }
}
