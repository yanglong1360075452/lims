package com.wizinno.lims.common.util;

import org.apache.commons.collections4.CollectionUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author LiuMei
 */
public class ListUtil {

    /**
     * 数组类型转换
     * @param data
     * @return
     */
    public static List<Long> bigIntegerToLong(List<BigInteger> data){
        List<Long> result = null;
        if(CollectionUtils.isNotEmpty(data)){
            result = new ArrayList<>();
            for(BigInteger id : data){
                result.add(id.longValue());
            }
        }
        return result;
    }

    /**
     * 数组相同数字分组
     * @param data
     * @return
     */
    public static List<List<Integer>> splitSame(List<Integer> data) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer>group=null;
        for(int value:data){
            if(group==null||group.get(group.size() - 1)!=value){
                group=new ArrayList<>();
                result.add(group);
            }
            group.add(value);
        }
        return result;
    }


    /**
     * 数组连续数字分组
     * @param data
     * @return
     */
    public static List<List<Integer>> splitCon(List<Integer> data) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer>group=null;
        for(int value:data){
            if(group==null||group.get(group.size() - 1)+1!=value){
                group=new ArrayList<>();
                result.add(group);
            }
            group.add(value);
        }
        return result;
    }

    /**
     * 两个集合求差集
     * @param arr1
     * @param arr2
     * @return
     */
    public static Set<Long> minus(Set<Long> arr1, Set<Long> arr2) {
        Set<Long> list = new HashSet<>();
        Set<Long> history = new HashSet<>();
        Set<Long> longerArr = arr1;
        Set<Long> shorterArr = arr2;
        //找出较长的数组来减较短的数组
        if (arr1.size() > arr2.size()) {
            longerArr = arr2;
            shorterArr = arr1;
        }
        for (Long l : longerArr) {
            if (!list.contains(l)) {
                list.add(l);
            }
        }
        for (Long l : shorterArr) {
            if (list.contains(l)) {
                history.add(l);
                list.remove(l);
            } else {
                if (!history.contains(l)) {
                    list.add(l);
                }
            }
        }
        return list;
    }
}
