//package com.euphoria.shop.filter;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @package: com.euphoria.shop.filter
// * @className: MyAuthenticationEntryPointHandler
// * @author: Euphoria
// * @description: TODO
// * @date: 2022/8/6 9:53
// */
//@Component
//public class MyAuthenticationEntryPointHandler implements AuthenticationEntryPoint {
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
//        response.setContentType("application/json;charset=UTF-8");
//        Map<String, Object> map = new HashMap<>();
//        map.put("status", 402);
//        map.put("msg", e.getMessage());
//        PrintWriter out = response.getWriter();
//        out.write(new ObjectMapper().writeValueAsString(map));
//        out.flush();
//        out.close();
//    }
//}
