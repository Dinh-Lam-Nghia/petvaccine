<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="vi">

<head>
    <jsp:include page="/WEB-INF/views/head.jsp" />
</head>

<body>
    <div class="limiter">
        <div class="container-login100">
            <div class="wrap-login100">
                <div class="login100-pic js-tilt" data-tilt>
                    <img src="${contextPath}/resources/images/team.jpg" alt="IMG">
                </div>
                <!--=====TIÊU ĐỀ======-->
                <form class="login100-form validate-form" action="<%= request.getContextPath() %>/login" method="post">
                    <span class="login100-form-title">
                        <b>ĐĂNG NHẬP HỆ THỐNG POS</b>
                    </span>
                    <!--=====FORM INPUT TÀI KHOẢN VÀ PASSWORD======-->
                    <div class="wrap-input100 validate-input">
                        <input class="input100" type="text" placeholder="Tên tài khoản" name="username" id="username" required>
                        <span class="focus-input100"></span>
                        <span class="symbol-input100">
                            <i class='bx bx-user'></i>
                        </span>
                    </div>
                    <div class="wrap-input100 validate-input">
                        <input autocomplete="off" class="input100" type="password" placeholder="Mật khẩu" name="password" id="password-field" required>
                        <span toggle="#password-field" class="bx fa-fw bx-hide field-icon click-eye"></span>
                        <span class="focus-input100"></span>
                        <span class="symbol-input100">
                            <i class='bx bx-key'></i>
                        </span>
                    </div>

                    <!--=====ĐĂNG NHẬP======-->
                    <div class="container-login100-form-btn">
                        <input type="submit" value="Đăng nhập" id="submit" />
                    </div>
                    <!--=====LINK TÌM MẬT KHẨU======-->
                    <div class="text-right p-t-12">
                        <a class="txt2" href="${contextPath}/forgot">
                            Bạn quên mật khẩu?
                        </a>
                        <a class="txt2" href="${contextPath}/register">
                            Đăng ký
                        </a>
                    </div>
                    <!--=====FOOTER======-->
                    <div class="text-center p-t-70 txt2">
                        Phần mềm quản lý tiêm vắc-xin cho thú cưng <i class="far fa-copyright" aria-hidden="true"></i>
                        <script type="text/javascript">document.write(new Date().getFullYear());</script>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!--Javascript-->
    <script src="${contextPath}/js/main.js"></script>
    <script src="https://unpkg.com/boxicons@latest/dist/boxicons.js"></script>
    <script src="${contextPath}/vendor/jquery/jquery-3.2.1.min.js"></script>
    <script src="${contextPath}/vendor/bootstrap/js/popper.js"></script>
    <script src="$contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="${contextPath}/vendor/select2/select2.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        //show - hide mật khẩu
        $(document).ready(function() {
	        $(".click-eye").click(function () {
	            // Lấy selector từ thuộc tính toggle
	            var inputSelector = $(this).attr("toggle");
	            var input = $(inputSelector);
	
	            // Thay đổi kiểu của ô nhập liệu và lớp của biểu tượng mắt
	            if (input.attr("type") === "password") {
	                input.attr("type", "text");
	                $(this).removeClass("bx-hide").addClass("bx-show");
	            } else {
	                input.attr("type", "password");
	                $(this).removeClass("bx-show").addClass("bx-hide");
	            }
	        });
    	});
    </script>
</body>

</html>
