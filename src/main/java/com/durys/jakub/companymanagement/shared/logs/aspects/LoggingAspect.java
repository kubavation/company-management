package com.durys.jakub.companymanagement.shared.logs.aspects;

import com.durys.jakub.companymanagement.shared.interfaces.CmEntity;
import com.durys.jakub.companymanagement.shared.logs.service.CmLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.persistence.Table;

@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
public class LoggingAspect {

    private final CmLogService logService;

    @AfterReturning(
            value = "execution(* org.springframework.data.jpa.repository.JpaRepository+.save(..))))",
            returning = "result")
    public <T extends CmEntity<? extends Long>> void log(Object result) {
        logService.log((T) result);
    }

}
