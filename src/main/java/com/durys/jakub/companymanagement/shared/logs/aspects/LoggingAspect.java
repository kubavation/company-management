package com.durys.jakub.companymanagement.shared.logs.aspects;

import com.durys.jakub.companymanagement.shared.logs.service.CmLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
public class LoggingAspect {

    private final CmLogService logService;

    
}
