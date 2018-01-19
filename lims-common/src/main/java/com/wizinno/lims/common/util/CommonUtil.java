package com.wizinno.lims.common.util;

import org.apache.commons.collections4.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

/**
 *@author LiuMei
 */
public class CommonUtil {

    /**
     * 获取请求客户端IP地址
     *
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String unknown = "unknown";
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 更新数据时新旧数据对比,可以更改的属性有变化重新赋值
     *
     * @param newData         新数据
     * @param oldData         数据库查询数据
     * @param exclusiveFields 不能更新的字段
     * @return
     */
    public static Object updateTrans(Object newData, Object oldData, Set<String> exclusiveFields) {
        if (newData != null && oldData != null) {
            Class clazz1 = newData.getClass();
            Class clazz2 = oldData.getClass();
            Field[] fields = oldData.getClass().getDeclaredFields();
            for (Field field : fields) {
                String name = field.getName();
                Boolean compare = true;
                if (CollectionUtils.isNotEmpty(exclusiveFields)) {
                    for (String exclusiveField : exclusiveFields) {
                        if (name.equals(exclusiveField)) {
                            compare = false;
                            break;
                        } else {
                            compare = true;
                        }
                    }
                }
                if (compare) {
                    PropertyDescriptor pd1;
                    try {
                        pd1 = new PropertyDescriptor(name, clazz1);
                    } catch (IntrospectionException e) {
                        continue;
                    }
                    Method getMethod1 = pd1.getReadMethod();
                    Object o1 = null;
                    try {
                        o1 = getMethod1.invoke(newData);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    PropertyDescriptor pd2;
                    try {
                        pd2 = new PropertyDescriptor(name, clazz2);
                    } catch (IntrospectionException e) {
                        continue;
                    }
                    Method getMethod2 = pd2.getReadMethod();
                    Object o2 = null;
                    try {
                        o2 = getMethod2.invoke(oldData);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    //避免空指针异常
                    String s1 = o1 == null ? "" : o1.toString();
                    String s2 = o2 == null ? "" : o2.toString();
                    if (!s1.equals(s2.toString())) {
                        field.setAccessible(true);
                        try {
                            field.set(oldData, o1);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return oldData;
        } else {
            return null;
        }
    }

    public static Long getTotalPage(long totalCount, int pageSize) {
        if (pageSize > 0) {
            return (totalCount + pageSize - 1) / pageSize;
        }else {
            return null;
        }
    }

    public static Boolean ajaxRequest(HttpServletRequest request){
        return request.getHeader("accept") != null && request.getHeader("accept").contains("application/json") || (request
                .getHeader("X-Requested-With") != null && request
                .getHeader("X-Requested-With").contains("XMLHttpRequest"));
    }
}
