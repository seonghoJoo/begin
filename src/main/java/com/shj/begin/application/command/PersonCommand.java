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

    @Override
    public Person savePerson(Person person) {
        // 비즈니스 로직을 수행하지만 일종의 행동 명세서로 나타낸다.
        // 다른 개발팀으로부터 command까지 국가별로 나누면 복잡하다는 피드백이 있어서,
        // Command 부분은 빈등록이 되고 국가별로 나누지 않고, 일종의 행동 기반의 코드만 작성되도록 함.
        // setValue(), process() 등등의 선언만 하고 OutUseCase에선 행동 명세서를 구체화 한다.
        personOutPort.setPersonBMI(person);

        return personOutPort.savePerson(person);
    }
}
