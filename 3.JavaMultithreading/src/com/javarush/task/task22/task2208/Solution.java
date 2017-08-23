package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("city","Kiev");
        map.put("country","Ukraine");

        map.put("age",null);
        System.out.println(getQuery(map));


    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder query = new StringBuilder();
        for(Map.Entry<String,String> pair : params.entrySet()){
            if(pair.getValue() != null){
                query.append(pair.getKey()).append(" = \'").append(pair.getValue()).append("\'");
            }

        }
        //String temp = query.toString();
        //System.out.println(temp.lastIndexOf(" a"));
        //query.delete(temp.lastIndexOf(" a"),query.length());
        return query.toString();
    }

}
