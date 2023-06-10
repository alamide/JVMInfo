package com.alamide.jvm;

import java.io.Serializable;

/**
 * @Project: JVMInfo
 * @Author: alamide
 * @Date: 2023-06-09
 **/
public class HelloWorld implements Serializable, Cloneable {
    private static final int TAG = 1;

    private int count = 0;

    public static void sayHello(){
        System.out.println("Say Hello!");
    }

    public int getCount() {
        return count;
    }
}
