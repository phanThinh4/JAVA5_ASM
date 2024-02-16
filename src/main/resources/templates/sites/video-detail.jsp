<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!doctype html>
<html lang="en">

<head>
<title>${video.title }</title>
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
		<div class="row">
			<article class="${not empty sessionScope.currentUser?'col-sm-8':'col' }">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title title-left">${video.title }</h4>
					</div>
				</div>
				<div class="mt-3 ${not empty sessionScope.currentUser?'':'col-sm-8 offset-sm-2' }">
					<div class="card">
						<div class="card-body">
							<div class="row">
								<iframe style="width: 850px; height: 420px;"
									src="https://www.youtube.com/embed/${video.href }"></iframe>
							</div>
						</div>
						<c:if test="${not empty sessionScope.currentUser }">
							<div class="card-footer d-flex justify-content-end">
								<button id="likeOrUnLike" class="btn btn-primary me-2">
									<c:choose>
										<c:when test="${flag == true }">UnLike</c:when>
										<c:otherwise>Like</c:otherwise>
									</c:choose>
								</button>
								<a href="#!share" class="btn btn-secondary"> <i
									class="bi bi-box-arrow-up"></i> Share
								</a>
							</div>
						</c:if>
					</div>
					<input type="hidden" id="videoIdHdn" value="${video.href }" />
				</div>
			</article>
			<c:if test="${not empty sessionScope.currentUser}">
				<aside class="col-sm-4">
					<%@include file="/sites/common/history.jsp"%>
				</aside>
			</c:if>

		</div>
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
	<script>
		$(document).ready(function() {
			$('#likeOrUnLike').click(function() {
				var videoId = $('#videoIdHdn').val();
				console.log('Video ID:', videoId);
				$.ajax({
					url : 'video?action=Like&id=' + videoId
				}).then(function(data) {
					var text = $('#likeOrUnLike').text().trim();
					console.log('Button Text:', text);
					if (text.toLowerCase() === 'like') { // Chuyển về chữ thường và so sánh
						$('#likeOrUnLike').text('Unlike');
					} else if (text.toLowerCase() === 'unlike') {
						$('#likeOrUnLike').text('Like');
					}
				}).fail(function(error) {
					console.error('AJAX Error:', error);
					alert('Oops!!');
				});
			});
		});
	</script>
</body>

</html>