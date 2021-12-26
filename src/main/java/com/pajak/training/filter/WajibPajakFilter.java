package com.pajak.training.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class WajibPajakFilter implements Filter {
    Logger log = LoggerFactory.getLogger(WajibPajakFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("Logging Request  Thread Name {}, {} : {}", Thread.currentThread().getName(), req.getMethod(), req.getRequestURI());
        log.info("Logging Response :{}", res.getContentType());
    }

    @Bean
    public FilterRegistrationBean<WajibPajakFilter> loggingFilter() {
        FilterRegistrationBean<WajibPajakFilter> registrationBean
                = new FilterRegistrationBean<>();
        registrationBean.setFilter(new WajibPajakFilter());
        registrationBean.addUrlPatterns("/wp/*");
        registrationBean.addUrlPatterns("/wp-reactive/*");
        return registrationBean;
    }
}
