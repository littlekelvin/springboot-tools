package com.kelvin.springboot.filter;

import com.kelvin.springboot.common.UserContextHolder;
import com.kelvin.springboot.vo.UserInfo;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Kelvin Mai
 * @date 4/16/2019
 */
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("authentication filter");
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("Kelvin" + (int)(Math.random() * 100));
        UserContextHolder.setUserContext(userInfo);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
