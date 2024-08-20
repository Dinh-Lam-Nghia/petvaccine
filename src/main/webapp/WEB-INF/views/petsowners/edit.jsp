<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!--  -->
<jsp:include page="/WEB-INF/views/head.jsp" />
<!--  -->

</head>
<body onload="time()" class="app sidebar-mini rtl">
	<!--  -->
	<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
	<!--  -->

	<main class="app-content">
		<div class="app-title">
			<ul class="app-breadcrumb breadcrumb">
				<li class="breadcrumb-item"><a
					href="${contextPath }/petsowners/list">Danh sách khách hàng</a></li>
				<li class="breadcrumb-item">Sửa thông tin khách hàng</li>
			</ul>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="tile">
				<form:form action="${contextPath}/petsowners/edit" method="POST"
						modelAttribute="petOwners">
					<h3 class="tile-title">Sửa thông tin khách hàng</h3>
					<div class="tile-body">
							<div class="row">
								<form:input class="form-control" type="hidden" path="ownerID" />
								<form:input class="form-control" type="hidden" path="delete" />
								<div class="form-group col-md-3">
									<label class="control-label">Họ và tên </label>
									<form:input class="form-control" type="text" path="ownerName" />
								</div>
								<div class="form-group col-md-3">
									<label class="control-label">Số diện thoại</label>
									<form:input class="form-control" type="number"
										path="phoneNumber" />
								</div>
								<div class="form-group  col-md-3">
									<label class="control-label">Email</label>
									<form:input class="form-control" type="email" path="email" />
								</div>
								<div class="form-group  col-md-3">
									<label class="control-label">Địa chỉ</label>
									<form:input class="form-control" type="text" path="address" />
								</div>
								<div class="form-group  col-md-3">
									<label class="control-label">Ngày đăng ký</label>
									<form:input class="form-control" type="date"
										path="dateOfRegistration" />
								</div>
							</div>
						</div>
						<button class="btn btn-save" type="submit">Cập nhật</button>
						<a class="btn btn-cancel" type="button" href="${contextPath }/petsowners/list">Hủy bỏ</a>
					</form:form>
				</div>
	</main>

</body>
</html>