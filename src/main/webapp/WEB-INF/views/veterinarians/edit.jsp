<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="/WEB-INF/views/head.jsp" />
</head>
<body onload="time()" class="app sidebar-mini rtl">
    <jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
    <main class="app-content">
        <div class="app-title">
            <ul class="app-breadcrumb breadcrumb">
                <li class="breadcrumb-item"><a href="${contextPath}/veterinarians/list">Danh sách bác sĩ</a></li>
                <li class="breadcrumb-item">Chỉnh sửa thông tin bác sĩ</li>
            </ul>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="tile">
                    <h3 class="tile-title">Chỉnh sửa thông tin bác sĩ</h3>
                    <div class="tile-body">
                        <form:form action="${contextPath}/veterinarians/update" method="post" modelAttribute="veterinarian" class="row">
                        <form:hidden path="veterinarianID" />
                            <div class="form-group col-md-4">
                                <label class="control-label">Email</label>
                                <form:input path="email" class="form-control" type="email" required="true"/>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="control-label">Tên bác sĩ</label>
                                <form:input path="veterinarianName" class="form-control" type="text" required="true"/>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="control-label">Số điện thoại</label>
                                <form:input path="phoneNumber" class="form-control" type="text" required="true"/>
                            </div>
                            <div class="form-group col-md-12">
                                <button class="btn btn-save" type="submit">Lưu lại</button>
                                <button class="btn btn-cancel" type="button"
								onclick="window.location.href='${contextPath}/veterinarians/list'">Hủy
								bỏ</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </main>
</body>
</html>
