<%@page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					<div class="navbar-header">
						<a class="navbar-brand"
							href="${pageContext.request.contextPath }/index.action"> 
						</a>
					</div> 
					<a class="navbar-brand"
						href="${pageContext.request.contextPath }/index.action">
						校园二手交易系统</a>
				</div>
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">
						<c:if test="${username==null}">
							<li><a class="btn" href="#modal-login" data-toggle="modal">
									登录 </a></li>
							<li><a class="btn" href="#modal-register"
								data-toggle="modal"> 注册 </a></li>
						</c:if>
						<c:if test="${username!=null}">
							<li><a
								href="${pageContext.request.contextPath }/user/user_car.action?id=${userid}">
									<span class="glyphicon glyphicon-shopping-cart"> </span> 购物车
							</a></li>
						</c:if>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">欢迎使用校园二手交易！ <span
								class="glyphicon glyphicon-user"> </span> ${username} <strong
								class="caret"> </strong>
						</a>
							<ul class="dropdown-menu">
								<c:if test="${username==null}">
									<li><a href="#modal-login" data-toggle="modal"> <span
											class="glyphicon glyphicon-user"> </span> 个人信息
									</a></li>
									<li class="divider"></li>
									<li><a href="#modal-login" data-toggle="modal"> <span
											class="glyphicon glyphicon-calendar"> </span> 我的收藏
									</a></li>
									<li class="divider"></li>
									<li><a href="#modal-login" data-toggle="modal"> <span
											class="glyphicon glyphicon-star"> </span> 我的订单
									</a></li>
								</c:if>
								<c:if test="${username!=null}">
									<li><a
										href="${pageContext.request.contextPath }/user/user_inf.action?id=${userid}">
											<span class="glyphicon glyphicon-user"> </span> 个人信息
									</a></li>
									<li class="divider"></li>
									<li><a
										href="${pageContext.request.contextPath }/user/select1_Collection.action?id=${userid}">
											<span class="glyphicon glyphicon-heart"> </span> 我的收藏
									</a></li>
									<li class="divider"></li>
									<li><a
										href="${pageContext.request.contextPath }/user/user_order.action?id=${userid}">
											<span class="glyphicon glyphicon-list-alt"> </span> 我的订单
									</a></li>
								</c:if>
								<c:if test="${username!=null}">
									<li class="divider"></li>
									<li><a
										href="${pageContext.request.contextPath }/userLogout.action">
											<span class="glyphicon glyphicon-log-in"> </span> 退出登录
									</a></li>
								</c:if>
							</ul></li>
					</ul>
				</div>
			</nav>
		</div>
	</div>
</div>
