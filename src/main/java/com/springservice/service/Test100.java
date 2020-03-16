package com.springservice.service;

public class Test100 {

    public static void main(String[] args) {

        Test100 test100 = new Test100();
        test100.testMethod();

    }

    public void testMethod(){


        Employee emp = new Employee();
        emp.setName("Amit");

        System.out.println(emp.getName() == "Amit");

        System.out.println("classname:"+emp.getClass());

    }


    class Employee{

        private String name;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }



    }
}
