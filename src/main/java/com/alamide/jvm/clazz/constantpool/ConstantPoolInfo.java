package com.alamide.jvm.clazz.constantpool;

import com.alamide.jvm.clazz.BaseInfo;
import com.alamide.jvm.clazz.Read;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-09
 **/
public class ConstantPoolInfo extends BaseInfo {

    private static final List<ConstantBaseInfo> CONSTANT_BASE_INFO_LIST = new ArrayList<>();

    static {
        CONSTANT_BASE_INFO_LIST.add(new ConstantMethodRefInfo());
        CONSTANT_BASE_INFO_LIST.add(new ConstantFieldRefIInfo());
        CONSTANT_BASE_INFO_LIST.add(new ConstantClassInfo());
        CONSTANT_BASE_INFO_LIST.add(new ConstantUTF8Info());
        CONSTANT_BASE_INFO_LIST.add(new ConstantNameAndTypeInfo());
        CONSTANT_BASE_INFO_LIST.add(new ConstantStringInfo());
        CONSTANT_BASE_INFO_LIST.add(new ConstantIntegerInfo());
    }

    public static final List<ConstantBaseInfo> CONSTANT_POOL_INFOS = new ArrayList<>();

    static {
        //constant_pool_info 下标从 1 开始
        CONSTANT_POOL_INFOS.add(null);
    }

    @Override
    protected void readInternal(ByteBuffer byteBuffer) {
        final int constantPoolCount = Integer.parseInt(Integer.toHexString(byteBuffer.get() << 8 | byteBuffer.get() & 0xFFFF), 16);
        int count = 1;
        while (count < constantPoolCount) {
            byte tag = byteBuffer.get();
            for (ConstantBaseInfo baseInfo : CONSTANT_BASE_INFO_LIST) {
                if (baseInfo.isMatch(tag)) {
                    baseInfo.read(byteBuffer);
                    CONSTANT_POOL_INFOS.add(baseInfo.cloneBean());
                    break;
                }
            }
            count++;
        }
    }

    @Override
    protected String partName() {
        return "constant_pool";
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ConstantPoolCount: ").append(CONSTANT_POOL_INFOS.size() - 1).append("\n");
        for (int i = 1; i < CONSTANT_POOL_INFOS.size(); i++) {
            stringBuilder.append(CONSTANT_POOL_INFOS.get(i).print(i)).append("\n");
        }
        return super.toString() + stringBuilder;
    }
}
