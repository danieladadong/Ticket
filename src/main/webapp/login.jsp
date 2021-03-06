<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<link rel="stylesheet" href="./css/styleLogin.css">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>> 
</head>
<body class="home">
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>
<div class="cotn_principal">
  <div class="cont_centrar">
    <div class="cont_login">
      <div class="cont_info_log_sign_up">
        <div class="col_md_login">
          <div class="cont_ba_opcitiy">
            <h2>登陆</h2>
            <p>在此处填写信息并登陆，初次使用的用户请先注册！</p>
            <button class="btn_login" onClick="cambiar_login()">登陆</button>
          </div>
        </div>
        <div class="col_md_sign_up">
          <div class="cont_ba_opcitiy">
            <h2>注册</h2>
            <p>在此处填写个人信息并且完成注册并且登陆后即可开始订票</p>
            <button class="btn_sign_up" onClick="cambiar_sign_up()">注册</button>
          </div>
        </div>
      </div>
      <div class="cont_back_info">
        <div class="cont_img_back_grey"> <img src="../img/po.jpg" alt="" /> </div>
      </div>
      <div class="cont_forms" >
        <div class="cont_img_back_"> <img src="../img/po.jpg" alt="" /> </div>
        <div class="cont_form_login"> <a href="#" onClick="ocultar_login_sign_up()" ><i class="material-icons">&#xE5C4;</i></a>
          <h2>登陆</h2>
          <input type="text" id="username" placeholder="用户名" />
          <input type="password" id="password" placeholder="密码" />
          <button class="btn_login" onClick="loginSubmit()">登陆</button>
        </div>
        <div class="cont_form_sign_up"> <a href="#" onClick="ocultar_login_sign_up()"><i class="material-icons">&#xE5C4;</i></a>
          <h2>注册</h2>
          <input type="text" id="usernameSignup" placeholder="用户名" />
          <input type="password" id="passwordSignup" placeholder="密码" />
          <input type="password" id="repasswordSignup" placeholder="确认密码" />
          <button class="btn_sign_up" onClick="signupSubmit()">注册</button>
        </div>
      </div>
    </div>
  </div>
</div>

<script src="./js/loginJS.js"></script>
</body>
</html>