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
				<li class="breadcrumb-item"><a href="${contextPath }/pets/list">Danh
						sách thú cưng</a></li>
				<li class="breadcrumb-item">Sửa thú cưng</li>
			</ul>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="tile">
					<form:form action="${contextPath}/pets/edit" method="POST"
						modelAttribute="pets">
						<h3 class="tile-title">Sửa thông tin thú cưng</h3>

						<div class="tile-body">
							<div class="row">
								<form:input class="form-control" type="hidden" path="delete" />
								<form:input class="form-control" type="hidden" path="petID" />

								<div class="form-group col-md-3 ">
									<label for="exampleSelect1" class="control-label">Chủ
										thú cưng</label>
									<form:select path="ownerID.ownerID" class="form-control"
										id="exampleSelect1">
										<option value="0">---Chọn chủ thú cưng---</option>
										<form:options items="${petowners}" itemLabel="ownerName"
											itemValue="ownerID" />
									</form:select>
								</div>

								<div class="form-group col-md-3">
									<label class="control-label">Tên thú cưng</label>
									<form:input class="form-control" type="text" path="petName" />
								</div>

								<div class="form-group  col-md-3">
									<label class="control-label">Loài</label>
									<form:input class="form-control" type="text" path="species" />
								</div>

								<div class="form-group  col-md-3">
									<label class="control-label">Giống loài</label>
									<form:input class="form-control" type="text" path="breed" />
								</div>

								<div class="form-group  col-md-3">
									<label class="control-label">Ngày sinh</label>
									<form:input class="form-control" type="date" path="dateOfBirth" />
								</div>

								<div class="form-group col-md-3">
									<label for="exampleSelect1" class="control-label">Giới
										tính</label>
									<form:select path="gender" class="form-control"
										id="exampleSelect1">
										<form:option value="Con đực">Con đực</form:option>
										<form:option value="Con cái">Con cái</form:option>
									</form:select>
								</div>

								<div class="form-group  col-md-3">
									<label class="control-label">Số hiệu vi mạch</label>
									<form:input class="form-control" type="text" path="microchipID" />
								</div>
								<div class="form-group col-md-12">
								<button class="btn btn-save" type="submit">Lưu lại</button>

								<button class="btn btn-cancel" type="button"
									onclick="window.location.href='${contextPath}/pets/list'">Hủy
									bỏ</button>
							</div>

							</div>
						</div>
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