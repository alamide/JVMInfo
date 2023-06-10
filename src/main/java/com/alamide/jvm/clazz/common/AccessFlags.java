package com.alamide.jvm.clazz.common;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-10
 **/
public class AccessFlags {
    private static final int ACC_PUBLIC = 0x0001;
    private static final int ACC_PRIVATE = 0x0002;
    private static final int ACC_PROTECTED = 0x0004;
    private static final int ACC_STATIC = 0x0008;
    private static final int ACC_FINAL = 0x0010;
    private static final int ACC_SYNCHRONIZED = 0x0020;
    private static final int ACC_VOLATILE = 0x0040;
    private static final int ACC_TRANSIENT = 0x0080;
    private static final int ACC_SYNTHETIC = 0x1000;
    private static final int ACC_ENUM = 0x4000;

    public static String deCompose(int accessFlags) {
        List<String> modifiers = new ArrayList<>();
        if ((accessFlags & ACC_PUBLIC) != 0) {
            modifiers.add("public");
        }
        if ((accessFlags & ACC_PRIVATE) != 0) {
            modifiers.add("private");
        }

        if ((accessFlags & ACC_PROTECTED) != 0) {
            modifiers.add("protected");
        }
        if ((accessFlags & ACC_STATIC) != 0) {
            modifiers.add("static");
        }
        if ((accessFlags & ACC_FINAL) != 0) {
            modifiers.add("final");
        }
        if ((accessFlags & ACC_VOLATILE) != 0) {
            modifiers.add("volatile");
        }
        if ((accessFlags & ACC_TRANSIENT) != 0) {
            modifiers.add("transient");
        }

        if ((accessFlags & ACC_SYNCHRONIZED) != 0) {
            modifiers.add("synchronized");
        }
        return String.join(" ", modifiers);
    }
}
