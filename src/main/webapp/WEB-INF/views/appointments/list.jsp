<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
				<li class="breadcrumb-item active"><a href="#"><b>Danh
							sách cuộc hẹn</b></a></li>
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
									href="${contextPath}/appointments/create" title="Thêm"><i
									class="fas fa-plus"></i> Thêm cuộc hẹn mới</a>
							</div>
							<form id="importForm" method="post" enctype="multipart/form-data"
								action="${contextPath}/appointments/import">
								<input type="file" name="file" accept=".xlsx, .xls"
									style="display: none;" id="fileInput" />
							</form>
							<div class="col-sm-2">
								<a class="btn btn-delete btn-sm nhap-tu-file" type="button"
									title="Nhập"
									onclick="document.getElementById('fileInput').click();"><i
									class="fas fa-file-upload"></i> Tải từ file</a>
							</div>
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
								<a class="btn btn-excel btn-sm" href="" title="Xuất Excel"><i
									class="fas fa-file-excel"></i> Xuất Excel</a>
							</div>
							<div class="col-sm-2">
								<a class="btn btn-delete btn-sm pdf-file" type="button"
									title="Xuất PDF" onclick="myFunction(this)"><i
									class="fas fa-file-pdf"></i> Xuất PDF</a>
							</div>
							<div class="col-sm-2">
								<a class="btn btn-delete btn-sm" type="button" title="Xóa"
									onclick="myFunction(this)"><i class="fas fa-trash-alt"></i>
									Xóa tất cả</a>
							</div>
						</div>
						<table class="table table-hover table-bordered" id="sampleTable">
							<form method="get" action="${contextPath}/appointments/list"
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
									<th>Tên của thú cưng</th>
									<th>Tên của chủ thú cưng</th>
									<th>Tên của bác sĩ thú y</th>
									<th>Tên của phòng khám</th>
									<th>Ngày cuộc hẹn</th>
									<th>Mục đích của cuộc hẹn</th>
									<th>Phê duyệt</th>
									<th>Chức năng</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="appointment" items="${appointmentsList}">
									<tr>
										<td><input type="checkbox" name="selectedAppointments"
											value="${appointment.appointmentID}"></td>
										<td>${appointment.petID.petName}</td>
										<td>${appointment.ownerID.ownerName}</td>
										<td>${appointment.veterinarianID.veterinarianName}</td>
										<td>${appointment.clinicID.clinicName}</td>
										<td><fmt:formatDate
												value="${appointment.appointmentDate}" pattern="dd/MM/yyyy" /></td>
										<td>${appointment.purpose}</td>
										<td><c:choose>
												<c:when test="${appointment.delete == 1}">
													<td><a
														href="${contextPath}/appointments/edit/${appointment.appointmentID}"
														class="btn btn-primary btn-sm edit" title="Sửa"><i
															class="fas fa-edit"></i></a> <a
														href="${contextPath}/appointments/delete/${appointment.appointmentID}"
														class="btn btn-primary btn-sm trash" title="Xóa"
														onclick="return confirm('Bạn có chắc chắn muốn xóa cuộc hẹn này?');"><i
															class="fas fa-trash-alt"></i></a></td>

												</c:when>
												<c:otherwise>
													<a
														href="${contextPath}/appointments/accept/${appointment.appointmentID}"
														class="btn btn-success btn-sm">Chấp nhận</a>
													<a
														href="${contextPath}/appointments/reject/${appointment.appointmentID}"
														class="btn btn-warning btn-sm">Từ chối</a>
												</c:otherwise>
											</c:choose></td>
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
