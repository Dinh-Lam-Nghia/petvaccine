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
							sách hồ sơ tiêm chủng</b></a></li>
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
									href="${contextPath }/vaccinationrecords/create" title="Thêm"><i
									class="fas fa-plus"></i> Thêm hồ sơ tiêm chủng</a>
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
						<table class="table table-hover table-bordered js-copytextarea"
							cellpadding="0" cellspacing="0" border="0" id="sampleTable">
							<form method="get" action="${contextPath}/vaccinationrecords/list" class="row">
								<div class="form-group col-md-3" style="float: right;">
									<label class="control-label">Tìm kiếm</label> <input
										class="form-control" type="text" name="keyword"  value="${param.keyword}">
								</div>
							</form>
							<thead>
								<tr>
									<th width="10"><input type="checkbox" id="all"></th>
									<th>Tên thú cưng</th>
									<th>Tên vaccine</th>
									<th>Ngày tiêm chủng</th>
									<th>Bác sĩ</th>
									<th>Ngày đến hạn tiếp theo</th> 
									<th width="100">Tính năng</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${vaccinationrecords}" var="record">
									<tr>
										<td width="10"><input type="checkbox" name="check1"
											value="1"></td>
										<td>${record.petID.petName }</td>
										<td>${record.vaccineID.vaccineName }</td>
										<td>${record.vaccinationDate }</td>
										<td>${record.veterinarianID.veterinarianName }</td>
										<td>${record.nextDueDate }</td> 
										<td><a
											href="${contextPath}/vaccinationrecords/edit?id=${record.recordID}"
											class="btn btn-primary btn-sm edit" title="Sửa"><i
												class="fas fa-edit"></i></a> 
												<a href="${contextPath}/vaccinationrecords/delete?id=${record.recordID}"
											class="btn btn-primary btn-sm trash" title="Xóa"
											onclick="return confirm('Bạn có chắc chắn muốn xóa không?');"><i
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