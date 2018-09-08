<%@page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%
	request.setCharacterEncoding("GBK");
%>
<jsp:include page="../head.jsp">
	<jsp:param value="banner管理" name="title" />
</jsp:include>
</head>

<body>
	<jsp:include page="admin_nav.jsp">
		<jsp:param value="banner" name="fun" />
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
						<h3 class="panel-title">banner信息</h3>
					</div>
					<form method="post"
						action="${pageContext.request.contextPath }/admin/admin_banner_editSubmit.action">
						<input type="hidden" name="id" value="${bannerCustom.id}" />
						<center>
							<div class="panel-body">
								<div class="input-group">
									<span class="input-group-addon" style="width: 100px"> <span
										class="glyphicon glyphicon-menu-hamburger"> </span> 图片1:
									</span> <input type="text" class="form-control" name="bannerimg1"
										placeholder="请设置名称" required="required" style="width: 280px"
										value="${bannerCustom.bannerimg1}">
								</div>
							</div>
							<div class="panel-body">
								<div class="input-group">
									<span class="input-group-addon" style="width: 100px"> <span
										class="glyphicon glyphicon-plane"> </span> 图片1链接:
									</span> <input type="text" class="form-control" name="bannerhref1"
										placeholder="请正确填写链接" style="width: 280px"
										value="${bannerCustom.bannerhref1}">
								</div>
							</div>
							<div class="panel-body">
								<div class="input-group">
									<span class="input-group-addon" style="width: 100px"> <span
										class="glyphicon glyphicon-menu-hamburger"> </span> 图片2:
									</span> <input type="text" class="form-control" name="bannerimg2"
										placeholder="请设置名称" required="required" style="width: 280px"
										value="${bannerCustom.bannerimg2}">
								</div>
							</div>
							<div class="panel-body">
								<div class="input-group">
									<span class="input-group-addon" style="width: 100px"> <span
										class="glyphicon glyphicon-plane"> </span> 图片2链接:
									</span> <input type="text" class="form-control" name="bannerhref2"
										placeholder="请正确填写链接" style="width: 280px"
										value="${bannerCustom.bannerhref2}">
								</div>
							</div>
							<div class="panel-body">
								<div class="input-group">
									<span class="input-group-addon" style="width: 100px"> <span
										class="glyphicon glyphicon-menu-hamburger"> </span> 图片3:
									</span> <input type="text" class="form-control" name="bannerimg3"
										placeholder="请设置名称" required="required" style="width: 280px"
										value="${bannerCustom.bannerimg3}">
								</div>
							</div>
							<div class="panel-body">
								<div class="input-group">
									<span class="input-group-addon" style="width: 100px"> <span
										class="glyphicon glyphicon-plane"> </span> 图片3链接:
									</span> <input type="text" class="form-control" name="bannerhref3"
										placeholder="请正确填写链接" style="width: 280px"
										value="${bannerCustom.bannerhref3}">
								</div>
							</div>


						</center>

						<center>
							<button type="submit" class="btn btn-warning btn-default"
								style="width: 380px">
								<span class="glyphicon glyphicon-ok"> </span> 确认修改
							</button>
						</center>
						<br />
					</form>
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>
	</div>
</body>

</html>