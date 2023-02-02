package com.example.springtest.test;

import java.util.*;

/**
 * @Classname TestHashMap
 * @Description hashmap取出任意位置元素最效率
 * @Date 2023/2/1 11:26
 * @Created by aprilz
 */
public class TestHashMap {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i <= 25; i++) {
            map.put(i, "value--" + i);
        }
        //取出keyset转数组
        Object[] keys = map.keySet().toArray();

        //取出values转数组
        Object[] values = map.values().toArray();

        //随机一个index
        int index = (int) (Math.random() * keys.length);

        System.out.println(values[25]);

        //取出随便index下标 hashmap里的值
        System.out.println(map.get(index));


        //第一种： 获取到key，二次取值
        System.out.println("通过Map.keySet遍历key和value：");
        for (Integer key : map.keySet()) {
            System.out.println("key= " + key + " and value= " + map.get(key));
        }

        //第二种 推荐，尤其是容量大时,性能最快
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第三种：普遍
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第四种 这种只取value
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }
        //第五种 lamada方式，经过测试，lamada方式虽然语法简便，但是循环内不涉及IO操作时，性能略差

        map.forEach((key, value) -> {
            System.out.println("key= " + key + " and value= " + value);
        });


        //可查出是无序的，改用LinkedHashMap或者TreeMap,则为有序的.
        HashMap<String, String> t = new HashMap<>();
        t.put("ID","1");
        t.put("Name","the name");
        t.put("Sort","the sort");
        t.put("Type","the type");


        for (String key : t.keySet()) {
            System.out.println(key +":" + t.get(key));
        }

    }
}
