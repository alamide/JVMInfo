package com.alamide.jvm.clazz;

import java.nio.ByteBuffer;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-09
 **/
public interface Read {
    /**
     *
     * @param byteBuffer
     * @return 读取的字节数
     */
    int read(ByteBuffer byteBuffer);
}
