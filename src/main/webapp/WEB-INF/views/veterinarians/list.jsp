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
							sách bác sĩ</b></a></li>
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
									href="${contextPath }/veterinarians/create" title="Thêm"><i
									class="fas fa-plus"></i> Thêm bác sĩ mới</a>
							</div>
							<div class="col-sm-2">
								<a class="btn btn-delete btn-sm nhap-tu-file" type="button"
									title="Nhập" onclick="myFunction(this)"><i
									class="fas fa-file-upload"></i> Tải từ file</a>
							</div>

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
							<thead>
								<form method="get" action="${contextPath}/veterinarians/list"
									class="row">
									<div class="form-group col-md-3" style="float: right;">
										<label class="control-label">Tìm kiếm</label> <input
											class="form-control" type="text" name="keyword"
											placeholder="Nhập tên, email hoặc số điện thoại"
											value="${param.keyword}">
									</div>
								</form>

								<tr>
									<th width="10"><input type="checkbox" id="all"></th>
									<th>Email</th>
									<th>Tên bác sĩ</th>
									<th>Số điện thoại</th>
									<th>Chức năng</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="veterinarian" items="${veterinariansList}">
									<tr>
										<td><input type="checkbox" name="ids"
											value="${veterinarian.veterinarianID}"></td>
										<td>${veterinarian.email}</td>
										<td>${veterinarian.veterinarianName}</td>
										<td>${veterinarian.phoneNumber}</td>
										<td><a
											href="${contextPath}/veterinarians/edit?id=${veterinarian.veterinarianID}"
											class="btn btn-sm btn-edit" title="Sửa"> <i
												class="fas fa-edit"></i>
										</a> <a
											href="${contextPath}/veterinarians/delete/${veterinarian.veterinarianID}"
											class="btn btn-sm btn-delete" title="Xóa"
											onclick="return confirm('Bạn có chắc chắn muốn xóa bác sĩ này?');">
												<i class="fas fa-trash-alt"></i>
										</a></td>
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