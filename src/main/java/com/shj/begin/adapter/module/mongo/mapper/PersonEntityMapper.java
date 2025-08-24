package com.shj.begin.adapter.module.mongo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public class PersonEntityMapper {

    PersonEntityMapper INSTANCE = Mappers.getMapper(PersonEntityMapper.class);
    //Person toPerson(PersonRequestDTO personRequestDTO, HeaderVO headerVO);
}
