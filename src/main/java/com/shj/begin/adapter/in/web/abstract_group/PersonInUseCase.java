package com.shj.begin.adapter.in.web.abstract_group;

import com.shj.begin.adapter.in.web.com.dto.PersonRequestDTO;
import com.shj.begin.adapter.in.web.com.dto.PersonResponseDTO;
import com.shj.begin.adapter.in.web.com.mapper.PersonAdapterToApplicationMapper;
import com.shj.begin.application.port.in.PersonInPort;
import com.shj.begin.domain.HeaderVO;
import com.shj.begin.domain.Person;
import com.shj.begin.infrastructure.common.ApiResponse;
import com.shj.begin.infrastructure.common.Const;
import com.shj.begin.infrastructure.util.CommonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

// adapter.in.web.com.ComPersonInUseCase,
// adapter.in.web.kr.KRPersonInUseCase
// 이 국가에 따라 빈등록이 되도록 하였다.
// 따라서 PersonInUseCase는 abstract class로 선언하고 빈으로 등록되지 않도록 한다.
@Slf4j
@RequiredArgsConstructor
// <T extends PersonRequestDTO> 인 이유. 각 국가마다 다른 RequestDTO가 들어올 수 있다.
// 따라서 제네릭으로 대응하기 위함이다.
public abstract class PersonInUseCase<T extends PersonRequestDTO> {

    protected final PersonInPort personInPort;

    @PostMapping("/v1/person")
    public ResponseEntity<ApiResponse<PersonResponseDTO>> savePerson(
            @RequestHeader final Map<String, String> header,
            @RequestBody final T body) {

        HeaderVO headerVO = CommonUtil.extractHeader(header);
        // MapStruct를 이용해 Domain으로 변환을 해야한다.
        Person person = PersonAdapterToApplicationMapper.INSTANCE.toPerson(body, headerVO);

        return ResponseEntity.ok(ApiResponse.<PersonResponseDTO>builder()
                .data(PersonAdapterToApplicationMapper.INSTANCE.toPersonResponseDTO(personInPort.savePerson(person)))
                .statusCode(Const.STATUS_200)
                .msg(Const.STATUS_200_MESSAGE)
                .build());
    }
}
