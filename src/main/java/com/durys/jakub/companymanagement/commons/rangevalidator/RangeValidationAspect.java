package com.durys.jakub.companymanagement.commons.rangevalidator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Aspect
@Component
public class RangeValidationAspect {

    @PostConstruct
    public void h() {
        System.out.println("init");
    }

    @Before("@annotation(RangeValidation)")
    public void test() {
        System.out.println("elo");
    }

}
