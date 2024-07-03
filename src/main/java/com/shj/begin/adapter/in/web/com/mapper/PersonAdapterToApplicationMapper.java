package com.shj.begin.adapter.in.web.com.mapper;

import com.shj.begin.adapter.in.web.com.dto.PersonRequestDTO;
import com.shj.begin.adapter.in.web.com.dto.PersonResponseDTO;
import com.shj.begin.domain.HeaderVO;
import com.shj.begin.domain.Person;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonAdapterToApplicationMapper {

    PersonAdapterToApplicationMapper INSTANCE = Mappers.getMapper(PersonAdapterToApplicationMapper.class);

    Person toPerson(PersonRequestDTO personRequestDTO, HeaderVO headerVO);

    @AfterMapping
    default void setHeader(@MappingTarget Person person, HeaderVO headerVO) {
        person.setHeaderVO(headerVO);
    }


    PersonResponseDTO toPersonResponseDTO(Person person);
}
