package com.shj.begin.adapter.in.web.kr;

import com.shj.begin.adapter.in.web.abstract_group.PersonInUseCase;
import com.shj.begin.adapter.in.web.com.dto.PersonRequestDTO;
import com.shj.begin.adapter.in.web.com.dto.PersonResponseDTO;
import com.shj.begin.adapter.in.web.kr.dto.KRPersonRequestDTO;
import com.shj.begin.application.port.in.PersonInPort;
import com.shj.begin.domain.HeaderVO;
import com.shj.begin.infrastructure.common.ApiResponse;
import com.shj.begin.infrastructure.common.KRBean;
import com.shj.begin.infrastructure.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.time.LocalDateTime;
import java.util.Map;


@Slf4j
@KRBean
@Controller
public class KRPersonInUseCase<K extends KRPersonRequestDTO> extends PersonInUseCase<PersonRequestDTO> {

    public KRPersonInUseCase(PersonInPort personInPort) {
        super(personInPort);
    }

    @PostMapping("/v2/person/secret")
    public ResponseEntity<ApiResponse<PersonResponseDTO>> secret(
            @RequestHeader Map<String, String> header,
            @RequestBody K body) {

        HeaderVO headerVO = CommonUtil.extractHeader(header);
        log.info("KRPersonInUseCase secret header: {}", headerVO);
        //Person person = PersonAdapterToApplicationMapper.INSTANCE.map(body, headerVO);

        return ResponseEntity.ok(ApiResponse.<PersonResponseDTO>builder()
                .data(PersonResponseDTO.builder()
                        .id("1")
                        .lastUpdate(LocalDateTime.now())
                        .build())
                .statusCode(200)
                .msg("success")
                .build());
    }

}
