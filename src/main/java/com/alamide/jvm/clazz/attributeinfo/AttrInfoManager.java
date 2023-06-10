package com.alamide.jvm.clazz.attributeinfo;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-10
 **/
public class AttrInfoManager {
    public static final List<AttrInfo> ATTRIBUTE_INFOS = new ArrayList<>();


    static {
        ATTRIBUTE_INFOS.add(new AttrInfoConstantValue());
        ATTRIBUTE_INFOS.add(new AttrInfoCode());
        ATTRIBUTE_INFOS.add(new AttrInfoLineNumberTable());
        ATTRIBUTE_INFOS.add(new AttrInfoLocalVariableTable());
        ATTRIBUTE_INFOS.add(new AttrInfoSourceFile());
    }

    public static List<AttrInfo> readAttrs(int attributesCount, ByteBuffer byteBuffer) {
        if (attributesCount == 0) return null;
        List<AttrInfo> attrInfoList = new ArrayList<>(attributesCount);
        for (int i = 0; i < attributesCount; i++) {
            byte byte1 = byteBuffer.get();
            byte byte2 = byteBuffer.get();

            for (AttrInfo info : AttrInfoManager.ATTRIBUTE_INFOS) {
                if (info.isMatch(byte1, byte2)) {
                    info.read(byteBuffer);
                    attrInfoList.add(info.cloneBean());
                }
            }
        }
        return attrInfoList;
    }
}
