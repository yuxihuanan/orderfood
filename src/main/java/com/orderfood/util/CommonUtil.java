package com.orderfood.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CommonUtil {

    public static String IndentCode(){
        String head="CTGLXT";
        long center = System.currentTimeMillis();
        return head+center;
    }
}
