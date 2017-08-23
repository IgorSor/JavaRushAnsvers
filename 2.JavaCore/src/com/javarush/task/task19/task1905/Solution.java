package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }
    public static void main(String[] args) {
   /*     DataAdapter data = new DataAdapter(new Customer() {
            @Override
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName() {
                return "Ukraine";
            }
        }, new Contact() {
            @Override
            public String getName() {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        });
        System.out.println(data.getCompany());
        System.out.println(data.getCountryCode());
        System.out.println(data.getContactFirstName());
        System.out.println(data.getContactLastName());
        System.out.println(data.getDialString());
*/
    }

    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.contact = contact;
            this.customer = customer;
        }

        @Override
        public String getCountryCode() {
            String code  = "";
            for (Map.Entry<String,String> pair : countries.entrySet()){

            String value = pair.getValue();
            if (customer.getCountryName().equals(value))
                code = pair.getKey();
            }
            return code;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] name = contact.getName().split(", ");

            return name[1];
        }

        @Override
        public String getContactLastName() {
            String[] name = contact.getName().split(", ");

            return name[0];
        }

        @Override
        public String getDialString() {
            char[] number = contact.getPhoneNumber().toCharArray();
            String line = "";
            for (int i = 0;i<number.length;i++){
                if (number[i] != '(' && number[i] !='-' && number[i] != ')')
                    line+=number[i];

            }
            return "callto://"+line;
        }

    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}