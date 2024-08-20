<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="/WEB-INF/views/head.jsp" />

<title>Vaccines</title>
</head>
<body onload="time()" class="app sidebar-mini rtl">
	<!--  -->
	<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
	<!--  -->

	<main class="app-content">
		<div class="app-title">
			<ul class="app-breadcrumb breadcrumb side">
				<li class="breadcrumb-item active"><a href="#"><b>Danh
							sách Vaccines</b></a></li>
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
									href="${contextPath }/vaccines/create" title="Thêm"><i
									class="fas fa-plus"></i> Thêm Vaccine</a>
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
							<form class="row">
								<div class="form-group col-md-3" style="float: right;">
									<label class="control-label">Tim kiếm </label> 
									<input class="form-control" type="text">
								</div>
							</form>
							<thead>
								<tr>
									<th width="10"><input type="checkbox" id="all"></th>
									<th>Tên Vaccine</th>
									<th>Nhà sản xuất</th>
									<th>Ngừa bệnh</th>
									<th>Hạn sử dụng</th>
									<th>Ngày đăng ký</th>
									<th width="100">Tính năng</th>
								</tr>
								
							</thead>
							<tbody>
								<c:forEach items="${vaccines.getContent() }" var="v">
									<tr>
										<td width="10"><input type="checkbox" name="check1"
											value="1"></td>
										<td>${v.vaccineName}</td>
										<td>${v.manufacturer }</td>
										<td>${v.diseasePrevented }</td>
										<td>${v.duration }</td>
										<td>0926737168</td>
										<td class="table-td-center">
											<form action="${contextPath }/vaccines/delete/${v.vaccineID}" method="post">
												<button class="btn btn-primary btn-sm trash" type="button"
													title="Xóa" onclick="myFunction(this)">
													<i class="fas fa-trash-alt"></i>
												</button>
											</form>
											<form action="${contextPath }/vaccines/edit/${v.vaccineID}" method="post">
												<button class="btn btn-primary btn-sm edit" type="button"
													title="Sửa" id="show-emp" data-toggle="modal"
													data-target="#ModalUP">
													<i class="fas fa-edit"></i>
												</button>
											</form>
										</td>
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