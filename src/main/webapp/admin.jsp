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
<meta charset="UTF-8">
<title>后台管理</title>
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
<body>
<div class="block">
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
<div class="block">
	<div class="table-wrapper">
		<table id="sealTable" class="table price-table">
			<tbody>
				<tr class="table-header">
					<th>班次号</th>
					<th>售卖数</th>
					<th>退票数</th>
					<th>改签数</th>
					<th>销售额</th>
				</tr>
			</tbody>
		</table>
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
$.ajax({
    type : 'POST',
    url : base_url +'/TripsServlet?action=getalltrips',
    dataType : 'json',
    success : function(data) {
        if (data.stateCode === 200) {
            // 订单信息查询成功
            console.log("11");
            console.log(data.data);
            console.log("查询订单信息成功，呈现到订单信息的页面当中");
            //暂时的解决掉数据的参数传递问题
            window.localStorage.setItem("allItem",JSON.stringify(data.data));
            json = JSON.stringify(data.data)
            // $("#orderTable").html("");
            $("#ticketTable").siblings(
				'tr'
			).remove()
            for (var i= 0;i<data.data.length; i++) {
                var tr;
                tr ='<td><input id="orginLocation" style="width: 100px;" type="text" value='+data.data[i].orginLocation+'>'
                    + '</td>'
                    + '<td><input id="startTime" style="width: 100px;" type="text" value='+data.data[i].startTime+'>'
                    + '</td>'
                    + '<td><input id="destinationLocation" style="width: 100px;" type="text" value='+data.data[i].destinationLocation+'>'
                    + '</td>'
                    + '<td><input id="reachTime" style="width: 100px;" type="text" value='+data.data[i].reachTime+'>'
                    + '</td>'
                    + '<td><input id="carNum" style="width: 100px;" type="text" value='+data.data[i].carNum+'>'
                    + '</td>'
                    + '<td><input id="ticketPrice" style="width: 100px;" type="text" value='+data.data[i].ticketPrice+'>'
                    + '</td>'
                    + '<td><input id="ticketNum" style="width: 100px;" type="text" value='+data.data[i].ticketNum+'>'
                    + '</td>'
                    + '<td>'
                    + '<button onclick="updatetrips('+i+')">修改</button>'
                    + '</td>';
                $("#ticketTable").append('<tr>' + tr + '</tr>');
            }
        } else
        // 查询失败,错误信息在data.msg里面（未填写个人信息，请完善个人信息）
            alert("错误信息：" + data.msg)

    }
});
$.ajax({
    type : 'GET',
    url : base_url +'/OrderServlet?action=getseal',
    dataType : 'json',
    success : function(data) {
        	$("#sealTable").siblings(
    				'tr'
    			).remove()
        	for (var i= 0;i<data.length; i++) {
        		 var tr;
        		 tr='<td>'+data[i].car_num+'</td>'+
        		 '<td>'+data[i].count_seal_trips+'</td>'+
        		 '<td>'+data[i].re_trips+'</td>'+
        		 '<td>'+data[i].change_trips+'</td>'+
        		 '<td>'+data[i].seal+'</td>';
        		 $("#sealTable").append('<tr>' + tr + '</tr>');
        	}
    }
});
function updatetrips(i){
	var storage = window.localStorage;
	var data = JSON.parse(storage["allItem"]);
	var json={
		"id":data[i].id,
		"orginLocation":$("#orginLocation").val(),
		"startTime":$("#startTime").val(),
		"destinationLocation":$("#destinationLocation").val(),
		"reachTime":$("#reachTime").val(),
		"carNum":$("#carNum").val(),
		"ticketPrice":$("#ticketPrice").val(),
		"ticketNum":$("#ticketNum").val()
	}
	$.ajax({
	    type : 'POST',
	    url : base_url +'/TripsServlet?action=updatetrips',
	    data:json,
	    dataType : 'json',
	    success : function(data) {
	        if (data.stateCode === 200) {
	        	alert(data.msg);
	        }else{
	    	 alert("错误信息：" + data.msg);
	    	}
	    }
	});
}
</script>
</body>
</html>