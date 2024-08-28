<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">

.vaccinated {
    background-color: #28a745; /* Màu xanh lá cây */
}

.not-vaccinated {
    background-color: #dc3545; /* Màu đỏ */
}
.status {
    color: white; /* Màu chữ trắng */
    padding: 10px; /* Khoảng cách bên trong */
    border-radius: 5px; /* Góc bo tròn */
    font-size: 16px; /* Kích thước chữ */
    font-weight: bold; /* Chữ đậm */
    text-align: center; /* Căn giữa văn bản */
    width: fit-content; /* Chiều rộng tự động theo nội dung */
    margin: 10px; /* Khoảng cách bên ngoài */
}
</style>
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
									
									<th>Tên thú cưng</th>
									<th>Tên vaccine</th>
									<th>Ngày tiêm chủng</th>
									<th>Bác sĩ</th>
									<th>Ngày đến hạn tiếp theo</th> 
									<th width="100">Tính trạng</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${vaccinationrecords}" var="record">
							<input id="recordID" type="text" value="${record.recordID}" hidden  />
									<tr>
										<td>${record.petID.petName }</td>
										<td>${record.vaccineID.vaccineName }</td>
										<td>${record.vaccinationDate }</td>
										<td>${record.veterinarianID.veterinarianName }</td>
										<td>${record.nextDueDate }</td> 
										<td>
										<c:if test="${record.status=='Đã tiêm'}">
											<div id="status" class="status vaccinated" >
										        ${record.status}
										    </div>
										</c:if>
										<c:if test="${record.status=='Chưa tiêm'}">
											<div id="status" class="status not-vaccinated">
										        ${record.status}
										    </div>
										</c:if>
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