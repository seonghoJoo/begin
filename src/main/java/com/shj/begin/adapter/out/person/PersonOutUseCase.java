package com.shj.begin.adapter.out.person;

import com.shj.begin.adapter.out.mongo.PersonMongoRepository;
import com.shj.begin.adapter.out.mongo.entity.PersonEntity;
import com.shj.begin.application.port.out.PersonOutPort;
import com.shj.begin.domain.Person;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PersonOutUseCase implements PersonOutPort {

    private final PersonMongoRepository personMongoRepository;

    @Override
    public Person savePerson(Person person){
        PersonEntity personEntity =
        personMongoRepository.savePerson(person);
        return null;
    }
}
