<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
				<li class="breadcrumb-item"><a href="${contextPath }/vaccinationrecords/list">Danh
						sách hồ sơ tiêm chủng</a></li>
				<li class="breadcrumb-item">Sửa hồ sơ tiêm chủng</li>
			</ul>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="tile">
					<form:form action="${contextPath}/vaccinationrecords/edit" method="POST"
						modelAttribute="vaccinationRecords">
						<h3 class="tile-title">Sửa thông tin hồ sơ</h3>

						<div class="tile-body">
							<div class="row">
								<form:input class="form-control" type="hidden" path="recordID" />
								<form:input class="form-control" type="hidden" path="delete" />
									
								<div class="form-group col-md-3 ">
									<label for="exampleSelect1" class="control-label">Thú cưng</label>
									<form:select path="petID.petID" class="form-control"
										id="exampleSelect1">
										<option value="0">---Chọn thú cưng---</option>
										<form:options items="${pets}" itemLabel="petName" itemValue="petID" />
									</form:select>
								</div>	
								
								<div class="form-group col-md-3 ">
									<label for="exampleSelect1" class="control-label">Vaccine</label>
									<form:select path="vaccineID.vaccineID" class="form-control"
										id="exampleSelect1">
										<option value="0">---Chọn vaccines---</option>
										<form:options items="${vaccines}" itemLabel="vaccineName" itemValue="vaccineID" />
									</form:select>
								</div>	
								
								<div class="form-group col-md-3">
									<label class="control-label">Ngày tiêm chủng</label>
									<form:input class="form-control" type="date" path="vaccinationDate" />
								</div>
								<div class="form-group col-md-3 ">
									<label for="exampleSelect1" class="control-label">Bác sĩ</label>
									<form:select path="veterinarianID.veterinarianID" class="form-control"
										id="exampleSelect1">
										<option value="0">---Chọn bác sĩ---</option>
										<form:options items="${veterinarians}" itemLabel="veterinarianName" itemValue="veterinarianID" />
									</form:select>
								</div>
								
								
								<div class="form-group  col-md-3">
									<label class="control-label">Ngày đến hạn tiếp theo</label>
									<form:input class="form-control" type="date" path="nextDueDate" />
								</div>
								
							</div>
						</div>
						<button class="btn btn-save" type="submit">Lưu lại</button>
						<button class="btn btn-cancel" type="reset">Hủy bỏ</button>
					</form:form>
				</div>
			</div>
		</div>
	</main>

	<!--  -->
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	<!--  -->

</body>
</html>