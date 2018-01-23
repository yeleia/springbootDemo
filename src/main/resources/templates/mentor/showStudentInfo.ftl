<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
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
    <script>
        function onloadImage() {
            var formData = new FormData(document.getElementById("form"));
            if (formData == null){
                alert("请选择文件")
            } else {
                $.ajax({
                    url: "${request.contextPath}/student/updateImage",
                    type: "post",
                    data: formData,
                    async: false,
                    cache: false,
                    contentType: false,
                    processData: false,
                    success: function (result) {

                        //alert(result.menitor.menitorimage
                        if(result.status==200){
                            //alert("上传图片成功");
                            document.getElementById("myImage").src="${request.contextPath}/static/uploadImage/"+result.student.studentImage
                        }else if(result.status==500){
                            alert(result.message)
                        }else {
                            location.href="${request.contextPath}/toStudentLogin";
                        }
                    }
                })
            }
        }

    </script>
    <style>
        .mycss{
            width: 15%;
            height: 15%;
            float: left;
        }
        .mybutton{
            position: absolute;
            margin-top: 220px;
            margin-left: 30px
        }
        .mycss2{
            width:auto;
            height: auto;
            float: left;
            margin-left: 100px;
        }
    </style>
</head>
<body style="overflow: auto">
<section id="main">
    <div  style="overflow: auto;margin-left: 50px">
        <img class="mycss" style="height: 200px;width: 150px" id="myImage" src="${request.contextPath}/static/uploadImage/${student.studentImage!}">
        <#--<div class="mybutton">-->
            <#--<button data-toggle="modal" data-target="#myModal">更换头像</button>-->
        <#--</div>-->
    <#-- <div class="mycss2">-->
        <form class="form-horizontal"  style="margin-left: 200px" role="form">
            <div class="form-group" style="height:34px;">
                <label for="firstname" class="col-sm-2 control-label">登录帐号</label>
                <div class="col-sm-10">
                    <input type="hidden" id="id" value="${student.id}">
                    <input type="text" class="form-control" name="loginname" id="loginname" <#--disabled="true"-->
                           value="${student.loginname!}"   placeholder="${student.studentlogin!}">
                </div>
            </div>
            <div class="form-group"  style="height:34px;">
                <label for="lastname" class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="studentname" id="studentname"
                           value="${student.studentname!}"     placeholder="${student.studentname!}">
                </div>
            </div>
            <#--<div class="form-group"  style="height:34px;">-->
                <#--<label for="lastname" class="col-sm-2 control-label">密码</label>-->
                <#--<div class="col-sm-10">-->
                    <#--<input type="text" class="form-control" name="loginpass" id="loginpass"-->
                           <#--value="${student.loginpass!}" &lt;#&ndash;  placeholder="${student.loginpass!}"&ndash;&gt;>-->
                <#--</div>-->
            <#--</div>-->
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">性别</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="sex" id="sex"
                           value="${student.sex!}"  placeholder="${student.sex!}">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">校区</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="campus" id="campus"
                           value="${student.campus!}"   placeholder="${student.campus!}">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">院系</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="department" id="departmentroom"
                           value="${student.departmentroom!}"    placeholder="${student.departmentroom!}">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">专业</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="education" id="major"
                           value="${student.major!}"    placeholder="${student.major!}">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">qq</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="qq" id="qq"
                           value="${student.qq!}"   placeholder="${student.qq!}">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">email</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="email" id="email"
                           value="${student.email!}"    placeholder="${student.email!}">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">移动电话</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="course" id="tele"
                           value="${student.tele!}"   placeholder="${student.tele!}">
                </div>
            </div>
        <#if project??>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">选择课题</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="course" id="tele"
                           value="${project.title!}"   placeholder="${project.title!}">
                </div>
            </div>
        <#else>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">选择课题</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="course" id="tele"
                           value="<#--${project.title!}-->"   placeholder="<#--${project.title!}-->">
                </div>
            </div>
            </#if>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <a href="${request.contextPath}/seeStudentMessage"><button type="button" class="btn btn-default">返回</button></a>
                </div>
            </div>
        </form>
    </div>
    <style>
        .form-group .col-sm-10{
            width:40%;
        }
        .form-horizontal .form-group{
            height:34px;
            margin-bottom:15px;
        }
    </style>
<#-- </div>-->
</section>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    修改头像
                </h4>
            </div>
            <div class="modal-body">
                <form id="form" method="post">
                    <input type="file" name="file" id="file"><br><br>
                    <input type="button" onclick="onloadImage()" value="提交">
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
    <script src="${request.contextPath}/static/plugins/jquery.1.12.4.min.js"></script>
    <script src="${request.contextPath}/static/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
</body>
</html>