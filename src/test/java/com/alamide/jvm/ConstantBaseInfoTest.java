package com.alamide.jvm;

import com.alamide.jvm.clazz.constantpool.ConstantFieldRefIInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

class ConstantBaseInfoTest {
    @Test
    public void test() throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        ConstantFieldRefIInfo constantFieldRefIInfo = new ConstantFieldRefIInfo();
        constantFieldRefIInfo.setConstantClassInfoIndex(10);
        constantFieldRefIInfo.setConstantNameAndTypeIndex(1);
        System.out.println(BeanUtils.cloneBean(constantFieldRefIInfo));
    }
}