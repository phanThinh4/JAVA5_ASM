<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!doctype html>
<html lang="en">

<head>
<title>My Favorites</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<base href="/asm_java4/">

<!-- Bootstrap CSS v5.2.1 -->
<%@ include file="/common/head.jsp"%>

</head>

<body>
	<%@ include file="/common/nav.jsp"%>
	<hr class="myHr">
	<div class="container">
		<article class="col">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title title-left">
						My Favorites </b>
					</h4>
					<p class="card-text">Tong hop cac video yeu thich cua ban</p>
				</div>
			</div>
			<br>
			<div class="row">
				<c:forEach var="video" items="${videos }">
					<div class="col-sm-3 mt-3">
						<div class="card text-center">
							<div class="card-body myHover">
								<a href="<c:url value='/video?action=watch&id=${video.href}' />"><img
									src="${video.poster}" width="100%" alt=""
									class="img-fluid"></a>
							</div>
							<div class="card-footer">
								<div class="row bored-top mt-2 tm-tex-secondary"
									style="white-space: nowrap; overflow: hidden;">
									<b>${video.title }</b>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<br>

			<div class="row justify-content-center align-items-center g-2">
				<div class="col">
					<nav aria-label="Page navigation">
						<ul class="pagination justify-content-center   ">
							<li class="page-item disabled"><a class="page-link" href="#"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
							<li class="page-item active" aria-current="page"><a
								class="page-link" href="#">1</a></li>
							<li class="page-item"><a class="page-link" href="#">2</a></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</article>
	</div>
	<br>
	<br>
	<%@ include file="/common/footer.jsp"%>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous">
		
	</script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
		integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
		crossorigin="anonymous">
		
	</script>
</body>

</html>