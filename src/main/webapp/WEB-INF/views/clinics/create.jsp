<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Include your head content here -->
<jsp:include page="/WEB-INF/views/head.jsp" />

</head>
<body onload="time()" class="app sidebar-mini rtl">
	<!-- Include your menu content here -->
	<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>

	<main class="app-content">
		<div class="app-title">
			<ul class="app-breadcrumb breadcrumb">
				<li class="breadcrumb-item"><a
					href="${contextPath}/clinics/list">Danh sách phòng khám</a></li>
				<li class="breadcrumb-item">Thêm phòng khám mới</li>
			</ul>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="tile">
					<h3 class="tile-title">Thêm mới thông tin phòng khám</h3>
					<div class="tile-body">
						<form:form method="post" action="${contextPath}/clinics/create"
							modelAttribute="clinic" class="row">
							<div class="form-group col-md-4">
								<label class="control-label">Tên phòng khám</label>
								<form:input path="clinicName" class="form-control"
									required="required" />
							</div>
							<div class="form-group col-md-4">
								<label class="control-label">Địa chỉ</label>
								<form:input path="address" class="form-control"
									required="required" />
							</div>
							<div class="form-group col-md-4">
								<label class="control-label">Số điện thoại</label>
								<form:input path="phoneNumber" class="form-control"
									required="required" />
							</div>
							<div class="form-group col-md-12">
								<button class="btn btn-save" type="submit">Lưu lại</button>

								<button class="btn btn-cancel" type="button"
									onclick="window.location.href='${contextPath}/clinics/list'">Hủy
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
