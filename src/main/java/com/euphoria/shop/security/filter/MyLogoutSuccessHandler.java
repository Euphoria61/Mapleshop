//package com.euphoria.shop.filter;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
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
//@Component
//public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
//    @Override
//    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        response.setContentType("application/json;charset=UTF-8");
//        Map<String, Object> map = new HashMap<>();
//        map.put("status", 200);
//        map.put("msg", "登出成功");
//        PrintWriter out = response.getWriter();
//        out.write(new ObjectMapper().writeValueAsString(map));
//        out.flush();
//        out.close();
//    }
//}
