
$(function(){
    //nav 
	jQuery("#nav").slide({
		type: "menu",
		titCell: ".nLi",
		targetCell: ".sub",
		effect: "slideDown",
		delayTime: 300,
		triggerTime: 0,
		returnDefault: true
	});
	//banner
	jQuery(".slideBox").slide({
		mainCell: ".bd ul",
		effect: "leftLoop",
		autoPlay: true
	});
	//图片轮播
	jQuery(".picScroll-left").slide({
		mainCell: ".bd ul",
		autoPage: true,
		effect: "leftLoop",
		autoPlay: true,
		vis: 3
	});
	//饭心服务
	jQuery(".server_b").slide({
		mainCell: ".bd ul",
		effect: "leftLoop",
		autoPlay: true
	});
	$(".server_b .bd li div:last-child").css({
		"float":"right"
	});
	//给元素动态加载class名称
	window.onload=function(){
		$(".footer ul li:nth-child(2)").addClass("cur");
		$(".footer ul li:last-child").addClass("cur1");
		$(".accepBom ul li:nth-child(2n)").addClass("cur");
	}
	//产品展示
	$(".show_bot ul li:nth-child(4n)").css({
		"float":"right",
		"margin-right":"0"
	});
	//饭心客户
	$(".customer ul li:nth-child(5n)").css({
		"float":"right",
		"margin-right":"0"
	});
	//商务合作
	$(".cooForm h1 input:nth-child(2)").css({
		"float":"right"
	});
	
	//弹出层
//	$(".details").click(function(){
//		$("#TB_overlayBG").css({
//			display:"block",height:$(document).height()
//		});
//		$(".layer").css({
//			top:($(window).height()-$(".layer").height())/1.5+$(window).scrollTop()+"px",
//			display:"block"
//		});
//	});
//	$(".close").click(function(){
//		$("#TB_overlayBG").css({
//			display:"none",height:$(document).height()
//		});
//		$(".layer").css({
//			top:($(window).height()-$(".layer").height())/1.5+$(window).scrollTop()+"px",
//			display:"none"
//		});
//	});
	$(document).ready(function(){
		$(".accepBom ul li .details").click(function(){
			$("#TB_overlayBG").css({
				display:"block",height:$(document).height()
			});
			var index = $(this).parents(".accepBom ul li").index();
			$('.layer').eq(index).css({
				top:($(window).height()-$(".layer").height())/1.5+$(window).scrollTop()+"px",
				display:"block"
			});
		});
		$(".close").click(function(){
			$("#TB_overlayBG").fadeOut();
			$(this).parents('.layer').fadeOut();
		});
	});
	
	
	//动态加class
	$(".show_top a").click(function(){
		$(this).addClass('cur').siblings().removeClass('cur');
	});
	
});

$(function(){
	var text = '姓名';
	$('#testA').focus(function() {
		if (text == $(this).val()) {
			$(this).val('');
			$(this).css({
				"color":"#333"
			});
		}
	});
	$('#testA').blur(function() {
		var value = $(this).val();
		if (value == '' || value == text) {
			$(this).val(text);
			$(this).css({
				"color":"#969696"
			});
		}
	});
	
	var text1 = '电话';
	$('#testB').focus(function() {
		if (text1 == $(this).val()) {
			$(this).val('');
			$(this).css({
				"color":"#333"
			});
		}
	});
	$('#testB').blur(function() {
		var value = $(this).val();
		if (value == '' || value == text1) {
			$(this).val(text1);
			$(this).css({
				"color":"#969696"
			});
		}
	});
	
	var text2 = '留言';
	$('#testC').focus(function() {
		if (text2 == $(this).val()) {
			$(this).val('');
			$(this).css({
				"color":"#333"
			});
		}
	});
	$('#testC').blur(function() {
		var value = $(this).val();
		if (value == '' || value == text2) {
			$(this).val(text2);
			$(this).css({
				"color":"#969696"
			});
		}
	});
	
});
