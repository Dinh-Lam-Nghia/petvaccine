<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
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
					<h3 class="tile-title">Sửa thông tin khách hàng</h3>
					<div class="tile-body">
						<!-- 
						<div class="row element-button">
							<div class="col-sm-2">
								<a class="btn btn-add btn-sm" data-toggle="modal"
									data-target="#exampleModalCenter"><i
									class="fas fa-folder-plus"></i> Thêm nhà cung cấp</a>
							</div>
							<div class="col-sm-2">
								<a class="btn btn-add btn-sm" data-toggle="modal"
									data-target="#adddanhmuc"><i class="fas fa-folder-plus"></i>
									Thêm danh mục</a>
							</div>
							<div class="col-sm-2">
								<a class="btn btn-add btn-sm" data-toggle="modal"
									data-target="#addtinhtrang"><i class="fas fa-folder-plus"></i>
									Thêm tình trạng</a>
							</div>
						</div>
					 -->
						<form class="row">
							<div class="form-group col-md-3">
								<label class="control-label">Họ và tên </label> <input
									class="form-control" type="text">
							</div>
							<div class="form-group col-md-3">
								<label class="control-label">Số diện thoại</label> <input
									class="form-control" type="number">
							</div>
							<div class="form-group  col-md-3">
								<label class="control-label">Email</label> <input
									class="form-control" type="email">
							</div>
							<div class="form-group  col-md-3">
								<label class="control-label">Địa chỉ</label> <input
									class="form-control" type="text">
							</div>
							<div class="form-group  col-md-3">
								<label class="control-label">Ngày đăng ký</label> <input
									class="form-control" type="date">
							</div>
							<!-- 
							<div class="form-group col-md-3 ">
								<label for="exampleSelect1" class="control-label">Nhà
									cung cấp</label> <select class="form-control" id="exampleSelect1">
									<option>-- Chọn nhà cung cấp --</option>
									<option>Phong vũ</option>
									<option>Thế giới di động</option>
									<option>FPT</option>
									<option>Võ Trường</option>
								</select>
							</div>
							 
							<div class="form-group col-md-12">
								<label class="control-label">Mô tả sản phẩm</label>
								<textarea class="form-control" name="mota" id="mota"></textarea>
								<script>
									CKEDITOR.replace('mota');
								</script>
							</div>-->
					</div>
					<button class="btn btn-save" type="button">Cập nhật</button>
					<a class="btn btn-cancel" href="${contextPath }/petsowners/list">Hủy bỏ</a>
				</div>
	</main>

</body>
</html>