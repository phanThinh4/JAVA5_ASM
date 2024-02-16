<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!doctype html>
<html lang="en">

<head>
<title>Change Password</title>
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
					<h4 class="card-title title-left">Change Password</h4>
					<p class="card-text">Thay Đổi Mật Khẩu</p>
				</div>
			</div>
			<div class="row mt-2">
				<div class="col-sm-6 offset-sm-3">
					<jsp:include page="/common/inform.jsp"></jsp:include>
				</div>
				<div class="col-sm-6 offset-sm-3">
					<div class="card">
						<div class="card-body">
							<form action="changePass" method="post" name="loginForm"
								class="row" novalidate>
								<div class="col-sm-6 mt-5">
									<div class="mb-3">
										<label for="username" class="form-label"><b>Mật
												Khẩu Cũ:</b></label> <input type="password" name="password"
											id="username" class="form-control"
											placeholder="Nhập Password" required>

									</div>
									<div class="mb-3">
										<label for="password" class="form-label"><b>Mật
												Khẩu Mới:</b></label> <input type="password" name="newPassword"
											id="password" class="form-control"
											placeholder="Nhập Password Mới" required>
									</div>
									<div class="mb-3">
										<label for="password" class="form-label"><b>Nhập
												Mật Khẩu:</b></label> <input type="password" name="confirmPassword"
											id="password" class="form-control"
											placeholder="Nhập Lại Password" required>
									</div>
								</div>
								<div class="col-sm-6">
									<img src="images/slide/formSignUp.jpg" alt=""
										style="max-width: 100%;">
								</div>
								<div class="card-footer d-flex justify-content-end">
									<button class="btn btn-primary me-2">Change
										Password</button>
									<button formaction="index" class="btn btn-danger">Close</button>
								</div>
							</form>
						</div>
					</div>
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