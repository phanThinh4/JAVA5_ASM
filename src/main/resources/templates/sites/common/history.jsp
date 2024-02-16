<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="card" id="accordion">
	<div class="card-header" data-parent="#accordion" href=""
		style="color: orangered;">
		<i class="bi bi-list-task" style="font-weight: bold;"></i> <a
			href="history" style="text-decoration: none; color: orangered;"><strong>Video
				Đã Xem </strong></a>
	</div>
	<c:forEach var="item" items="${historyVideo }">
		<div class="row p-2">
			<div
				class="col-4 d-flex align-items-center justify-content-center border-end">
				<a href="<c:url value='/video?action=watch&id=${item.href}' />">
					<img src="${item.poster }" alt="" class="img-fluid"
					style="width: auto; height: 100px;">
				</a>
			</div>
			<div class="col-8 d-flex align-items-center">
				<div class="text-center">${item.title }</div>
			</div>
		</div>
	</c:forEach>
</div>