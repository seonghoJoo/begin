package com.shj.begin.application.command;

import com.shj.begin.application.port.in.PersonInPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public abstract class PersonCommand implements PersonInPort {
}
