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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .form-group {
            margin-bottom: 1rem;
        }
    </style>
</head>
<body onload="time()" class="app sidebar-mini rtl">
    <!--  -->
    <jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
    <!--  -->

    <main class="app-content">
        <div class="app-title">
            <ul class="app-breadcrumb breadcrumb">
                <li class="breadcrumb-item"><a href="${contextPath }customers/vaccination/register">Hồ sơ tiêm chủng</a></li>
                <li class="breadcrumb-item">Đăng ký tiêm chủng</li>
            </ul>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="tile">
                    <form:form action="${contextPath}/customers/register" method="POST" modelAttribute="vaccinationrecords">
                        <h3 class="tile-title">Thêm mới thông tin hồ sơ</h3>

                        <div class="tile-body">
                            <div class="form-group">
                            	<form:input path="status" type="hidden"/>
                                <form:input type="hidden" path="delete" value="1" />
                            </div>

                            <div class="form-group">
                                <label for="petID" class="control-label">Thú cưng</label>
                                <form:select path="petID.petID" class="form-control" id="petID">
                                    <option value="0">---Chọn thú cưng---</option>
                                    <form:options items="${pets}" itemLabel="petName" itemValue="petID" />
                                </form:select>
                            </div>

                            <div class="form-group">
                                <label for="vaccineID" class="control-label">Vaccine</label>
                                <form:select path="vaccineID.vaccineID" class="form-control" id="vaccineID">
                                    <option value="0">---Chọn vaccine---</option>
                                    <form:options items="${vaccines}" itemLabel="vaccineName" itemValue="vaccineID" />
                                </form:select>
                            </div>

                            <div class="form-group">
                                <label for="vaccinationDate" class="control-label">Ngày tiêm chủng</label>
                                <form:input type="date" path="vaccinationDate" class="form-control" id="vaccinationDate"  />
                            </div>

                            <div class="form-group">
                                <label for="veterinarianID" class="control-label">Bác sĩ</label>
                                <form:select path="veterinarianID.veterinarianID" class="form-control" id="veterinarianID">
                                    <option value="0">---Chọn bác sĩ---</option>
                                    <form:options items="${veterinarians}" itemLabel="veterinarianName" itemValue="veterinarianID" />
                                </form:select>
                            </div>

                            <div class="form-group">
                                <label for="nextDueDate" class="control-label">Ngày đến hạn tiếp theo</label>
                                <form:input type="date" path="nextDueDate" class="form-control" id="nextDueDate"/>
                            </div>
                        </div>

                        <div class="form-group col-md-12">
	                        <button class="btn btn-save btn-success" type="submit">Lưu lại</button>
	                        <button class="btn btn-cancel btn-danger" type="reset">Hủy bỏ</button>
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
