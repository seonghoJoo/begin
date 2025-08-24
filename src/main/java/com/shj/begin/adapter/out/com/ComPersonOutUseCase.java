package com.shj.begin.adapter.out.com;

import com.shj.begin.adapter.module.http.OgwFeignClient;
import com.shj.begin.adapter.module.mongo.PersonMongoRepository;
import com.shj.begin.adapter.out.abstract_group.PersonOutUseCase;

public class ComPersonOutUseCase extends PersonOutUseCase {
    public ComPersonOutUseCase(PersonMongoRepository personMongoRepository, OgwFeignClient ogwFeignClient) {
        super(personMongoRepository, ogwFeignClient);
    }
}
