<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
	<style type="text/css">
	.notification{
		background-color: #4CAF50; 
		padding: 5px;
		border-radius: 5px;
		color: white;
		margin-bottom: 5px;
		font-family: Arial, sans-serif;
		font-size: 16px;
		max-width: 300px;
		box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
		z-index: 1000;"
	}
	</style>
    <jsp:include page="/WEB-INF/views/head.jsp" />
</head>

<body>
    <div class="limiter">
        <div class="container-login100">
            <div class="wrap-login100">
                <div class="login100-pic js-tilt" data-tilt>
                    <img src="${contextPath}/resources/images/fg-img.png" alt="IMG">
              </div>
                <form class="login100-form validate-form" action="<%= request.getContextPath() %>/forgot" method="post">
                    <span class="login100-form-title">
                        <b>KHÔI PHỤC MẬT KHẨU</b>
                    </span>
                    <c:if test="${message != null}">
				        <div id="notification" class="notification">
				            ${message}
				        </div>
				    </c:if>
				    <c:if test="${newpass != null}">
				        <div class="notification">
				            ${newpass}
				        </div>
				    </c:if>
                        <div class="wrap-input100 validate-input">
	                        <input class="input100" type="text" placeholder="Tên tài khoản" name="username" id="username" required>
	                        <span class="focus-input100"></span>
	                        <span class="symbol-input100">
	                            <i class='bx bx-user'></i>
	                        </span>
	                    </div>
	                    
	                    <div class="wrap-input100 validate-input">
	                        <input class="input100" type="text" placeholder="Số điện thoại" name="phone" id="phone" required>
	                        <span class="focus-input100"></span>
	                        <span class="symbol-input100">
	                            <i class='bx bx-phone'></i>
	                        </span>
	                    </div>
                        <div class="container-login100-form-btn">
                            <input type="submit" value="Lấy mật khẩu" />
                        </div>

                        <div class="text-center p-t-12">
                            <a class="txt2" href="${contextPath}/login">
                                Trở về đăng nhập
                            </a>
                        </div>
                    <div class="text-center p-t-70 txt2">
                        Phần mềm quản lý tiêm vắc-xin cho thú cưng <i class="far fa-copyright" aria-hidden="true"></i>
                        <script type="text/javascript">document.write(new Date().getFullYear());</script> <a
                            class="txt2" href="https://www.facebook.com/truongvo.vd1503/"></a>
                    </div>
                </form>
            </div>
        </div>
    </div>
   <!--===============================================================================================-->
   <script src="${contextPath}/resources//js/main.js"></script>
   <!--===============================================================================================-->
   <script src="${contextPath}/resources/vendor/jquery/jquery-3.2.1.min.js"></script>
   <!--===============================================================================================-->
   <script src="${contextPath}/resources/vendor/bootstrap/js/popper.js"></script>
   <!--===============================================================================================-->
   <script src="${contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
   <!--===============================================================================================-->
   <script src="${contextPath}/resources/vendor/select2/select2.min.js"></script>
   <!--===============================================================================================-->
   <script>
        document.addEventListener("DOMContentLoaded", function() {
            var notification = document.getElementById('notification');
            if (notification) {
                setTimeout(function() {
                    notification.style.opacity = '0';
                }, 2000);
                setTimeout(function() {
                    if (notification) {
                        notification.remove();
                    }
                }, 1000);
            }
        });
    </script>
</body>
</html>