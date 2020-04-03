package com.haven.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * list类型的一些工具类
 */
public class ListUtil {
    // 判断list是否为空
    public static <T> Boolean isNull(List<T> list) {
        if(list == null || list.size() == 0){
            return true;
        }
        return false;
    }
    // 判断list是否不为空
    public static <T> Boolean isNotNull(List<T> list) {
        if(list != null && list.size() > 0){
            return true;
        }
        return false;
    }

    /**
     * 移除重复的数据(不能给对象使用，会报错，可以给String,Long等类型使用)
     * @return
     */
    public static <T> List<T>  removeRepeatData(List<T> list){
        List<T> result = new ArrayList<>();
        if(ListUtil.isNotNull(list)){
            Map map = new HashMap();
            for(T t : list){
                if((T)map.get(t) == null){      // 如果在map里面找不到，那么表示还没存在过
                    map.put(t, t);
                    result.add(t);
                }
            }
        }
        return result;
    }




}
