package com.example.demo.aop;

import com.example.demo.controller.Result;
import com.example.demo.ex.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


/**
 * Aspect for exception throwing from controller method.
 *
 * @author Jarvis Song
 */
@Slf4j
@Aspect
public class ResultExceptionAspect {

    @Around("@annotation(com.example.demo.aop.ResultExceptionHandler)")
    public Object handleResultException(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (BusinessException ex) {
            return Result.fail(ex.getCode(), null != ex.getMessage() ? ex.getMessage() : ex.getDefaultMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return Result.fail(500, ex.getMessage());
        }
    }

}
