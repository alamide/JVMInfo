package com.alamide.jvm.clazz;

import com.alamide.jvm.clazz.attributeinfo.LastPartAttrInfo;
import com.alamide.jvm.clazz.constantpool.ConstantPoolInfo;
import com.alamide.jvm.clazz.fieldinfo.FieldsInfo;
import com.alamide.jvm.clazz.methodinfo.MethodsInfo;
import com.alamide.jvm.clazz.simple.ClassInfo;
import com.alamide.jvm.clazz.simple.MagicInfo;
import com.alamide.jvm.clazz.simple.VersionInfo;
import com.alamide.jvm.clazz.utils.PrintUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-09
 **/
public class ByteCodeRead {

    public static void main(String[] args) throws IOException, CloneNotSupportedException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        printByteCode("./target/classes/com/alamide/jvm/HelloWorld.class");
        System.out.println();
        deComposeByteCode("./target/classes/com/alamide/jvm/HelloWorld.class");
    }

    private static final List<Read> STRUCTURE_READ_LIST = new ArrayList<>();

    static {
        STRUCTURE_READ_LIST.add(new MagicInfo());
        STRUCTURE_READ_LIST.add(new VersionInfo());
        STRUCTURE_READ_LIST.add(new ConstantPoolInfo());
        /**
         * include
         * readAccessFlag(byteBuffer);
         * readThisClass(byteBuffer);
         * readSuperClass(byteBuffer);
         * interfaceInfo.read(byteBuffer);
         */
        STRUCTURE_READ_LIST.add(new ClassInfo());
        STRUCTURE_READ_LIST.add(new FieldsInfo());
        STRUCTURE_READ_LIST.add(new MethodsInfo());
        STRUCTURE_READ_LIST.add(new LastPartAttrInfo());
    }

    public static void printByteCode(String classFile) throws IOException {
        final byte[] bytes = readClassFileBytes(classFile);
        //Print Header
        System.out.printf("%8s ", "Offset");
        for (int j = 0; j < 16; j++) {
            System.out.print(String.format("%2s ", Integer.toHexString(j)).toUpperCase());
        }
        for (int i = 0; i < bytes.length; i++) {
            if (i % 16 == 0) {
                System.out.println();
                String offset = String.format("%8s", Integer.toHexString(i / 16 * 16)).replace(" ", "0");
                System.out.print(offset.toUpperCase());
                System.out.print(" ");
            }
            //无符号整形
            String formatByte = String.format("%2s", Integer.toHexString(bytes[i] & 0xFF)).replace(" ", "0");
            System.out.print(formatByte.toUpperCase());
            System.out.print(" ");
        }
    }

    private static byte[] readClassFileBytes(String classFile) throws IOException {
        return Files.readAllBytes(Paths.get(classFile));
    }

    public static void deComposeByteCode(String classFile) throws IOException {
        final byte[] bytes = readClassFileBytes(classFile);
        final ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);

        for (Read read : STRUCTURE_READ_LIST) {
            read.read(byteBuffer);
            System.out.println(read);
        }
    }

}
