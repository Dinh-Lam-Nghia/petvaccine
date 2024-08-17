<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<li class="breadcrumb-item"><a href="${contextPath }/clinics/list">Danh sách phòng khám</a></li>
				<li class="breadcrumb-item">Chỉnh sửa phòng khám</li>
			</ul>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="tile">
					<h3 class="tile-title">Chỉnh sửa thông tin phòng khám</h3>
					<div class="tile-body">
						<form action="${contextPath}/clinics/update" method="post" class="row">
							<input type="hidden" name="clinicID" value="${clinic.clinicID}" />
							<div class="form-group col-md-3">
								<label class="control-label">Tên phòng khám</label>
								<input class="form-control" type="text" name="clinicName" value="${clinic.clinicName}">
							</div>
							<div class="form-group col-md-3">
								<label class="control-label">Địa chỉ</label>
								<input class="form-control" type="text" name="address" value="${clinic.address}">
							</div>
							<div class="form-group col-md-3">
								<label class="control-label">Số điện thoại</label>
								<input class="form-control" type="text" name="phoneNumber" value="${clinic.phoneNumber}">
							</div>
							<button class="btn btn-save" type="submit">Lưu lại</button>
							<button class="btn btn-cancel" type="reset">Hủy bỏ</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>
