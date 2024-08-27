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
        // Khởi tạo bộ lọc
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
        boolean staticResourceRequest = httpRequest.getRequestURI().matches(".*(\\.(css|js|png|jpg|jpeg|gif|woff|ttf))$");

        if (loggedIn || loginRequest || registerRequest || forgotRequest || staticResourceRequest) {
            // Người dùng đã đăng nhập hoặc đang yêu cầu trang login/register hoặc tài nguyên tĩnh, tiếp tục xử lý
            chain.doFilter(request, response);
        } else {
            // Chưa đăng nhập, chuyển hướng đến trang login
            httpResponse.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {
        // Dọn dẹp bộ lọc khi ứng dụng dừng lại
    }
}
