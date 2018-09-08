<%@page pageEncoding="utf-8"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-default  navbar-inverse navbar-fixed-top">
				<div class="navbar-header">
					<a class="navbar-brand" href="#"> 我的知识库 </a>
				</div>
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li
							class="<%="user".equals(request.getParameter("fun")) ? "active"
					: ""%>"><a
							href="admin_user_list"> <span
								class="glyphicon glyphicon-credit-card"> </span> 管理用户信息
						</a></li>
						<li
							class="<%="admin_tag_list".equals(request.getParameter("fun")) ? "active"
					: ""%>"><a
							href="admin_tag_list"> <span
								class="glyphicon glyphicon-credit-card"> </span> 标签管理
						</a></li>
					
						<li
							class="<%="admin_cate_list".equals(request.getParameter("fun")) ? "active"
					: ""%>"><a
							href="admin_cate_list"> <span
								class="glyphicon glyphicon-credit-card"> </span> 分类管理
						</a></li>
				
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown"> <span
								class="glyphicon glyphicon-user"> </span>${account} <strong
								class="caret"> </strong>
						</a>
							<ul class="dropdown-menu">
								<li><a
									href="${pageContext.request.contextPath }/adminLogout">
										<span class="glyphicon glyphicon-log-in"> </span> 退出登录
								</a></li>
							</ul></li>
					</ul>
				</div>
			</nav>
		</div>
	</div>
</div>