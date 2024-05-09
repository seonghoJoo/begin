package com.shj.begin.application.port.in;

import com.shj.begin.domain.Person;

public interface PersonInPort {
    Person savePerson(Person person);
}
