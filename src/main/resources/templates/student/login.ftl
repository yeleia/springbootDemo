<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>登录页</title>

	<link href="${request.contextPath}/static/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="${request.contextPath}/static/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" rel="stylesheet"/>
	<link href="${request.contextPath}/static/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
	<link href="${request.contextPath}/static/plugins/checkbix/css/checkbix.min.css" rel="stylesheet"/>
	<link href="${request.contextPath}/static/css/login.css" rel="stylesheet"/>
    <style>
        .fg-line button{
            padding:0;
            width:100%;
            text-align: center;
            color:#fff;
            border:none;
            height:30px;
            line-height:30px;
            display:block;
            background: #29a176;
            background:
                    linear-gradient(-135deg, transparent 15px, #29a176 0)
                    top right,
                    linear-gradient(-45deg, transparent 15px, #29a176 0)
                    bottom right;
            background-size: 100% 50%;
            background-repeat: no-repeat;
        }	</style>
	<script>
		function sub() {
		    //alert("test")
            var studentlogin = $("#studentlogin").val();
            var loginpass = $("#loginpass").val();
            //alert(studentlogin + loginpass+"ytest")
            if (studentlogin == null || studentlogin == "") {
                alert("请输入登录账户")
            } else if (loginpass == null || loginpass == "") {
                alert("请输入登录密码")
            } else {
                $.ajax({
					url:"${request.contextPath}/student/ajaxLogin",
					type:"post",
					dataType:"json",
					data:{studentlogin:studentlogin,loginpass:loginpass},
					success:function (result) {
					    //alert(result.status+result.message)
					   if(result.status!=200){
                           alert(result.message)
					   } else{
					       alert(result.message)
                           location.href = "${request.contextPath}/student/index";
					   }
                    }
				})
            }
        }

	</script>
</head>
<body>
<div id="login-window">
	<div class="input-group m-b-20">
		<span class="input-group-addon"><#--<i class="zmdi zmdi-account"></i>--></span>
		<div class="fg-line" style="align-content: center">
			<center>学生登录</center>
		</div>
	</div>
	<div class="input-group m-b-20">
		<span class="input-group-addon"><i class="zmdi zmdi-account"></i></span>
		<div class="fg-line">
			<input id="studentlogin" type="text" class="form-control" name="studentlogin" placeholder="帐号" required autofocus >
		</div>
	</div>
	<div class="input-group m-b-20">
		<span class="input-group-addon"><i class="zmdi zmdi-male"></i></span>
		<div class="fg-line">
			<input id="loginpass" type="password" class="form-control" name="loginpass" placeholder="密码" required >
		</div>
	</div>
	<div class="clearfix">
	</div>
	<#--<center><button onclick="sub()">login</button></center>-->
    <a  id="login-bt" onclick="sub()" <#--href="javascript:;" -->class="waves-effect waves-button waves-float"><i  class="zmdi zmdi-arrow-forward"></i></a>
    <div class="input-group m-b-20">
        <span class="input-group-addon"><#--<i class="zmdi zmdi-account"></i>--></span>
        <div class="fg-line" style="align-content: center">
            <center><a  href="${request.contextPath}/index"><button>导师登录</button></a></center>
        </div>
    </div>
</div>
<div>

</div>
<script src="${request.contextPath}/static/plugins/jquery.1.12.4.min.js"></script>
<script src="${request.contextPath}/static/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${request.contextPath}/static/plugins/waves-0.7.5/waves.min.js"></script>
<script src="${request.contextPath}/static/plugins/checkbix/js/checkbix.min.js"></script>

<script src="${request.contextPath}/static/js/login.js"></script>
<script type="text/javascript">
	Checkbix.init();
</script>
</body>
</html>