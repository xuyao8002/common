package com.xuyao.utils;

import com.cookingfox.guava_preconditions.Preconditions;
public class PreconditionsUtils {


    public static void main(String[] args) {
        Person person = new Person();
        String name = Preconditions.checkNotNull(person.getName(), "name不能是null");
        Preconditions.checkState(person.getName() != null, "name 不能为null");
        try{
            Preconditions.checkArgument(person.getName() != null, "name 不能为null");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(name);
    }


    static class Person {

        private String name;

        private Integer age;

        private String hobby;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getHobby() {
            return hobby;
        }

        public void setHobby(String hobby) {
            this.hobby = hobby;
        }
    }
}
