package com.shj.begin.infrastructure.util;

import com.shj.begin.domain.HeaderVO;

import java.util.Map;

public class CommonUtil {

    public static HeaderVO extractHeader(Map<String, String> header){
        HeaderVO headerVO = new HeaderVO();
        headerVO.setTid(header.get("tid"));
        headerVO.setClientId(header.get("clientId"));
        return headerVO;
    }
}
