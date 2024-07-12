package com.shj.begin.application.port.out;

import com.shj.begin.domain.Person;

public interface PersonOutPort {
    Person savePerson(Person person);
    void sendPersonToOut(Person person) throws Exception;
    Person setPersonBMI(Person person);
}
