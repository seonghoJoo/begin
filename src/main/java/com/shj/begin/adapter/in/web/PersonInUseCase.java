package com.shj.begin.adapter.in.web;

import com.shj.begin.adapter.in.web.com.dto.PersonRequestDTO;
import com.shj.begin.adapter.in.web.com.dto.PersonResponseDTO;
import com.shj.begin.adapter.in.web.com.mapper.PersonAdapterToApplicationMapper;
import com.shj.begin.application.port.in.PersonInPort;
import com.shj.begin.domain.HeaderVO;
import com.shj.begin.domain.Person;
import com.shj.begin.infrastructure.common.ApiResponse;
import com.shj.begin.infrastructure.util.CommonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public abstract class PersonInUseCase<T extends PersonRequestDTO> {

    protected final PersonInPort personInPort;

    @PostMapping("/v1/person")
    public ResponseEntity<ApiResponse<PersonResponseDTO>> savePerson(
            @RequestHeader final Map<String, String> header,
            @RequestBody final T body) {

        HeaderVO headerVO = CommonUtil.extractHeader(header);

        Person person = PersonAdapterToApplicationMapper.INSTANCE.toPerson(body, headerVO);

        return ResponseEntity.ok(ApiResponse.<PersonResponseDTO>builder()
                .data(PersonAdapterToApplicationMapper.INSTANCE.toPersonResponseDTO(personInPort.savePerson(person)))
                .statusCode(200)
                .msg("success")
                .build());
    }
}
