package com.nevercaution.teddy.handler;

import com.nevercaution.teddy.annotation.RequestCustomParam;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Map;

@Configuration
public class CustomResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(RequestCustomParam.class);
    }

    @Override
    public Integer resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        RequestCustomParam customParam = parameter.getParameterAnnotation(RequestCustomParam.class);
        Map<String, String[]> parameterMap = webRequest.getParameterMap();
        System.out.println("parameterMap = " + parameterMap);
        String value = webRequest.getParameter(customParam.value());

        // do something
        return Integer.valueOf(value);
    }
}
