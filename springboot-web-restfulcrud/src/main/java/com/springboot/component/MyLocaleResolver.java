package com.springboot.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author swy
 * @description: 自定义国际化组件
 * @date 2020/10/12 16:21
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        // 参数中获取语言
        String language = httpServletRequest.getParameter("language");
        // 默认为当前操作系统语言
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(language)){
            String[] arr = language.split("_");
            // 使用语言加地区构造函数创建
            locale = new Locale(arr[0],arr[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
