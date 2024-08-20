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
			<ul class="app-breadcrumb breadcrumb side">
				<li class="breadcrumb-item active"><a href="#"><b>Danh
							sách phòng khám</b></a></li>
			</ul>
			<div id="clock"></div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="tile">
					<div class="tile-body">
						<div class="row element-button">
							<div class="col-sm-2">

								<a class="btn btn-add btn-sm"
									href="${contextPath }/clinics/create" title="Thêm"><i
									class="fas fa-plus"></i> Thêm phòng khám mới</a>
							</div>
							<!-- Thêm form cho việc tải lên file Excel -->
							<form id="importForm" method="post" enctype="multipart/form-data"
								action="${contextPath}/clinics/import">
								<input type="file" name="file" accept=".xlsx, .xls"
									style="display: none;" id="fileInput" />
							</form>

							<!-- Nút tải từ file đã có trong HTML -->
							<div class="col-sm-2">
								<a class="btn btn-delete btn-sm nhap-tu-file" type="button"
									title="Nhập"
									onclick="document.getElementById('fileInput').click();"><i
									class="fas fa-file-upload"></i> Tải từ file</a>
							</div>

							<!-- JavaScript để tự động submit form sau khi chọn file -->
							<script>
								document.getElementById('fileInput')
										.addEventListener(
												'change',
												function() {
													document.getElementById(
															'importForm')
															.submit();
												});
							</script>



							<div class="col-sm-2">
								<a class="btn btn-delete btn-sm print-file" type="button"
									title="In" onclick="myApp.printTable()"><i
									class="fas fa-print"></i> In dữ liệu</a>
							</div>
							<div class="col-sm-2">
								<a class="btn btn-delete btn-sm print-file js-textareacopybtn"
									type="button" title="Sao chép"><i class="fas fa-copy"></i>
									Sao chép</a>
							</div>

							<div class="col-sm-2">
								<a class="btn btn-excel btn-sm" href="" title="In"><i
									class="fas fa-file-excel"></i> Xuất Excel</a>
							</div>
							<div class="col-sm-2">
								<a class="btn btn-delete btn-sm pdf-file" type="button"
									title="In" onclick="myFunction(this)"><i
									class="fas fa-file-pdf"></i> Xuất PDF</a>
							</div>
							<div class="col-sm-2">
								<a class="btn btn-delete btn-sm" type="button" title="Xóa"
									onclick="myFunction(this)"><i class="fas fa-trash-alt"></i>
									Xóa tất cả </a>
							</div>
						</div>
						<table class="table table-hover table-bordered" id="sampleTable">
							<form method="get" action="${contextPath}/clinics/list"
								class="row">
								<div class="form-group col-md-3" style="float: right;">
									<label class="control-label">Tìm kiếm</label> <input
										class="form-control" type="text" name="keyword"
										placeholder="Nhập tên, địa chỉ hoặc số điện thoại"
										value="${param.keyword}">
								</div>
							</form>

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
										<td><input type="checkbox" name="clinicID"
											value="${clinic.clinicID}"></td>
										<td>${clinic.address}</td>
										<td>${clinic.clinicName}</td>
										<td>${clinic.phoneNumber}</td>

										<td><a
											href="${contextPath}/clinics/edit?id=${clinic.clinicID}"
											class="btn btn-primary btn-sm edit" title="Sửa"><i
												class="fas fa-edit"></i></a> <a
											href="${contextPath}/clinics/delete/${clinic.clinicID}"
											class="btn btn-primary btn-sm trash" title="Xóa"
											onclick="return confirm('Bạn có chắc chắn muốn xóa phòng khám này?');"><i
												class="fas fa-trash-alt"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>
				</div>
			</div>
		</div>
	</main>

</body>
</html>