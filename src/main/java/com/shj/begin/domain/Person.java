package com.shj.begin.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {
    private String name;
    private int age;
    private String phoneNumber;
    private String email;
    private Addr address;
    private float height;
    private float weight;
    private float bmi;

    private HeaderVO headerVO;

    @Getter
    @Setter
    @ToString
    public static class Addr {
        private String city;
        private String street;
        private String zipCode;
    }

    public void setBMI(){
        this.bmi = weight / (height * height);
    }
}
