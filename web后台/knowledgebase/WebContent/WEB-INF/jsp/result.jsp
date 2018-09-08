<%@page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GBK">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>结果页面</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/res/js/bootstrap3.3.5/css/bootstrap.min.css">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script
	src="${pageContext.request.contextPath}/res/js/jquery1.11.3/jquery-1.11.3.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script
	src="${pageContext.request.contextPath}/res/js/bootstrap3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<!--结果对话框-->
	<div class="modal fade" id="resultModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">提示信息</h4>
				</div>
				<div class="modal-body">
					<h4 class="text-danger">${msg }</h4>
				</div>
				<div class="modal-footer">
					<input type="hidden" id="url" />
					<button type="button" class="btn btn-primary" data-dismiss="modal"
						onclick="ok('${pageContext.request.contextPath}${href }')">确定</button>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('#resultModal').modal();
		function ok(href) {
			location.replace(href);
		}
	</script>
</body>
</html>