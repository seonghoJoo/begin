package com.shj.begin.adapter.in.web;

import com.shj.begin.adapter.in.web.com.dto.PersonRequestDTO;
import com.shj.begin.adapter.in.web.com.dto.ResponseDTO;
import com.shj.begin.adapter.in.web.com.mapper.PersonAdapterToApplicationMapper;
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

import java.time.LocalDateTime;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public abstract class PersonInUseCase<T extends PersonRequestDTO> {

    @PostMapping("/v1/person")
    public ResponseEntity<ApiResponse<ResponseDTO>> savePerson(
            @RequestHeader Map<String, String> header,
            @RequestBody T body) {
        log.info("PersonInUseCase example header: {}", header);

        HeaderVO headerVO = CommonUtil.extractHeader(header);

        Person person = PersonAdapterToApplicationMapper.INSTANCE.map(body, headerVO);

        log.info("PersonInUseCase example person: {}", person);

        return ResponseEntity.ok(ApiResponse.<ResponseDTO>builder()
                .data(ResponseDTO.builder()
                        .id("1")
                        .lastUpdate(LocalDateTime.now())
                        .build())
                .statusCode(200)
                .msg("success")
                .build());
    }
}
