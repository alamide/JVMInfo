package com.alamide.jvm.clazz.simple;

import com.alamide.jvm.clazz.utils.ByteUtils;
import com.alamide.jvm.clazz.BaseInfo;
import com.alamide.jvm.clazz.interfaceinfo.InterfaceInfo;

import java.nio.ByteBuffer;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-09
 **/
public class ClassInfo extends BaseInfo {
    public static final int ACC_PUBLIC = 0x0001;
    public static final int ACC_FINAL = 0x0010;
    public static final int ACC_SUPER = 0x0020;
    public static final int ACC_INTERFACE = 0x0200;
    public static final int ACC_ABSTRACT = 0x0400;
    public static final int ACC_SYNTHETIC = 0x1000;
    public static final int ACC_ANNOTATION = 0x2000;
    public static final int ACC_ENUM = 0x4000;
    private String accessFlagsStr;
    private String accessModifier;
    private String thisClass;
    private String superClass;
    private InterfaceInfo interfaceInfo = new InterfaceInfo();


    @Override
    protected void readInternal(ByteBuffer byteBuffer) {
        readAccessFlag(byteBuffer);
        readThisClass(byteBuffer);
        readSuperClass(byteBuffer);
        interfaceInfo.read(byteBuffer);
    }

    @Override
    protected String partName() {
        return "access_flags + this_class + super_class + interfaces";
    }

    private void readAccessFlag(ByteBuffer byteBuffer) {
        int accessFlags = ByteUtils.twoBytesToInteger(byteBuffer.get(), byteBuffer.get());
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder accessFlagsStrBuilder = new StringBuilder();
        if ((accessFlags & ACC_PUBLIC) != 0) {
            accessFlagsStrBuilder.append("ACC_PUBLIC ");
            stringBuilder.append("public ");
        }

        if ((accessFlags & ACC_FINAL) != 0) {
            accessFlagsStrBuilder.append("ACC_FINAL ");
            stringBuilder.append("final ");
        }

        if ((accessFlags & ACC_SUPER) != 0) {
            accessFlagsStrBuilder.append("ACC_SUPER ");
        }
        if ((accessFlags & ACC_INTERFACE) != 0) {
            accessFlagsStrBuilder.append("ACC_INTERFACE ");
            stringBuilder.append("interface ");
        }
        if ((accessFlags & ACC_ABSTRACT) != 0) {
            accessFlagsStrBuilder.append("ACC_FINAL ");
            stringBuilder.append("abstract ");
        }
        if ((accessFlags & ACC_SYNTHETIC) != 0) {
            accessFlagsStrBuilder.append("ACC_ABSTRACT ");
            stringBuilder.append("ACC_SYNTHETIC ");
        }
        if ((accessFlags & ACC_ANNOTATION) != 0) {
            accessFlagsStrBuilder.append("ACC_ANNOTATION ");
            stringBuilder.append("annotation ");
        }
        if ((accessFlags & ACC_ENUM) != 0) {
            accessFlagsStrBuilder.append("ACC_ENUM ");
            stringBuilder.append("enum ");
        }

        accessModifier = stringBuilder.toString();
        accessFlagsStr = accessFlagsStrBuilder.toString();
    }

    private void readThisClass(ByteBuffer byteBuffer) {
        thisClass = readConstantPool(byteBuffer.get(), byteBuffer.get());
    }

    private void readSuperClass(ByteBuffer byteBuffer) {
        superClass = readConstantPool(byteBuffer.get(), byteBuffer.get());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("AccessFlags: ").append(accessFlagsStr).append("\n")
                .append("This Class: ").append(thisClass).append("\n")
                .append("Super Class: ").append(superClass).append("\n")
                .append("Interface Count: ").append(interfaceInfo.getInterfaceCount()).append("\n")
                .append("[").append(interfaceInfo.getInterfaceConcat()).append("]").append("\n")
                .append(accessModifier).append(" class ").append(thisClass).append(" extends ").append(superClass);
        if (interfaceInfo.getInterfaceCount() > 0) {
            stringBuilder.append(" implements ").append(interfaceInfo.getInterfaceConcat());
        }
        return super.toString() + stringBuilder.toString();
    }
}
