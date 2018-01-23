<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加课题</title>

    <link href="${request.contextPath}/static/plugins/fullPage/jquery.fullPage.css" rel="stylesheet"/>
    <link href="${request.contextPath}/static/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${request.contextPath}/static/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" rel="stylesheet"/>
    <link href="${request.contextPath}/static/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
    <link href="${request.contextPath}/static/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css" rel="stylesheet"/>
    <link href="${request.contextPath}/static/css/admin.css" rel="stylesheet"/>
    <script>
        function sumbit_sure(){
            var gnl=confirm("确定要删除？");
            if (gnl==true){
                return true;
            }else{
                return false;
            }
        }
    </script>
</head>
<body>
<section id="main">
    <div style="margin-left: 50px">
        <form role="form" action="${request.contextPath}/addStudent" method="post">
            <div class="form-group">
                <label for="name">帐号</label>
                <input type="text" class="form-control" id="name" name="studentlogin"
                       placeholder="帐号">
                <label for="">密码</label>
                <input type="text" class="form-control" name="loginpass" placeholder="密码">
                <label for="">姓名</label>
                <input type="text" class="form-control" name="studentname" placeholder="姓名">
            </div>
            <button type="submit" class="btn btn-default">提交</button>
        </form>
    </div>
</section>
<script src="${request.contextPath}/static/plugins/jquery.1.12.4.min.js"></script>
<script src="${request.contextPath}/static/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
</body>
</html>