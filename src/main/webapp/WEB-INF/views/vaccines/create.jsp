<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
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
					href="${contextPath }/petsowners/list">Danh sách Vaccines</a></li>
				<li class="breadcrumb-item">Thêm Vaccine</li>
			</ul>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="tile">
					<h3 class="tile-title">Thêm mới thông tin Vaccine</h3>
					<div class="tile-body">
						<form:form action="${pageContext.request.contextPath}/vaccines/create" class="row" method="POST" modelAttribute="vaccines">
							<div class="form-group col-md-3">
								<label class="control-label">Tên Vaccine</label> 
								<form:input class="form-control" path="vaccineName"/>
							</div>
							<div class="form-group col-md-3">
								<label class="control-label">Nhà sản xuất</label> 
								<form:input class="form-control" path="manufacturer"/>
							</div>
							<div class="form-group  col-md-3">
								<label class="control-label">Ngừa bệnh</label> 
								<form:input class="form-control" path="diseasePrevented"/>
							</div>
							<div class="form-group  col-md-3">
								<label class="control-label">Hạn sử dụng</label> 
								<form:input class="form-control" path="duration" type="date"/>
							</div>
							<div class="form-group  col-md-3">
								<label class="control-label">Ngày đăng ký</label> 
								<form:input class="form-control" path="receiptDate" type="date"/>
							</div>
							<div class="form-group col-md-12">
								<button class="btn btn-save" type="submit">Lưu lại</button>

								<button class="btn btn-cancel" type="button"
									onclick="window.location.href='${contextPath}/vaccines/list'">Hủy
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