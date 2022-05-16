<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="html 5 template">
<meta name="author" content="tonytemplates.com">
<link rel="icon" href="favicon.ico">
<title>火车票</title>
<link href="./css/plugins/bootstrap.min.css" rel="stylesheet">
<link href="./css/plugins/bootstrap-submenu.css" rel="stylesheet">
<link href="./css/plugins/animate.min.css" rel="stylesheet">
<link href="./css/plugins/nivo-slider.css" rel="stylesheet">
<link href="./css/plugins/slick.css" rel="stylesheet">
<link href="./css/plugins/magnific-popup.css" rel="stylesheet">
<link href="./css/custom.css" rel="stylesheet">
<link href="./iconfont/style.css" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,400,500,700,900"
	rel="stylesheet">
</head>
<body class="home">
<header class="page-header">
		<!-- Fixed navbar -->
		<div id="slidemenu" data-hover="dropdown" data-animations="fadeIn">
			<ul class="nav navbar-nav">
				<li class="active"><a href="index.jsp"><span class="electric-btn"><span class="text">首页</span></span></a></li>
				<li><a href="orderForm.jsp"><span class="electric-btn"><span class="text">订单</span></span></a></li>
				<li><a href="prices.jsp"><span class="electric-btn"><span class="text">火车票</span></span></a></li>
				<li><a href="login.jsp"><span class="electric-btn"><span class="text">登录</span></span></a></li>
				<li onclick="returnIndex()"><a href="login.jsp"><span class="electric-btn"><span class="text">注销</span></span></a></li>
			</ul>
		</div>
</header>
<div class="block">
	<div class="container">
		<h1 class="text-center">
			火车 <b>票</b>
		</h1>
		<p class="font24 text-center">输入车次时间查询所需车票并购买</p>
		<form id="queryform" class="contact-form" name="queryform"
			method="post" novalidate>
			<div id="success">
				<p>信息查询成功！</p>
			</div>
			<div id="error">
				<p>信息查询出错！请再次查询！</p>
			</div>
			<div class="inputs-col">
			<div class="row">
				<div class="col-md-6">
					<div class="input-wrapper">
						<label>始发地<span class="required"></span></label> <input
							type="text" class="input-custom input-full" id="source"
							placeholder="请输入你的出发地点">
					</div>
				</div>
				<div class="col-md-6">
					<div class="input-wrapper">
						<label>目的地</label> <input type="text"
							class="input-custom input-full" id="target"
							placeholder="请输入你的目的地">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="input-wrapper">
						<label>日期</label> <input type="date"
							class="input-custom input-full" id="date">
					</div>
				</div>
				</div>
				<button type="submit" id="submit" class="btn btn-border" onclick="searchTrips()">
					<span>查询</span>
				</button>
			</div>
		</form>
		<div class="table-wrapper">
			<table id="ticketTable" class="table price-table">
				<tbody>
					<tr class="table-header">
						<th>始发地</th>
						<th>出发时间</th>
						<th>目的地</th>
						<th>到达时间</th>
						<th>班次号</th>
						<th>价格</th>
						<th>数量</th>
						<th>操作</th>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<!-- //Block -->
</div>

<div class="block">
		<h1 class="text-center decor color">
			订单 <b>详细信息</b>
		</h1>
		<div class="divider"></div>
	</div>

<div class="block">
		<div class="container">
				<div class="col-sm-7 col-md-8">
					<form id="ticketform" class="contact-form" name="ticketform"
						method="post" novalidate>
						<div id="success">
							<p>您的信息更新成功！</p>
						</div>
						<div id="error">
							<p>信息更新出错！请再次提交！</p>
						</div>
						<div class="inputs-col" style="padding-left: 350px;">
							<div class="row">
								<div class="col-md-6">
									<div class="input-wrapper">
										<label>姓名 <span class="required"></span></label> <input
											type="text" class="input-custom input-full" id="trueName" name="trueName">
									</div>
								</div>
								<div class="col-md-6">
									<div class="input-wrapper">
										<label>电话</label> <input type="text"
											class="input-custom input-full" id="phone" name="phone">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="input-wrapper">
										<label>身份证号 <span class="required"></span></label> <input
											type="text" class="input-custom input-full" id="identity" name="identity">
									</div>
								</div>
								<div class="col-md-6">
									<div class="input-wrapper">
										<label>车次号</label> <input type="text"
											class="input-custom input-full" id="carNum" name="carNum">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="input-wrapper">
										<label>始发地 <span class="required"></span></label> <input
											type="text" class="input-custom input-full" id="orginLocation" name="orginLocation">
									</div>
								</div>
								<div class="col-md-6">
									<div class="input-wrapper">
										<label>目的地</label> <input type="text"
											class="input-custom input-full" id="destinationLocation" name="destinationLoction">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="input-wrapper">
										<label>出发时间 <span class="required"></span></label> <input
											type="text" class="input-custom input-full" id="startTime" name="startTime">
									</div>
								</div>
								<div class="col-md-6">
									<div class="input-wrapper">
										<label>到达时间</label> <input type="text"
											class="input-custom input-full" id="reachTime" name="reachTime">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="input-wrapper">
										<label>价格 <span class="required"></span></label> <input
											type="text" class="input-custom input-full" id="ticketPrice" name="ticketPrice">
									</div>
								</div>
							</div>
						</div>
						<button type="submit" id="submit" class="btn btn-border" style="margin-left: 500px;">
							<i class="icon icon-lightning"></i><span>付款</span>
						</button>
					</form>
				</div>
		</div>
	</div>
	<script src="./js/jquery.js"></script>
	<script src="./js/plugins/bootstrap.min.js"></script>
	<script src="./js/plugins/slick.min.js"></script>
	<script src="./js/plugins/jquery.form.js"></script>
	<script src="./js/plugins/jquery.validate.min.js"></script>
	<script src="./js/custom.js"></script>
	<script language="JavaScript">
	fillerIn();
	</script>
</body>
</html>