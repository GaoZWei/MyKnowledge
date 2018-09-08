<%@page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%
	request.setCharacterEncoding("GBK");
%>
<jsp:include page="../head.jsp">
	<jsp:param value="修改用户" name="title" />
</jsp:include>
</head>

<body>
	<jsp:include page="admin_nav.jsp">
		<jsp:param value="user" name="fun" />
	</jsp:include>
	<br />
	<br />
	<br />
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">用户信息</h3>
					</div>
					<form method="post"
						action="${pageContext.request.contextPath }/admin/admin_user_editSubmit">
						<input type="hidden" name="id" value="${userCustom.id}" />
						<center>
							<div class="panel-body">
								<div class="input-group">
									<span class="input-group-addon" style="width: 100px"> <span
										class="glyphicon glyphicon-user"> </span> 账号:
									</span> <input type="text" class="form-control" name="account"
										placeholder="账号设置成功后不可修改" autofocus required="required"
										style="width: 280px" value="${userCustom.account}">
								</div>
							</div>
							<div class="panel-body">
								<div class="input-group">
									<span class="input-group-addon" style="width: 100px"> <span
										class="glyphicon glyphicon-lock"> </span> 登录密码:
									</span> <input type="password" class="form-control" name="password"
										placeholder="6-20位字母，数字或符号" required="required"
										style="width: 280px" value="${userCustom.password}">
								</div>
							</div>
							<div class="panel-body">
								<div class="input-group">
									<span class="input-group-addon" style="width: 100px"> <span
										class="glyphicon glyphicon-send"> </span> 用户名:
									</span> <input type="text" class="form-control" name="username"
										placeholder="请正确填写用户名" required="required" style="width: 280px"
										value="${userCustom.username}">
								</div>
							</div>
							
							<div class="panel-body">
								<div class="input-group">
									<span class="input-group-addon" style="width: 100px"> <span
										class="glyphicon glyphicon-send"> </span> 年龄:
									</span> <input type="text" class="form-control" name="age"
										placeholder="请正确填写年龄" required="required" style="width: 280px"
										value="${userCustom.age}">
								</div>
							</div>
							
							<div class="panel-body">
								<div class="input-group">
									<span class="input-group-addon" style="width: 100px"> <span
										class="glyphicon glyphicon-phone-alt"> </span> 手机号码:
									</span> <input type="tel" class="form-control" name="telephone"
										placeholder="请输入您的手机号码" value="${userCustom.telephone}"
										style="width: 280px">
								</div>
							</div>
						</center>
						<center>
							<button type="submit" class="btn btn-warning btn-default"
								style="width: 380px">
								<span class="glyphicon glyphicon-ok"> </span> 确认修改
							</button>
						</center>

					</form>
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>
	</div>
</body>

</html>