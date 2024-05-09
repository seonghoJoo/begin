package com.shj.begin.application.port.out;

import com.shj.begin.domain.Person;

public interface PersonOutPort {
    Person savePerson(Person person);
}
