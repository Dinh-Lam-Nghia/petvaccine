<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/WEB-INF/views/head.jsp" />
</head>

<body onload="time()" class="app sidebar-mini rtl">
	<!--  -->
	<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
	<!--  -->

	<main class="app-content">
		<div class="row">
			<div class="col-md-12">
				<div class="app-title">
					<ul class="app-breadcrumb breadcrumb">
						<li class="breadcrumb-item"><a href="#"><b>Bảng thống
									kê</b></a></li>
					</ul>
					<div id="clock"></div>
				</div>
			</div>
		</div>
		<div class="row">
			<!--Left-->
			<div class="col-md-12 col-lg-6">
				<div class="row">
					<!-- col-6 -->
					<div class="col-md-6">
						<div class="widget-small primary coloured-icon">
							<i class='fas fa-users fa-3x'></i>
							<div class="info">
								<h4>Khách hàng</h4>
								<p>
									<!-- Hiển thị số lượng khách hàng -->
									<b>${deletedCustomers} khách hàng</b>
								</p>
								<p class="info-tong">Tổng số khách hàng được quản lý.</p>
							</div>
						</div>
					</div>

					<!-- col-6 -->
					<div class="col-md-6">
						<div class="widget-small info coloured-icon">
							<i class='fas fa-syringe fa-3x'></i>
							<div class="info">
								<h4>Vaccine</h4>
								<p>
									<b>1850 vaccine</b>
								</p>
								<p class="info-tong">Tổng số vaccine được quản lý.</p>
							</div>
						</div>
					</div>
					<!-- col-6 -->
					<div class="col-md-6">
						<div class="widget-small warning coloured-icon">
							<i class='fas fa-paw fa-3x'></i>
							<div class="info">
								<h4>Thú cưng</h4>
								<p>
									<b>2 thú cưng</b>
								</p>
								<p class="info-tong">Tổng số thú cưng đã tiêm trong tháng.</p>
							</div>
						</div>
					</div>
					<!-- col-6 -->
					<div class="col-md-6">
						<div class="widget-small danger coloured-icon">
							<i class='fas fa-clock fa-3x'></i>
							<div class="info">
								<h4>Cuộc hẹn</h4>
								<p>
									<b>4 cuộc hẹn</b>
								</p>
								<p class="info-tong">Tổng số cuộc hẹn trong tháng.</p>
							</div>
						</div>
					</div>
					<!-- col-12 -->
					<div class="col-md-12">
						<div class="tile">
							<h3 class="tile-title">Tình trạng đơn hàng</h3>
							<div>
								<table class="table table-bordered">
									<thead>
										<tr>
											<th>ID đơn hàng</th>
											<th>Tên khách hàng</th>
											<th>Tổng tiền</th>
											<th>Trạng thái</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>AL3947</td>
											<td>Phạm Thị Ngọc</td>
											<td>19.770.000 đ</td>
											<td><span class="badge bg-info">Chờ xử lý</span></td>
										</tr>
										<tr>
											<td>ER3835</td>
											<td>Nguyễn Thị Mỹ Yến</td>
											<td>16.770.000 đ</td>
											<td><span class="badge bg-warning">Đang vận
													chuyển</span></td>
										</tr>
										<tr>
											<td>MD0837</td>
											<td>Triệu Thanh Phú</td>
											<td>9.400.000 đ</td>
											<td><span class="badge bg-success">Đã hoàn thành</span></td>
										</tr>
										<tr>
											<td>MT9835</td>
											<td>Đặng Hoàng Phúc</td>
											<td>40.650.000 đ</td>
											<td><span class="badge bg-danger">Đã hủy </span></td>
										</tr>
									</tbody>
								</table>
							</div>
							<!-- / div trống-->
						</div>
					</div>
					<!-- / col-12 -->
					<!-- col-12 -->
					<div class="col-md-20">
						<div class="tile">
							<h3 class="tile-title">Khách hàng mới</h3>
							<div>
								<table class="table table-hover">
									<thead>
										<tr>
											<th>Tên khách hàng</th>
											<th>Số điện thoại</th>
											<th>Email</th>
											<th>Địa chỉ</th>
											<th>Ngày đăng ký</th>
										</tr>
									</thead>
									<tbody>
										<!-- Sử dụng JSTL để hiển thị danh sách khách hàng mới -->
										<c:forEach var="customer" items="${newCustomers}">
											<tr>
												<td>${customer.ownerName}</td>
												<td>${customer.phoneNumber}</td>
												<td>${customer.email}</td>
												<td>${customer.address}</td>
												<td>${customer.dateOfRegistration}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>

					<!-- / col-12 -->
				</div>
			</div>
			<!--END left-->
			<!--Right-->
			<div class="col-md-12 col-lg-6">
				<div class="row">
					<div class="col-md-12">
						<div class="tile">
							<h3 class="tile-title">Dữ liệu 6 tháng đầu vào</h3>
							<div class="embed-responsive embed-responsive-16by9">
								<canvas class="embed-responsive-item" id="lineChartDemo"></canvas>
							</div>
						</div>
					</div>
					<div class="col-md-12">
						<div class="tile">
							<h3 class="tile-title">Thống kê 6 tháng doanh thu</h3>
							<div class="embed-responsive embed-responsive-16by9">
								<canvas class="embed-responsive-item" id="barChartDemo"></canvas>
							</div>
						</div>
					</div>
				</div>

			</div>
			<!--END right-->
		</div>

		<!--  -->
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
		<!--  -->

	</main>
	<script src="${contextPath}/resources/doc/js/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="${contextPath}/resources/doc/js/popper.min.js"></script>
	<script src="https://unpkg.com/boxicons@latest/dist/boxicons.js"></script>
	<!--===============================================================================================-->
	<script src="${contextPath}/resources/doc/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="${contextPath}/resources/doc/js/main.js"></script>
	<!--===============================================================================================-->
	<script src="${contextPath}/resources/doc/js/plugins/pace.min.js"></script>
	<!--===============================================================================================-->
	<script type="text/javascript"
		src="${contextPath}/resources/doc/js/plugins/chart.js"></script>
	<!--===============================================================================================-->
	<script type="text/javascript">
		var data = {
			labels : [ "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5",
					"Tháng 6" ],
			datasets : [ {
				label : "Dữ liệu đầu tiên",
				fillColor : "rgba(255, 213, 59, 0.767), 212, 59)",
				strokeColor : "rgb(255, 212, 59)",
				pointColor : "rgb(255, 212, 59)",
				pointStrokeColor : "rgb(255, 212, 59)",
				pointHighlightFill : "rgb(255, 212, 59)",
				pointHighlightStroke : "rgb(255, 212, 59)",
				data : [ 20, 59, 90, 51, 56, 100 ]
			}, {
				label : "Dữ liệu kế tiếp",
				fillColor : "rgba(9, 109, 239, 0.651)  ",
				pointColor : "rgb(9, 109, 239)",
				strokeColor : "rgb(9, 109, 239)",
				pointStrokeColor : "rgb(9, 109, 239)",
				pointHighlightFill : "rgb(9, 109, 239)",
				pointHighlightStroke : "rgb(9, 109, 239)",
				data : [ 48, 48, 49, 39, 86, 10 ]
			} ]
		};
		var ctxl = $("#lineChartDemo").get(0).getContext("2d");
		var lineChart = new Chart(ctxl).Line(data);

		var ctxb = $("#barChartDemo").get(0).getContext("2d");
		var barChart = new Chart(ctxb).Bar(data);
	</script>
	<script type="text/javascript">
		//Thời Gian
		function time() {
			var today = new Date();
			var weekday = new Array(7);
			weekday[0] = "Chủ Nhật";
			weekday[1] = "Thứ Hai";
			weekday[2] = "Thứ Ba";
			weekday[3] = "Thứ Tư";
			weekday[4] = "Thứ Năm";
			weekday[5] = "Thứ Sáu";
			weekday[6] = "Thứ Bảy";
			var day = weekday[today.getDay()];
			var dd = today.getDate();
			var mm = today.getMonth() + 1;
			var yyyy = today.getFullYear();
			var h = today.getHours();
			var m = today.getMinutes();
			var s = today.getSeconds();
			m = checkTime(m);
			s = checkTime(s);
			nowTime = h + " giờ " + m + " phút " + s + " giây";
			if (dd < 10) {
				dd = '0' + dd
			}
			if (mm < 10) {
				mm = '0' + mm
			}
			today = day + ', ' + dd + '/' + mm + '/' + yyyy;
			tmp = '<span class="date"> ' + today + ' - ' + nowTime + '</span>';
			document.getElementById("clock").innerHTML = tmp;
			clocktime = setTimeout("time()", "1000", "Javascript");

			function checkTime(i) {
				if (i < 10) {
					i = "0" + i;
				}
				return i;
			}
		}
	</script>
	<!--  -->
</body>

</html>