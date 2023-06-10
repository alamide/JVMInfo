package com.alamide.jvm.clazz.simple;

import com.alamide.jvm.clazz.BaseInfo;
import com.alamide.jvm.clazz.Read;

import java.nio.ByteBuffer;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-09
 **/
public class VersionInfo extends BaseInfo {
    private int minorVersion;
    private int majorVersion;

    @Override
    protected void readInternal(ByteBuffer byteBuffer) {
        minorVersion = Integer.parseInt(Integer.toHexString(byteBuffer.get() << 8 | byteBuffer.get() & 0xFFFF), 16);
        majorVersion = Integer.parseInt(Integer.toHexString(byteBuffer.get() << 8 | byteBuffer.get() & 0xFFFF), 16);
    }

    @Override
    protected String partName() {
        return "minor_version + major_version";
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Version: %d.%d", majorVersion, minorVersion);
    }
}
