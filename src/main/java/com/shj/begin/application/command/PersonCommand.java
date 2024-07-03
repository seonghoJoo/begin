package com.shj.begin.application.command;

import com.shj.begin.application.port.in.PersonInPort;
import com.shj.begin.application.port.out.PersonOutPort;
import com.shj.begin.domain.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@RequiredArgsConstructor
@Service
public class PersonCommand implements PersonInPort {

    protected PersonOutPort personOutPort;
    Map<String, String> instance = new ConcurrentHashMap<>();

    @Override
    public Person savePerson(Person person) {

        Map<String, String> local = new HashMap<>(); // 로컬 변수는 동시성 이슈 발생 불가능 => HashMap 사용
        personOutPort.savePerson(person);
        return null;
    }
}
