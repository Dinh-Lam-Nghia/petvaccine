<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- Include your head content here -->
    <jsp:include page="/WEB-INF/views/head.jsp" />
</head>
<body onload="time()" class="app sidebar-mini rtl">
    <!-- Include your menu content here -->
    <jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>

    <main class="app-content">
        <div class="app-title">
            <ul class="app-breadcrumb breadcrumb">
                <li class="breadcrumb-item"><a href="${contextPath}/appointments/list">Danh sách cuộc hẹn</a></li>
                <li class="breadcrumb-item">Thêm cuộc hẹn mới</li>
            </ul>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="tile">
                    <h3 class="tile-title">Thêm mới thông tin cuộc hẹn</h3>
                    <div class="tile-body">
                        <form:form method="post" action="${contextPath}/appointments/create" modelAttribute="appointment" class="row">
                            <div class="form-group col-md-4">
                                <label class="control-label">Tên của thú cưng</label>
                                <form:select path="petID.petID" class="form-control" id="exampleSelect1">
                                    <form:option value="0">---Chọn thú cưng---</form:option>
                                    <form:options items="${pets}" itemLabel="petName" itemValue="petID" />
                                </form:select>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="control-label">Tên của chủ thú cưng</label>
                                <form:select path="ownerID.ownerID" class="form-control" id="ownerSelect">
                                    <form:option value="0">---Chọn chủ thú cưng---</form:option>
                                    <form:options items="${owners}" itemLabel="ownerName" itemValue="ownerID" />
                                </form:select>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="control-label">Tên của bác sĩ thú y</label>
                                <form:select path="veterinarianID.veterinarianID" class="form-control" id="veterinarianSelect">
                                    <form:option value="0">---Chọn bác sĩ thú y---</form:option>
                                    <form:options items="${veterinarians}" itemLabel="veterinarianName" itemValue="veterinarianID" />
                                </form:select>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="control-label">Tên của phòng khám</label>
                                <form:select path="clinicID.clinicID" class="form-control" id="clinicSelect">
                                    <form:option value="0">---Chọn phòng khám---</form:option>
                                    <form:options items="${clinics}" itemLabel="clinicName" itemValue="clinicID" />
                                </form:select>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="control-label">Ngày cuộc hẹn</label>
                                <form:input path="appointmentDate" type="date" class="form-control" required="required" />
                            </div>
                            <div class="form-group col-md-4">
                                <label class="control-label">Mục đích của cuộc hẹn</label>
                                <form:input path="purpose" class="form-control" required="required" />
                            </div>
                            <div class="form-group col-md-12">
                                <button class="btn btn-save" type="submit">Lưu lại</button>
                                <button class="btn btn-cancel" type="button" onclick="window.location.href='${contextPath}/appointments/list'">Hủy bỏ</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </main>
</body>
</html>
