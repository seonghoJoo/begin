package com.shj.begin.adapter.in.web.kr.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

@Getter
@Setter
public class KRPersonRequestDTO {
    private String name;
    private int age;
    private String phoneNumber;
    private String email;
    private Addr address;

    // 대한민국만 특이한 케이스로 주민번호가 필요함.
    private String juminNo;

    @Getter
    @Setter
    public static class Addr {
        private String city;
        private String street;
        private String zipCode;
    }

    public boolean checkValidIsOkay() {
        Assert.hasText(name, "name is empty");
        Assert.isTrue(age > 0, "age is less than 0");
        Assert.hasText(email, "email is empty");
        if(address != null){
            Assert.notNull(address, "address is null");
            Assert.hasText(address.getCity(), "city is empty");
            Assert.hasText(address.getStreet(), "street is empty");
        }
        return true;
    }
}
