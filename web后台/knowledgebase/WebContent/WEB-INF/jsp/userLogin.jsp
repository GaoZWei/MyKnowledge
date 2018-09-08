<%@page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%
	request.setCharacterEncoding("GBK");
%>

<jsp:include page="head.jsp">
	<jsp:param value="用户登录" name="title" />
</jsp:include>

</head>

<body>

	<br />
	<br />
	<br />
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">商户信息</h3>
					</div>
					<form class="form-horizontal" method="post"
						<%-- action="${pageContext.request.contextPath }/userLogin" --%>>
						<div class="modal-body">
							<div class="form-group">
								<label class="col-sm-4 control-label" for="account">
									用户名 </label>
								<div class="col-sm-6">
									<input class="form-control" id="account" name="account"
										type="text" required />
								</div>
							</div>
							<div class="form-group">

								<label class="col-sm-4 control-label" for="password"> 密码 </label>
								<div class="col-sm-6">
									<input class="form-control" id="password" name="password"
										type="password" required />
								</div>
							</div>
						</div>
						<center>
							<button type="submit" class="btn btn-primary">登录</button>
							
						</center>
					</form>
				</div>

			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
	</div>
</body>

</html>