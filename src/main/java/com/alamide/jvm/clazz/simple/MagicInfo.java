package com.alamide.jvm.clazz.simple;

import com.alamide.jvm.clazz.BaseInfo;
import com.alamide.jvm.clazz.Read;

import java.nio.ByteBuffer;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-09
 * @Desc: u4 magic 1
 **/
public class MagicInfo extends BaseInfo {

    private String magic = null;

    @Override
    protected void readInternal(ByteBuffer byteBuffer) {
        magic = Integer.toHexString(byteBuffer.get() & 0xFF) +
                Integer.toHexString(byteBuffer.get() & 0xFF) +
                Integer.toHexString(byteBuffer.get() & 0xFF) +
                Integer.toHexString(byteBuffer.get() & 0xFF);
    }

    @Override
    protected String partName() {
        return "magic";
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("Magic: %s", magic).toUpperCase();
    }
}
