<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%
	request.setCharacterEncoding("GBK");
%>
<jsp:include page="../head.jsp">
	<jsp:param value="用户信息" name="title" />
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
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="panel panel-success">
					<div class="panel-heading">
						<form class="form-inline" role="search" method="post"
							action="find_user">
							<div class="input-group">
								<div class="form-group">
									<input type="text" placeholder="请输入要查找的用户名" name="username" class="form-control" />
								</div>
								<button type="submit" class="btn btn-default">查找</button>
							</div>
							<div class="form-group pull-right">

								<a class="btn btn-sm btn-success" data-toggle="tooltip"
									title="添加用户"
									href="${pageContext.request.contextPath }/admin/admin_user_add"
									role="button"><span class="glyphicon glyphicon-plus-sign"
									aria-hidden="true"></span>&nbsp;添加用户</a>
							</div>
						</form>
					</div>
					<div class="panel-body">
						<table class="table table-hover">
							<tr align="center">
								<td><strong> 序号 </strong></td>
								<td><strong> 用户ID </strong></td>
								<td><strong> 账号 </strong></td>
								<td><strong> 用户名 </strong></td>
								<td><strong> 年龄 </strong></td>
								<td><strong> 手机号码 </strong></td>
								<td><strong> 状态 </strong></td>
								<td><strong> 操作 </strong></td>
							</tr>
							<c:if test="${userList ne null}">
								<c:forEach items="${userList}" var="user" varStatus="vs">
									<tr align="center">
										<td>${vs.count }</td>
										<td>${user.id }</td>
										<td>${user.account }</td>
										<td>${user.username }</td>
										<td>${user.age }</td>
										<td>${user.telephone }</td>
										<c:if test="${user.ident==1 }">
											<td>正常</td>
										</c:if>
										<c:if test="${user.ident!=1 }">
											<td>禁用</td>
										</c:if>
										<td><c:if test="${user.ident==1}">
												<button type="button" class="btn btn-xs btn-success"
													data-toggle="tooltip" title="封禁用户"
													onclick="isdelConfirm(${user.id})">
													<span class="glyphicon glyphicon-ok-circle"
														aria-hidden="true"></span>
												</button>
											</c:if> <c:if test="${user.ident==0}">
												<button type="button" class="btn btn-xs btn-danger"
													data-toggle="tooltip" title="解禁用户"
													onclick="nodelConfirm(${user.id})">
													<span class="glyphicon glyphicon-ban-circle"
														aria-hidden="true"></span>
												</button>
											</c:if>
											<button type="button" class="btn btn-xs btn-warning"
												data-toggle="tooltip" title="删除用户"
												onclick="delConfirm(${user.id})">
												<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
											</button> <a
											href="${pageContext.request.contextPath}/admin/admin_user_edit?id=${user.id}"><button
													type="button" class="btn btn-xs btn-info"
													data-toggle="modal" data-target="#delConfirmModal"
													data-toggle="tooltip" title="修改用户">
													<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
												</button></a></td>
									</tr>

								</c:forEach>
							</c:if>
						</table>

					</div>
				</div>
			</div>

			<div class="col-md-1"></div>
			<div class="col-md-12">
			</div>
			<!--封禁确认框-->
			<div class="modal fade" id="isdelConfirmModal">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">封禁确认</h4>
						</div>
						<div class="modal-body">
							<h4 class="text-danger">确定要封禁该用户吗？</h4>
						</div>
						<div class="modal-footer">
							<input type="hidden" id="url" />
							<button type="button" class="btn btn-default"
								data-dismiss="modal">放弃</button>
							<button type="button" class="btn btn-primary"
								data-dismiss="modal" onclick="isdelSubmit()">封禁</button>
						</div>
					</div>
				</div>
			</div>
			<!--解禁确认框-->
			<div class="modal fade" id="nodelConfirmModal">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">解禁确认</h4>
						</div>
						<div class="modal-body">
							<h4 class="text-danger">确定要解禁该用户吗？</h4>
						</div>
						<div class="modal-footer">
							<input type="hidden" id="url" />
							<button type="button" class="btn btn-default"
								data-dismiss="modal">放弃</button>
							<button type="button" class="btn btn-primary"
								data-dismiss="modal" onclick="nodelSubmit()">解禁</button>
						</div>
					</div>
				</div>
			</div>
			<!--删除确认框-->
			<div class="modal fade" id="delConfirmModal">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">删除确认</h4>
						</div>
						<div class="modal-body">
							<h4 class="text-danger">确定要删除该用户吗？</h4>
						</div>
						<div class="modal-footer">
							<input type="hidden" id="url" />
							<button type="button" class="btn btn-default"
								data-dismiss="modal">放弃</button>
							<button type="button" class="btn btn-primary"
								data-dismiss="modal" onclick="delSubmit()">删除</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
					function delConfirm(id) {
						$('#url').val('${pageContext.request.contextPath}/admin/admin_user_del?id=' + id);
						$('#delConfirmModal').modal();
					}
					function delSubmit() {
						location.replace($('#url').val());
					}
					function isdelConfirm(id) {
						$('#url').val('${pageContext.request.contextPath}/admin/admin_user_isdel?id=' + id);
						$('#isdelConfirmModal').modal();
					}
					function isdelSubmit() {
						location.replace($('#url').val());
					}function nodelConfirm(id) {
						$('#url').val('${pageContext.request.contextPath}/admin/admin_user_nodel?id=' + id);
						$('#nodelConfirmModal').modal();
					}
					function nodelSubmit() {
						location.replace($('#url').val());
					}
				</script>
</body>

</html>




