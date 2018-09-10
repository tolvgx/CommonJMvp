package com.tolvgx.base.utils;

import com.google.gson.Gson;
import java.lang.reflect.Type;

public final class JsonUtils {
	
	private JsonUtils(){}
	
    /**
     * 对象转换成json字符串
     * @param obj Object
     * @return String
     */
    public static String toJson(Object obj) {

        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    /**
     * json字符串转成对象
     * @param str String
     * @param type Type
     * @return T
     */
    public static <T> T fromJson(String str, Type type) {
        Gson gson = new Gson();
        return gson.fromJson(str, type);
    }

    /**
     * json字符串转成对象
     * @param str String
     * @param type Class<T>
     * @return T
     */
    public static <T> T fromJson(String str, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(str, type);
    }

}
