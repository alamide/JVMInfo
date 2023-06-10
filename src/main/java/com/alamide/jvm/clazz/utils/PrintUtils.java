package com.alamide.jvm.clazz.utils;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-10
 **/
public class PrintUtils {
    public static void printOffset(int offset) {
        printDivider();
        System.out.println(calculateOffset(offset));
    }

    public static void printDivider() {
        System.out.println(divider());
    }

    public static String divider(int delimNumber) {
        return "-".repeat(delimNumber);
    }

    public static String divider() {
        return divider(90);
    }

    public static String calculateOffset(int offset) {
        return String.format("Point: (%s, %s)", String.format("%8s", Integer.toHexString(offset / 16 * 16)).replace(" ", "0").toUpperCase(), Integer.toHexString(offset % 16).toUpperCase());
    }
}
