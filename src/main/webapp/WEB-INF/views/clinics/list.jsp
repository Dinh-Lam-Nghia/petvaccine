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
			<ul class="app-breadcrumb breadcrumb side">
				<li class="breadcrumb-item active"><a href="#"><b>Danh sách phòng khám</b></a></li>
			</ul>
			<div id="clock"></div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="tile">
					<div class="tile-body">
						<div class="row element-button">
							<div class="col-sm-2">
								<a class="btn btn-add btn-sm" href="${contextPath }/clinics/create" title="Thêm"><i class="fas fa-plus"></i> Thêm phòng khám mới</a>
							</div>
							<form action="${contextPath}/clinics/list" method="get" class="form-inline">
								<div class="form-group">
									<label for="keyword">Tìm kiếm:</label>
									<input type="text" class="form-control" name="keyword" placeholder="Nhập từ khóa" value="${keyword}">
								</div>
								<button type="submit" class="btn btn-primary">Tìm kiếm</button>
							</form>
						</div>
						<table class="table table-hover table-bordered" id="sampleTable">
							<thead>
								<tr>
									<th width="10"><input type="checkbox" id="all"></th>
									<th>Địa chỉ</th>
									<th>Tên phòng khám</th>
									<th>Số điện thoại</th>
									<th>Chức năng</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="clinic" items="${clinicsList}">
									<tr>
										<td><input type="checkbox" name="clinicID" value="${clinic.clinicID}"></td>
										<td>${clinic.address}</td>
										<td>${clinic.clinicName}</td>
										<td>${clinic.phoneNumber}</td>
										<td>
											<a href="${contextPath}/clinics/edit/${clinic.clinicID}" class="btn btn-sm btn-edit" title="Sửa"><i class="fas fa-edit"></i></a> 
											<a href="${contextPath}/clinics/delete/${clinic.clinicID}" class="btn btn-sm btn-delete" title="Xóa" onclick="return confirm('Bạn có chắc chắn muốn xóa phòng khám này?');"><i class="fas fa-trash-alt"></i></a>
										</td>
									</tr>
								</c:forEach>
								<c:if test="${not empty successMessage}">
									<div class="alert alert-success">${successMessage}</div>
								</c:if>
								<c:if test="${not empty errorMessage}">
									<div class="alert alert-danger">${errorMessage}</div>
								</c:if>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>
