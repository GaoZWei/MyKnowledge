<%@page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%
	request.setCharacterEncoding("GBK");
%>
<jsp:include page="../head.jsp">
	<jsp:param value="修改标签" name="title" />
</jsp:include>
</head>

<body>
	<jsp:include page="admin_nav.jsp">
		<jsp:param value="admin_tag_list" name="fun" />
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
						<h3 class="panel-title">类型信息</h3>
					</div>
					<form method="post"
						action="${pageContext.request.contextPath }/admin/admin_tag_editSubmit">
						<input type="hidden" name="id" value="${tag.id}" />
						<center>
							<div class="panel-body">
								<div class="input-group">
									<span class="input-group-addon" style="width: 100px"> <span
										class="glyphicon glyphicon-user"> </span> 分类名:
									</span> <input type="text" class="form-control" name="tagname"
										placeholder="请输入类型名" autofocus required="required"
										style="width: 280px" value="${tag.tagname}">
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