package com.shj.begin.adapter.in.web.com;

import com.shj.begin.adapter.in.web.abstract_group.PersonInUseCase;
import com.shj.begin.adapter.in.web.com.dto.PersonRequestDTO;
import com.shj.begin.application.port.in.PersonInPort;
import com.shj.begin.infrastructure.common.COMBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@COMBean({"US", "CA"})
public class ComPersonInUseCase extends PersonInUseCase<PersonRequestDTO> {
    public ComPersonInUseCase(PersonInPort personInPort) {
        super(personInPort);
    }
}
