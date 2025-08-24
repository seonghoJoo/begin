package com.shj.begin.adapter.out.abstract_group;

import com.shj.begin.adapter.module.http.OgwFeignClient;
import com.shj.begin.adapter.module.mongo.PersonMongoRepository;
import com.shj.begin.adapter.module.mongo.entity.PersonEntity;
import com.shj.begin.application.port.out.PersonOutPort;
import com.shj.begin.domain.Person;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class PersonOutUseCase implements PersonOutPort {

    private final PersonMongoRepository personMongoRepository;
    private final OgwFeignClient ogwFeignClient;

    @Override
    public Person savePerson(Person person){
        PersonEntity personEntity = personMongoRepository.savePerson(person);

        return null;
    }

    public void sendPersonToOut(Person person) throws Exception {
        try{
            log.debug("========== Send Before ==========");
            ogwFeignClient.send(person);
        }catch (FeignException e){
            log.error("Feign Exception status : {}, message : {}", e.status(), e.getMessage());
            throw new Exception("Error occurred while sending person to external system", e);
        }catch (Exception e){
            log.error("Error occurred while sending person to external system", e);
            throw new Exception("Error occurred while sending person to external system", e);
        }
    }
    // 예시를 위한 함수
    @Override
    public Person setPersonBMI(Person person) {
        person.setBMI();
        return person;
    }
}
