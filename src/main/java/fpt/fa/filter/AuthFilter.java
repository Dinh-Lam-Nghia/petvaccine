package fpt.fa.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        String loginURI = httpRequest.getContextPath() + "/login";
        String registerURI = httpRequest.getContextPath() + "/register";
        String forgotURI = httpRequest.getContextPath() + "/forgot";

        boolean loggedIn = session != null && session.getAttribute("username") != null;
        boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean registerRequest = httpRequest.getRequestURI().equals(registerURI);
        boolean forgotRequest = httpRequest.getRequestURI().equals(forgotURI);

        if (loggedIn || loginRequest || registerRequest || forgotRequest) {
            chain.doFilter(request, response); // Người dùng đã đăng nhập hoặc đang yêu cầu trang login/register, tiếp tục xử lý
        } else {
            httpResponse.sendRedirect(loginURI); // Chưa đăng nhập, chuyển hướng đến trang login
        }
    }

    @Override
    public void destroy() {
        
    }
}
