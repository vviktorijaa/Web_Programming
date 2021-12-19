//package mk.finki.ukim.mk.lab.web.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter
//public class SelectOptionFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//
//        String balloon = (String) req.getSession().getAttribute("color");
//
//        String path = req.getServletPath();
//
//        if (!"".equals(path) && balloon==null) {
//            resp.sendRedirect("");
//        } else {
//            filterChain.doFilter(servletRequest,servletResponse);
//        }
//    }
//}
