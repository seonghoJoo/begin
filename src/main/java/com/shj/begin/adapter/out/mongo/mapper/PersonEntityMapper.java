package com.shj.begin.adapter.out.mongo.mapper;

import com.shj.begin.adapter.in.web.com.dto.PersonRequestDTO;
import com.shj.begin.domain.HeaderVO;
import com.shj.begin.domain.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public class PersonEntityMapper {

    PersonEntityMapper INSTANCE = Mappers.getMapper(PersonEntityMapper.class);
    //Person toPerson(PersonRequestDTO personRequestDTO, HeaderVO headerVO);
}
