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
<title>火车票购票系统</title>
<link rel="stylesheet" href="./css/default.css" />
<link rel="stylesheet" href="./css/index.css" />
<link href="./css/plugins/bootstrap.min.css" rel="stylesheet">
<link href="./css/plugins/bootstrap-submenu.css" rel="stylesheet">
<link href="./css/plugins/animate.min.css" rel="stylesheet">
<link href="./css/plugins/nivo-slider.css" rel="stylesheet">
<link href="./css/plugins/slick.css" rel="stylesheet">
<link href="./css/plugins/magnific-popup.css" rel="stylesheet">
<link href="./css/custom.css" rel="stylesheet">
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<link href="./iconfont/style.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,400,500,700,900" rel="stylesheet">
</head>
<body class="home">
	<!-- //Loader -->
	<!-- Header -->
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
	<!-- // Header -->
	<!-- Content  -->
	<div class="slideBox">
	<div class="hd">
		<ul><li></li><li></li><li></li></ul>
	</div>
	<div class="bd">
		<ul>
			<li><a href="#"><img src="./image/banner.jpg" /></a></li>
		</ul>
	</div>
</div>
<!--页面主体部分-->
<!--关于饭心-->
<div class="mainBox">
	<div class="main w1200">
		<div class="mainTitle">
			<h2>ABOUT  US</h2>
			<h3>关于我们</h3>
			<em></em>
		</div>
		<!--图片轮播-->
		<div class="Picshuff">
			<h2>广告</h2>
			<p>还是广告</p>
			<div class="picScroll-left">
				<div class="hd">
					<a class="next"></a>
					<a class="prev"></a>
				</div>
				<div class="bd">
					<ul class="picList cleafix">
						<li>
							<a href="#">
								<i class="ico"></i>
								<p>全套定制</p>
							</a>
						</li>
						<li>
							<a href="#">
								<i class="ico1"></i>
								<p>腰封定制</p>
							</a>
						</li>
						<li>
							<a href="#">
								<i class="ico2"></i>
								<p>礼品册</p>
							</a>
						</li>
					</ul>
				</div>
			</div>
			<h3 class="More"><a href="#">了解更多</a></h3>
		</div>
	</div>
</div>
<!--产品展示-->
<div class="mainBox mainBox1">
	<div class="main w1200">
		<div class="mainTitle">
			<h2>PRODUCT  DISPIAY</h2>
			<h3>产品展示</h3>
			<em></em>
		</div>
		<div class="show_bot show_bot1">
			<ul class="cleafix">
				<li>
					<a href="#">
						<i><img src="./image/pic1.jpg"></i>
						<p>意大利DONNACHIC公司<em></em></p>
					</a>
				</li>
				<li>
					<a href="#">
						<i><img src="./image/pic2.jpg"></i>
						<p>千枣红酒品礼品包装定制<em></em></p>
					</a>
				</li>
				<li>
					<a href="#">
						<i><img src="./image/pic3.jpg"></i>
						<p>中鹤集团外婆面馆礼品定制<em></em></p>
					</a>
				</li>
			</ul>
			<h3 class="More"><a href="#">了解更多</a></h3>
		</div>
	</div>
</div>
	<!-- //Footer -->

	<script src="./js/jquery.js"></script>
	<script src="./js/plugins/bootstrap.min.js"></script>
	<script src="./js/plugins/jquery.nivo.slider.js"></script>
	<script src="./js/plugins/slick.min.js"></script>
	<script src="./js/plugins/jquery.magnific-popup.min.js"></script>
	<script src="./js/plugins/imagesloaded.pkgd.min.js"></script>
	<script src="./js/plugins/isotope.pkgd.min.js"></script>
	<script src="./js/custom.js"></script>
	<script language="JavaScript">
        //fillerIn();
		function returnIndex() {
			localStorage.clear();
	    }
	</script>
	<script type="text/javascript" src="./js/index.js" ></script>
</body>
</html>