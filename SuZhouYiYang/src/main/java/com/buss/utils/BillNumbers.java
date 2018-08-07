package com.buss.utils;

import org.apache.commons.lang.math.RandomUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Jimmy
 * @create 2018-06-24 11:32
 * @desc
 **/
public class BillNumbers {
    public String commonNumber(String prefix){
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
        int random= RandomUtils.nextInt(90)+10;
        return prefix+format.format(new Date())+random;
    }
}
