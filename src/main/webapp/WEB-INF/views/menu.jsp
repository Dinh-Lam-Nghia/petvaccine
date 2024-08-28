<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<!-- Navbar-->
<header class="app-header">
	<!-- Sidebar toggle button-->
	<a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
		aria-label="Hide Sidebar"></a>
	<!-- Navbar Right Menu-->
	<ul class="app-nav">


		<!-- User Menu-->
		<li> <p class="text-white" style="font-size: 19px; padding-right: 19px; margin-top: 4px">Hello, ${sessionScope.displayname}</p></li>
		<li><a class="app-nav__item" href="${contextPath }/logout"><i
				class='bx bx-log-out bx-rotate-180'></i> </a></li>
	</ul>
</header>
<!-- Sidebar menu-->
<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
<aside class="app-sidebar">
	<div class="app-sidebar__user">
		<img class="app-sidebar__user-avatar"
			src="${contextPath}/resources/images/petVaccine.png" width="50px"
			alt="User Image">
		<div>
			<p class="app-sidebar__user-name">
				<b>Pet Vaccines</b>
			</p>
		</div>
	</div>
	<hr>
	<ul class="app-menu">
		<!--  <li><a class="app-menu__item haha" href="phan-mem-ban-hang.html"><i class='app-menu__icon bx bx-cart-alt'></i>
          <span class="app-menu__label">POS Bán Hàng</span></a></li> -->
            <c:if test="${sessionScope.role == '1'}">
				<li><a class="app-menu__item ${menu_index }"
					href="${contextPath }/"><i
						class='app-menu__icon bx bx-tachometer'></i><span
						class="app-menu__label">Bảng thống kê</span></a></li>
		
				<li><a class="app-menu__item ${menu_clinics }"
					href="${contextPath }/clinics/list"><i class='bx bx-home-heart'
						style="font-size: 24px; padding-right: 19px"></i> <span
						class="app-menu__label">Quản lý phòng khám</span></a></li>
		
				<li><a class="app-menu__item ${menu_veterinarians }"
					href="${contextPath }/veterinarians/list"><i class='bx bxs-group'
						style="font-size: 24px; padding-right: 19px"></i><span
						class="app-menu__label">Quản lý Bác sĩ </span></a></li>
		
				<li><a class="app-menu__item ${menu_petsowners }"
					href="${contextPath }/petsowners/list"><i
						class='app-menu__icon bx bx-user-voice'></i><span
						class="app-menu__label">Quản lý khách hàng</span></a></li>
		
				<li><a class="app-menu__item ${menu_pets }"
					href="${contextPath }/pets/list"><i class='bx bxs-cat'
						style="font-size: 24px; padding-right: 19px"></i><span
						class="app-menu__label">Quản lý thú cưng</span></a></li>
		
				<li><a class="app-menu__item ${menu_appointments  }"
					href="${contextPath }/appointments/list"><i class='app-menu__icon bx bx-task'></i><span
						class="app-menu__label">Quản lý cuộc hẹn</span></a></li>
		
				<li><a class="app-menu__item ${menu_vaccines }"
					href="${contextPath }/vaccines/list"><i class='bx bx-test-tube'
						style="font-size: 24px; padding-right: 19px"></i><span
						class="app-menu__label">Quản lý vắc-xin</span></a></li>
		
				<li><a class="app-menu__item ${menu_vaccinationRecords  }"
					href="${contextPath }/vaccinationrecords/list"><i class='bx bx-folder-open'
						style="font-size: 24px; padding-right: 19px"></i><span
						class="app-menu__label">Hồ sơ tiêm chủng</span></a></li>
			</c:if>
			<c:if test="${sessionScope.role == '2'}">
          		<li><a class="app-menu__item ${menu_appointments  }"
					href="${contextPath }/customers/history"><i class='app-menu__icon bx bx-task'></i><span
						class="app-menu__label">Lịch sử tiêm chủng</span></a></li>
	          	<li><a class="app-menu__item ${menu_vaccinationRecords  }"
						href="${contextPath }/customers/register"><i class='bx bx-folder-open'
							style="font-size: 24px; padding-right: 19px"></i><span
							class="app-menu__label">Đăng ký tiêm chủng</span></a></li>
          	</c:if>	
			
	</ul>
</aside>
