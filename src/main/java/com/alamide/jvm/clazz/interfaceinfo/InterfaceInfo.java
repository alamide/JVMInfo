package com.alamide.jvm.clazz.interfaceinfo;

import com.alamide.jvm.clazz.utils.ByteUtils;
import com.alamide.jvm.clazz.BaseInfo;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-09
 **/
public class InterfaceInfo extends BaseInfo {
    private int interfaceCount = 0;
    private List<String> interfaces;
    private String interfaceConcat="";
    public int getInterfaceCount() {
        return interfaceCount;
    }

    public List<String> getInterfaces() {
        return interfaces;
    }

    public String getInterfaceConcat() {
        return interfaceConcat;
    }

    @Override
    protected void readInternal(ByteBuffer byteBuffer) {
        this.interfaceCount = ByteUtils.twoBytesToInteger(byteBuffer.get(), byteBuffer.get());
        if(interfaceCount > 0){
            //解析 Interface
            interfaces = new ArrayList<>(interfaceCount);
            for(int i=0; i<interfaceCount; i++){
                final String interfaceName = readConstantPool(byteBuffer.get(), byteBuffer.get());
                interfaces.add(interfaceName);
            }

            interfaceConcat = String.join(", ", interfaces);
        }
    }
}
