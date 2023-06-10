package com.alamide.jvm.clazz.utils;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-09
 **/
public class ByteUtils {
    public static int oneBytesToInteger(byte byte1) {
        return byte1 & 0xFF;
    }
    public static int twoBytesToInteger(byte byte1, byte byte2) {
        return ((byte1 & 0xFF) << 8) | (byte2 & 0xFF);
    }

    public static int fourBytesToInteger(byte byte1, byte byte2, byte byte3, byte byte4) {
        return ((byte1 & 0xFF) << 24) | ((byte2 & 0xFF) << 16) | ((byte3 & 0xFF) << 8) | (byte4 & 0xFF);
    }
}
