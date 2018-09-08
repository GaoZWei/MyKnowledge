<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%
	request.setCharacterEncoding("GBK");
%>
<jsp:include page="../head.jsp">
	<jsp:param value="知识类别信息" name="title" />
</jsp:include>
</head>

<body>
	<jsp:include page="admin_nav.jsp">
		<jsp:param value="admin_cate_list" name="fun" />
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
							action="admin_cate_list">
							<div class="input-group">
								<div class="form-group">
									
								</div>
								
							</div>
							<div class="form-group pull-right">

								<a class="btn btn-sm btn-success" data-toggle="tooltip"
									title="添加分类"
									href="${pageContext.request.contextPath }/admin/admin_cate_add"
									role="button"><span class="glyphicon glyphicon-plus-sign"
									aria-hidden="true"></span>&nbsp;添加分类</a>
							</div>
						</form>
					</div>
					<div class="panel-body">
						<table class="table table-hover">
							<tr align="center">
								<td><strong> 序号 </strong></td>
								<td><strong> 类型ID </strong></td>
								<td><strong> 分类名 </strong></td>
								<td><strong> 操作 </strong></td>
							</tr>
							<c:if test="${findCateList ne null}">
								<c:forEach items="${findCateList}" var="cate"
									varStatus="vs">
									<tr align="center">
										<td>${vs.count }</td>
										<td>${cate.id }</td>
										<td>${cate.catename }</td>
										<td><a
											href="${pageContext.request.contextPath}/admin/admin_cate_edit?id=${cate.id}"><button
													type="button" class="btn btn-xs btn-info"
													data-toggle="modal" data-target="#delConfirmModal"
													data-toggle="tooltip" title="修改分类">
													<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
												</button></a>
												<button type="button" class="btn btn-xs btn-warning"
												data-toggle="tooltip" title="删除分类"
												onclick="delConfirm(${cate.id})">
												<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
											</button></td>
									</tr>

								</c:forEach>
							</c:if>
						</table>

					</div>
				</div>
			</div>
			
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
		<script>
					function delConfirm(id) {
						$('#url').val('${pageContext.request.contextPath}/admin/admin_cate_del?id=' + id);
						$('#delConfirmModal').modal();
					}
					function delSubmit() {
						location.replace($('#url').val());
					}
				</script>
</div>

			<div class="col-md-1"></div>
			<div class="col-md-12">
				<center>
					<ul class="pagination pagination-lg">
						<li><a href="#"> 首页 </a></li>
						<li><a href="#"> 1 </a></li>
						<li><a href="#"> 2 </a></li>
						<li><a href="#"> 3 </a></li>
						<li><a href="#"> 4 </a></li>
						<li><a href="#"> ... </a></li>
						<li><a href="#"> 15 </a></li>
						<li><a href="#"> 16 </a></li>
						<li><a href="#"> 末页 </a></li>
					</ul>
				</center>

			</div>
</body>

</html>




