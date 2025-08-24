package com.shj.begin.adapter.module.mongo;

import com.shj.begin.adapter.module.mongo.entity.PersonEntity;
import com.shj.begin.domain.Person;
import org.springframework.stereotype.Repository;

// mongodb extends를 해야함. 하지만 생략
@Repository
public class PersonMongoRepository {
    public PersonEntity savePerson(Person person) {
        return null;
    }
}
