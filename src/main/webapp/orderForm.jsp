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
<title>订单</title>
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
					订单 <b id="orderfirst">信息</b>
				</h1>
				<p class="font24 text-center">点击订单的查看订单进行退票或者改签操作</p>
				<div class="table-wrapper">
					<table id="orderTable" class="table price-table" id="orderTable">
						<tbody>
							<tr class="table-header">
								<th>乘车人</th>
								<th>始发地</th>
								<th>出发时间</th>
								<th>目的地</th>
								<th>到达时间</th>
								<th>班次号</th>
								<th>价格</th>
								<th>订单状态</th>
								<th>操作</th>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- //Block -->
	</div>
	<!-- // Content  -->
	
		<div class="block">
				<h1 class="text-center decor color">
					订单 <b id="dingdan">详细信息</b>
				</h1>
				<div class="divider"></div>
		</div>
		
		<div class="block">
			<div class="container">
					<div class="col-sm-7 col-md-8">
						<form  class="contact-form"
							>
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
												type="text" class="input-custom input-full" id="trueName" name="trueName" readonly="true">
										</div>
									</div>
									<div class="col-md-6">
										<div class="input-wrapper">
											<label>电话</label> <input type="text"
												class="input-custom input-full" id="phone" name="phone" readonly="true">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="input-wrapper">
											<label>身份证号 <span class="required"></span></label> <input
												type="text" class="input-custom input-full" id="identity" name="identity" readonly="true">
										</div>
									</div>
									<div class="col-md-6">
										<div class="input-wrapper">
											<label>车次号</label> <input type="text"
												class="input-custom input-full" id="carNum" name="carNum" readonly="true">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="input-wrapper">
											<label>始发地 <span class="required"></span></label> <input
												type="text" class="input-custom input-full" id="orginLocation" name="orginLocation" readonly="true">
										</div>
									</div>
									<div class="col-md-6">
										<div class="input-wrapper">
											<label>目的地</label> <input type="text"
												class="input-custom input-full" id="destinationLocation" name="destinationLocation" readonly="true">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="input-wrapper">
											<label>出发时间 <span class="required"></span></label> <input
												type="text" class="input-custom input-full" id="startTime" name="startTime" readonly="true">
										</div>
									</div>
									<div class="col-md-6">
										<div class="input-wrapper">
											<label>到达时间</label> <input type="text"
												class="input-custom input-full" id="reachTime" name="reachTime" readonly="true">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="input-wrapper">
											<label>价格<span class="required"></span></label> <input
												type="text" class="input-custom input-full" id="ticketPrice" name="ticketPrice" readonly="true">
										</div>
									</div>
									<div class="col-md-6">
										<div class="input-wrapper">
											<label>订单状态<span class="required"></span></label> <input
												type="text" class="input-custom input-full" id="ticketstatus" name="ticketstatus" readonly="true">
										</div>
									</div>
								</div>
							</div>
							<button id="pay_btn"  class="btn btn-border" onclick="refund1()" style="margin-left: 500px;">
								<i class="icon icon-lightning"></i><span id="pay_re_btn">退票</span>
							</button>
							<!--<button type="submit" id="change" class="btn btn-border" onclick="change()">-->
								<!--<i class="icon icon-lightning"></i><span>改签</span>-->
							<!--</button>-->
						</form>
					</div>
			</div>
		</div>
		
		<div class="block">
			<h1 class="text-center decor color">
				改签 <b>可供选择的车次</b>
			</h1>
			<div class="divider"></div>
		</div>
		<!-- //Block -->
		<!-- Block -->
		<div class="block">
			<div class="container">
				<div class="table-wrapper">
					<table class="table price-table" id="changeTable">
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
	<script src="./js/jquery.js"></script>
	<script src="./js/plugins/bootstrap.min.js"></script>
	<script src="./js/plugins/slick.min.js"></script>
	<script src="./js/plugins/jquery.form.js"></script>
	<script src="./js/plugins/jquery.validate.min.js"></script>
	<script src="./js/custom.js"></script>
	<script language="JavaScript">
        fillerIn();
        var base_url = "http://localhost:8080/Ticket";
		var json = [];
        var storage = window.localStorage;
        var username = storage["username"];
        // ajax传递数据
        var json = {
            "username" : username
        } 
        // 这里的orderId是指订单id,tripsId是指新车票的id
        var orderId = 0;
        // ajax提交数据
        $.ajax({
            type : 'POST',
            url : base_url +'/OrderServlet?action=getorder',
            data : json,
            dataType : 'json',
            success : function(data) {
                if (data.stateCode === 200) {
                    // 订单信息查询成功
                    console.log("11")
                    console.log(data.data)
                    console.log("查询订单信息成功，呈现到订单信息的页面当中");
                    //暂时的解决掉数据的参数传递问题
                    window.localStorage.setItem("orderItem",JSON.stringify(data.data));
                    json = JSON.stringify(data.data)
                    // $("#orderTable").html("");
                    $("#orderTable").siblings(
						'tr'
					).remove()



                    for (var i= 0;i<data.data.length; i++) {
                        var tr;
                        tr = '<td style="display:none;">'+data.data[i].id+'</td>'
                        	+'<td>' + data.data[i].trueName + '</td>' + '<td>'
                            + data.data[i].orginLocation + '</td>' + '<td>'
                            + data.data[i].startTime + '</td>' + '<td>'
                            + data.data[i].destinationLocation + '</td>'
                            + '<td>' + data.data[i].reachTime + '</td>'
                            + '<td>' + data.data[i].carNum + '</td>' + '<td>'
                            + data.data[i].ticketPrice + '</td>' + '<td>'
                            + data.data[i].status + '</td>' + '<td>'
                            + '<button onclick="orderDetail(' + i +')'+'">查看</button>'
                            + '</td>';
                        $("#orderTable").append('<tr>' + tr + '</tr>');
                    }
                } else
                // 查询失败,错误信息在data.msg里面（未填写个人信息，请完善个人信息）
                    alert("错误信息：" + data.msg)

            }
        });

        function refund1() {
            console.log("实现用户退票的操作");
            //获取身份证号，车次号，出发时间，始发地
            // var idCardNum = $("#identity").val();
            // var carNum = $("#carNum").val();
            var carNum = $("#carNum").val();
            var startTime = $("#startTime").val();
            var reachTime = $("#reachTime").val();
            var json = {
                "username" : window.localStorage.getItem("username"),
                "carNum" : carNum,
                "startTime" : startTime,
                "reachTime" : reachTime
            }
            var date = new Date();
            var localmonth = date.getMonth()+1;
            var localday = date.getDate();
            var localhour = date.getHours(); 
            var startdate = new Date(startTime);
            var month = startdate.getMonth()+1;
            var day = startdate.getDate();
            var hour = startdate.getHours();
            if(month-localmonth==0 && day-localday==0 && hour-localhour<24){
            	alert("退票需扣除50%手续费!");
            }else if(month-localmonth==0 && day-localday==1){
            	alert("退票需扣除30%手续费!");
            }else if(month-localmonth==0 && day-localday>1 && day-localday<3){
            	alert("退票需扣除10%手续费!");
            }else{
            	alert("请在出发前三天进行退票!");
            	return false;
            }
            // ajax提交数据
            $.ajax({
                type:'POST',
                url: base_url +'/TripsServlet?action=ticketrefund',
                data:json,
                dataType:'json',
                success : function(data) {
                    if (data.stateCode == "200") {
                        // 个人信息查询成功
                        console.log("退票成功，呈现到个人信息的页面当中");
                        window.location.href = 'orderForm.jsp';
                    } else
                    // 查询失败,错误信息在data.msg里面（未填写个人信息，请完善个人信息）
                        alert("错误信息：" + data.msg)
                }
            })
        }
        function orderDetail(i) {
            // 在当前界面当中填充好详细信息然后再实现改签等的操作
            document.getElementById("dingdan").scrollIntoView();
             $("#trueName").val('');
             $("#phone").val('');
             $("#identity").val('');
             $("#carNum").val('');
             $("#orginLocation").val('');
             $("#destinationLocation").val('');
             $("#startTime").val('');
             $("#reachTime").val('');
             $("#ticketPrice").val('');
             var data = JSON.parse(json);
             console.log(data)
			 console.log(i)
             data = data[i];
             console.log("用户点击某个订单呈现出详细信息");
             $("#trueName").val(data.trueName);
             $("#phone").val(data.phoneNum);
             $("#identity").val(data.idCardNum);
             $("#carNum").val(data.carNum);
             $("#orginLocation").val(data.orginLocation);
             $("#destinationLocation").val(data.destinationLocation);
             $("#startTime").val(data.startTime);
             $("#reachTime").val(data.reachTime);
             $("#ticketPrice").val(data.ticketPrice);
             $("#ticketstatus").val(data.status)
             if(data.status=="未支付"){
            	 $("#pay_re_btn").text("支付");
            	 $("#pay_btn").removeAttr("onclick");
            	 $("#pay_btn").attr("onclick","paymoney("+i+")")
             }
             orderId = data.orderid;
             var jsons={
            	 "id":data.id,
            	 "orginLocation":data.orginLocation,
            	 "destinationLocation":data.destinationLocation
             }
             $.ajax({
                 type : 'POST',
                 url : base_url +'/TripsServlet?action=getOtherTrips',
                 data : jsons,
                 dataType : 'json',
                 success : function(data) {
                     if (data.stateCode === 200) {
                         // 订单信息查询成功
                         console.log("11")
                         console.log(data.data)
                         console.log("查询订单信息成功，呈现到订单信息的页面当中");
                         //暂时的解决掉数据的参数传递问题
                         window.localStorage.setItem("otherItem",JSON.stringify(data.data));
                         json = JSON.stringify(data.data)
                         // $("#orderTable").html("");
                         $("#changeTable").siblings(
     						'tr'
     					).remove()



                         for (var i= 0;i<data.data.length; i++) {
                             var tr;
                             tr = '<td>'
                                 + data.data[i].orginLocation + '</td>' + '<td>'
                                 + data.data[i].startTime + '</td>' + '<td>'
                                 + data.data[i].destinationLocation + '</td>'
                                 + '<td>' + data.data[i].reachTime + '</td>'
                                 + '<td>' + data.data[i].carNum + '</td>' + '<td>'
                                 + data.data[i].ticketPrice + '</td>' + '<td>'
                                 + data.data[i].ticketNum + '</td>' + '<td>'
                                 + '<button onclick="changeorder(' + i + ')'+'">改签</button>'
                                 + '</td>';
                             $("#changeTable").append('<tr>' + tr + '</tr>');
                         }
                     } else
                     // 查询失败,错误信息在data.msg里面（未填写个人信息，请完善个人信息）
                         alert("错误信息：" + data.msg)

                 }
             });
        }
        function changeorder(i){
        	var storage = window.localStorage;
        	json = storage["otherItem"];
        	var data = JSON.parse(json);
        	var json = {
        			"orderId":orderId,
        			"tripsId":data[i].id
        	}
        	var date = new Date();
            var localmonth = date.getMonth()+1;
            var localday = date.getDate();
            var localhour = date.getHours(); 
            var startdate = new Date(startTime);
            var month = startdate.getMonth()+1;
            var day = startdate.getDate();
            var hour = startdate.getHours();
            if(month-localmonth==0 && day-localday==0 && hour-localhour<24){
            	alert("改签需扣除25%手续费!并补差价!");
            }else if(month-localmonth==0 && day-localday==1){
            	alert("退票需扣除15%手续费!并补差价!");
            }else if(month-localmonth==0 && day-localday>1 && day-localday<3){
            	alert("退票需扣除5%手续费!并补差价!");
            }else{
            	alert("请在出发前三天进行退票!");
            	return false;
            }
        	$.ajax({
                type : 'POST',
                url : base_url +'/OrderServlet?action=changeorder',
                data : json,
                dataType : 'json',
                success : function(data) {
                    if (data.stateCode === 200) {
                    	console.log("改签")
                        console.log(data.msg)
                        alert(data.msg);
                    	window.location.reload();
                    	document.getElementById("orderfirst").scrollIntoView();
                    }else{
                    	alert("错误信息：" + data.msg)
                    }
                }
        	});
        }
	</script>
</body>
</html>