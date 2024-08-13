<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="/WEB-INF/views/head.jsp" />
</head>

<body>
    <div class="limiter">
        <div class="container-login100">
            <div class="wrap-login100">
                <div class="login100-pic js-tilt" data-tilt>
                    <img src="${contextPath}/resources/images/fg-img.png" alt="IMG">
              </div>
                <form class="login100-form validate-form">
                    <span class="login100-form-title">
                        <b>KHÔI PHỤC MẬT KHẨU</b>
                    </span>
                    <form action="custommer.html">
                        <div class="wrap-input100 validate-input"
                            data-validate="Bạn cần nhập đúng thông tin như: ex@abc.xyz">
                            <input class="input100" type="text" placeholder="Nhập email" name="emailInput"
                                id="emailInput" value="" />
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class='bx bx-mail-send' ></i>
                            </span>
                        </div>
                        <div class="container-login100-form-btn">
                            <input type="button" onclick="return RegexEmail('emailInput')" value="Lấy mật khẩu" />
                        </div>

                        <div class="text-center p-t-12">
                            <a class="txt2" href="${contextPath}/login">
                                Trở về đăng nhập
                            </a>
                        </div>
                    </form>
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
   
</body>
</html>