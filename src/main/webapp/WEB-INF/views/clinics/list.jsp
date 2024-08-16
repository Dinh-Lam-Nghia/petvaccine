<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
							sách phòng khám</b></a></li>
			</ul>
			<div id="clock"></div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="tile">
					<div class="tile-body">
						<div class="row element-button">
							<div class="col-sm-2">

								<a class="btn btn-add btn-sm" href="form-add-san-pham.html"
									title="Thêm"><i class="fas fa-plus"></i> Thêm phòng khám
									mới</a>
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
						<table class="table table-hover table-bordered" id="sampleTable">
							<thead>
								<tr>
									<th width="10"><input type="checkbox" id="all"></th>
									<th>Mã phòng khám</th>
									<th>Địa chỉ</th>
									<th>Tên phòng khám</th>
									<th>Số điện thoại</th>
									<th>Chức năng</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td width="10"><input type="checkbox" name="check1"
										value="1"></td>
									<td>71309005</td>
									<td>Đà Nẵng</td>
									<td>Pep</td>
									<td>0339332323</td>
									<td><button class="btn btn-primary btn-sm trash"
											type="button" title="Xóa" onclick="myFunction(this)">
											<i class="fas fa-trash-alt"></i>
										</button>
										<button class="btn btn-primary btn-sm edit" type="button"
											title="Sửa" id="show-emp" data-toggle="modal"
											data-target="#ModalUP">
											<i class="fas fa-edit"></i>
										</button></td>
								</tr>


							</tbody>
							<tbody>
								<tr>
									<td width="10"><input type="checkbox" name="check1"
										value="1"></td>
									<td>71309005</td>
									<td>Đà Nẵng</td>
									<td>Pep</td>
									<td>0339332323</td>
									<td><button class="btn btn-primary btn-sm trash"
											type="button" title="Xóa" onclick="myFunction(this)">
											<i class="fas fa-trash-alt"></i>
										</button>
										<button class="btn btn-primary btn-sm edit" type="button"
											title="Sửa" id="show-emp" data-toggle="modal"
											data-target="#ModalUP">
											<i class="fas fa-edit"></i>
										</button></td>
								</tr>


							</tbody>
							<tbody>
								<tr>
									<td width="10"><input type="checkbox" name="check1"
										value="1"></td>
									<td>71309005</td>
									<td>Đà Nẵng</td>
									<td>Pep</td>
									<td>0339332323</td>
									<td><button class="btn btn-primary btn-sm trash"
											type="button" title="Xóa" onclick="myFunction(this)">
											<i class="fas fa-trash-alt"></i>
										</button>
										<button class="btn btn-primary btn-sm edit" type="button"
											title="Sửa" id="show-emp" data-toggle="modal"
											data-target="#ModalUP">
											<i class="fas fa-edit"></i>
										</button></td>
								</tr>


							</tbody>
							<tbody>
								<tr>
									<td width="10"><input type="checkbox" name="check1"
										value="1"></td>
									<td>71309005</td>
									<td>Đà Nẵng</td>
									<td>Pep</td>
									<td>0339332323</td>
									<td><button class="btn btn-primary btn-sm trash"
											type="button" title="Xóa" onclick="myFunction(this)">
											<i class="fas fa-trash-alt"></i>
										</button>
										<button class="btn btn-primary btn-sm edit" type="button"
											title="Sửa" id="show-emp" data-toggle="modal"
											data-target="#ModalUP">
											<i class="fas fa-edit"></i>
										</button></td>
								</tr>


							</tbody>
							<tbody>
								<tr>
									<td width="10"><input type="checkbox" name="check1"
										value="1"></td>
									<td>71309005</td>
									<td>Đà Nẵng</td>
									<td>Pep</td>
									<td>0339332323</td>
									<td><button class="btn btn-primary btn-sm trash"
											type="button" title="Xóa" onclick="myFunction(this)">
											<i class="fas fa-trash-alt"></i>
										</button>
										<button class="btn btn-primary btn-sm edit" type="button"
											title="Sửa" id="show-emp" data-toggle="modal"
											data-target="#ModalUP">
											<i class="fas fa-edit"></i>
										</button></td>
								</tr>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</main>
	<!-- Modal for Editing -->
	<div class="modal fade" id="ModalUP" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Chỉnh sửa thông
						tin phòng khám</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>	
				<form action="edit.jsp" method="POST">
					<div class="modal-body">
						<input type="hidden" name="clinicId" id="clinicId">
						<div class="form-group">
							<label for="clinicName">Tên phòng khám</label> <input type="text"
								class="form-control" id="clinicName" name="clinicName" required>
						</div>
						<div class="form-group">
							<label for="clinicAddress">Địa chỉ</label> <input type="text"
								class="form-control" id="clinicAddress" name="clinicAddress"
								required>
						</div>
						<div class="form-group">
							<label for="clinicPhone">Số điện thoại</label> <input type="text"
								class="form-control" id="clinicPhone" name="clinicPhone"
								required>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Đóng</button>
						<button type="submit" class="btn btn-primary">Lưu thay
							đổi</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="src/jquery.table2excel.js"></script>
	<script src="js/main.js"></script>
	<!-- The javascript plugin to display page loading on top-->
	<script src="js/plugins/pace.min.js"></script>
	<!-- Page specific javascripts-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
	<!-- Data table plugin-->
	<script type="text/javascript"
		src="js/plugins/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="js/plugins/dataTables.bootstrap.min.js"></script>
	<script type="text/javascript">
        $('#sampleTable').DataTable();
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
      tmp = '<span class="date"> ' + today + ' - ' + nowTime +
        '</span>';
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
	<script>
        function deleteRow(r) {
            var i = r.parentNode.parentNode.rowIndex;
            document.getElementById("myTable").deleteRow(i);
        }
        jQuery(function () {
            jQuery(".trash").click(function () {
                swal({
                    title: "Cảnh báo",
                    text: "Bạn có chắc chắn là muốn xóa sản phẩm này?",
                    buttons: ["Hủy bỏ", "Đồng ý"],
                })
                    .then((willDelete) => {
                        if (willDelete) {
                            swal("Đã xóa thành công.!", {

                            });
                        }
                    });
            });
        });
        oTable = $('#sampleTable').dataTable();
        $('#all').click(function (e) {
            $('#sampleTable tbody :checkbox').prop('checked', $(this).is(':checked'));
            e.stopImmediatePropagation();
        });
    </script>
	<!--  -->
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	<!--  -->
</body>
</html>