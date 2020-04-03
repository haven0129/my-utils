package com.haven.util;

/**
 * String类型的工具类
 */
public class StringUtil {
    // 判断一个字符串是否为空
    public static Boolean isEmptyOrNull(String str){
        if(str == null || str.trim().equals("")){
            return true;
        }
        return false;
    }

    // 判断一个字符串是否不为空
    public static Boolean isNotEmptyOrNull(String str){
        if(str == null || str.trim().equals("")){
            return false;
        }
        return true;
    }

    // 如果字符串为空，返回""字符串，否则返回本身
    public static String getStringValue(String str){
        if(isEmptyOrNull(str)){
            return "";
        }
        return str;
    }
}
