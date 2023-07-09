package com.auth.sunia.star247.logs.aspect;

import cn.hutool.json.JSONUtil;
import com.auth.sunia.star247.logs.annotation.LogCat;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.annotation.Order;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author star362
 * @Date 2023/7/7 17:19
 * @Description: TODO
 */
@Order(-100)
@Aspect
@Component
@Slf4j
public class LogCatAspect {

    public LogCatAspect() {
    }

    @Pointcut("@annotation(logCat)")
    public void pointCut(LogCat logCat) {
    }

    @Around("pointCut(logCat)")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint, LogCat logCat) throws Throwable {
        log.info("-> LogCatAspect");
        LocalDateTime startTime = LocalDateTime.now();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Object proceed = proceedingJoinPoint.proceed();
        MethodSignature methodSignature = (MethodSignature)proceedingJoinPoint.getSignature();
        RequestInfo requestInfo = new RequestInfo();
        if (StringUtils.hasText(logCat.bid())) {
            requestInfo.setBid(this.getKey(proceedingJoinPoint, logCat.bid()));
        }

        requestInfo.setStartTime(startTime);
//        requestInfo.setActionGroup(logCat.actionGroup());
//        requestInfo.setAction(logCat.action());
        requestInfo.setIp(request.getRemoteAddr());
        requestInfo.setUrl(request.getRequestURL().toString());
        requestInfo.setHttpMethod(request.getMethod());
        requestInfo.setRequestHeaders(this.getRequestHeaders(request));
        requestInfo.setClassMethod(String.format("%s.%s", methodSignature.getDeclaringTypeName(), methodSignature.getName()));
        requestInfo.setRequestParams(this.getRequestParamsByProceedingJoinPoint(proceedingJoinPoint));
        requestInfo.setResult(proceed);
        requestInfo.setEndTime(LocalDateTime.now());
        requestInfo.setTimeCost(Duration.between(startTime, requestInfo.getEndTime()).toMillis());
        if (logCat.print()) {
            String reqMsg = "\r\n-----------------------\r\n【Request URI    】:" + requestInfo.getIp() + " > " + requestInfo.getHttpMethod() + " " + requestInfo.getUrl() + "\r\n【Request Headers】:" + requestInfo.getRequestHeaders() + "\r\n【Request body   】:" + requestInfo.getRequestParams() + "\r\n【Result         】:" + JSONUtil.toJsonStr(requestInfo.getResult()) + "\r\n【Time Cost      】:" + requestInfo.getTimeCost() + "ms\r\n-----------------------";
            log.info(reqMsg);
        }



        log.info("LogCatAspect ->");
        return proceed;
    }

    @AfterThrowing(
            pointcut = "pointCut(logCat)",
            throwing = "e"
    )
    public void doAfterThrow(JoinPoint joinPoint, RuntimeException e, LogCat logCat) {
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        RequestInfo requestInfo = new RequestInfo();
        if (StringUtils.hasText(logCat.bid())) {
            requestInfo.setBid(this.getKey(joinPoint, logCat.bid()));
        }

        requestInfo.setStartTime(LocalDateTime.now());
//        requestInfo.setActionGroup(logCat.actionGroup());
//        requestInfo.setAction(logCat.action());
        requestInfo.setIp(request.getRemoteAddr());
        requestInfo.setUrl(request.getRequestURL().toString());
        requestInfo.setHttpMethod(request.getMethod());
        requestInfo.setRequestHeaders(this.getRequestHeaders(request));
        requestInfo.setClassMethod(String.format("%s.%s", methodSignature.getDeclaringTypeName(), methodSignature.getName()));
        requestInfo.setRequestParams(this.getRequestParamsByJoinPoint(joinPoint));
        requestInfo.setException(e.getMessage());
        requestInfo.setEndTime(LocalDateTime.now());
        requestInfo.setTimeCost(Duration.between(requestInfo.getStartTime(), requestInfo.getEndTime()).toMillis());
        if (logCat.print()) {
            String reqMsg = "\r\n-----------------------\r\n【Request URI    】:" + requestInfo.getIp() + " > " + requestInfo.getHttpMethod() + " " + requestInfo.getUrl() + "\r\n【Request Headers】:" + requestInfo.getRequestHeaders() + "\r\n【Request body   】:" + requestInfo.getRequestParams() + "\r\n【Exception      】:" + requestInfo.getException() + "\r\n【Time Cost      】:" + requestInfo.getTimeCost() + "ms\r\n-----------------------";
            log.info(reqMsg);
        }


    }

    private Map<String, Object> getRequestParamsByProceedingJoinPoint(ProceedingJoinPoint proceedingJoinPoint) {
        String[] paramNames = ((MethodSignature)proceedingJoinPoint.getSignature()).getParameterNames();
        Object[] paramValues = proceedingJoinPoint.getArgs();
        return this.buildRequestParam(paramNames, paramValues);
    }

    private Map<String, Object> getRequestParamsByJoinPoint(JoinPoint joinPoint) {
        String[] paramNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames();
        Object[] paramValues = joinPoint.getArgs();
        return this.buildRequestParam(paramNames, paramValues);
    }

    private Map<String, Object> getRequestHeaders(HttpServletRequest request) {
        Map<String, Object> requestHeadersParams = new HashMap();
        Enumeration headerNames = request.getHeaderNames();

        while(headerNames.hasMoreElements()) {
            String name = (String)headerNames.nextElement();
            Enumeration<String> headerValues = request.getHeaders(name);
            StringBuilder sb = new StringBuilder();

            while(headerValues.hasMoreElements()) {
                sb.append((String)headerValues.nextElement());
            }

            requestHeadersParams.put(name, sb.toString());
        }

        return requestHeadersParams;
    }

    private Map<String, Object> buildRequestParam(String[] paramNames, Object[] paramValues) {
        Map<String, Object> requestParams = new HashMap();

        for(int i = 0; i < paramNames.length; ++i) {
            Object value = paramValues[i];
            if (value instanceof MultipartFile) {
                MultipartFile file = (MultipartFile)value;
                value = file.getOriginalFilename();
            }

            requestParams.put(paramNames[i], value);
        }

        return requestParams;
    }

    private String getKey(JoinPoint joinPoint, String key) {
        MethodSignature ms = (MethodSignature)joinPoint.getSignature();
        Method method = ms.getMethod();
        Object[] args = joinPoint.getArgs();
        LocalVariableTableParameterNameDiscoverer localVariableTable = new LocalVariableTableParameterNameDiscoverer();
        String[] paraNameArr = localVariableTable.getParameterNames(method);
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        for(int i = 0; i < paraNameArr.length; ++i) {
            context.setVariable(paraNameArr[i], args[i]);
        }

        String fullKey = (String)parser.parseExpression(key).getValue(context, String.class);
        return !StringUtils.hasText(fullKey) ? null : (String)parser.parseExpression(key).getValue(context, String.class);
    }
}
