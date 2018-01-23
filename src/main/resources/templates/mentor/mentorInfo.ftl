<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" charset="UTF-8">
    <title>添加课题</title>

    <link href="${request.contextPath}/static/plugins/fullPage/jquery.fullPage.css" rel="stylesheet"/>
    <link href="${request.contextPath}/static/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${request.contextPath}/static/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" rel="stylesheet"/>
    <link href="${request.contextPath}/static/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
    <link href="${request.contextPath}/static/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css" rel="stylesheet"/>
    <link href="${request.contextPath}/static/css/admin.css" rel="stylesheet"/>
    <script>
     /*   function sumbit_sure(){
            var gnl=confirm("确定要删除？");
            if (gnl==true){
                return true;
            }else{
                return false;
            }
        }*/
        function modifyInfo() {
            var id=$("#id").val();
            var loginname=$("#loginname").val();
            var loginpass=$("#loginpass").val();
            var menitorname=$("#menitorname").val();
            var sex=$("#sex").val();
            var campus=$("#campus").val();
            var department=$("#department").val();
            var education=$("#education").val();
            var officephone=$("#officephone").val();
            var priovatephone=$("#priovatephone").val();
            var officeadress=$("#officeadress").val();
            var qq=$("#qq").val();
            var email=$("#email").val();
            var course=$("#course").val();
            var research=$("#research").val();
/*
            alert(loginname+loginpass)
*/
                    $.ajax({
                        type:"post",
                        url:"${request.contextPath}/modifyInfo",
                        dataType:"json",
                        data:{"id":id,"loginname":loginname,"loginpass":loginpass,"menitorname":menitorname,"sex":sex,"campus":campus,"department":department,"education":education,"officephone":officephone,"priovatephone":priovatephone, "officeadress":officeadress,"qq":qq,"email":email,"course":course,"research":research},
                        success:function (result) {
                            if (result.status==200){
                                document.getElementById("loginname").innerHTML = loginname;
                                document.getElementById("loginpass").innerHTML=loginpass;
                                document.getElementById("menitorname").innerHTML=   menitorname;
                                document.getElementById("sex").innerHTML=sex;
                                document.getElementById("campus").innerHTML=campus;
                                document.getElementById("department").innerHTML=department;
                                document.getElementById("education").innerHTML=education;
                                document.getElementById("officephone").innerHTML=officephone;
                                document.getElementById("priovatephone").innerHTML=priovatephone;
                                document.getElementById("officeadress").innerHTML=officeadress;
                                document.getElementById("qq").innerHTML=qq;
                                document.getElementById("email").innerHTML=email;
                                document.getElementById("course").innerHTML=course;
                                document.getElementById("research").innerHTML=research;
                                alert("修改成功")
                                //正餐情况下返回success,如果返回false则弹出修改失败的提示框，并重新跳转到此页面
                            }else if(result.status==500){
                                alert("修改失败")
                               // location.href = "/mentorInfo";
                            }else {
                                location.href="${request.contextPath}/index";
                            }

                        }
                    })
        }
    </script>
    <script>
        function onloadImage() {
            var formData = new FormData(document.getElementById("form"));
            if (formData == null){
                alert("请选择文件")
            } else {
                $.ajax({
                    url:"${request.contextPath}/loadMenitorImage",
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
                            document.getElementById("myImage").src="${request.contextPath}/static/uploadImage/"+result.menitor.menitorimage
                        }else if(result.status==500){
                            alert("图片格式错误");
                        }else {
                            location.href="${request.contextPath}/index";
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
             <img class="mycss" style="height: 200px;width: 150px" id="myImage" src="${request.contextPath}/static/uploadImage/${menitor.menitorimage!}">
             <div class="mybutton">
                <button data-toggle="modal" data-target="#myModal">更换头像</button>
             </div>
           <#-- <div class="mycss2">-->
                <form class="form-horizontal"  style="margin-left: 200px" role="form">
                    <div class="form-group" style="height:34px;">
                        <label for="firstname" class="col-sm-2 control-label">登录帐号</label>
                        <div class="col-sm-10">
                            <input type="hidden" id="id" value="${menitor.id}">
                            <input type="text" class="form-control" name="loginname" id="loginname" disabled="true"
                                value="${menitor.loginname!}"   placeholder="${menitor.loginname!}">
                        </div>
                    </div>
                    <div class="form-group"  style="height:34px;">
                        <label for="lastname" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="menitorname" id="menitorname"
                              value="${menitor.menitorname!}"     placeholder="${menitor.menitorname!}">
                        </div>
                    </div>
                    <div class="form-group"  style="height:34px;">
                        <label for="lastname" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" name="loginpass" id="loginpass"
                                value="${menitor.loginpass!}" <#--  placeholder="${menitor.loginpass!}"-->>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastname" class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="sex" id="sex"
                                 value="${menitor.sex!}"  placeholder="${menitor.sex!}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastname" class="col-sm-2 control-label">校区</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="campus" id="campus"
                                value="${menitor.campus!}"   placeholder="${menitor.campus!}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastname" class="col-sm-2 control-label">院系</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="department" id="department"
                               value="${menitor.department!}"    placeholder="${menitor.department!}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastname" class="col-sm-2 control-label">学历</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="education" id="education"
                               value="${menitor.education!}"    placeholder="${menitor.education!}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastname" class="col-sm-2 control-label">办公电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="officephone" id="officephone"
                                value="${menitor.officephone!}"   placeholder="${menitor.officephone!}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastname" class="col-sm-2 control-label">移动电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="priovatephone" id="priovatephone"
                               value="${menitor.priovatephone!}"    placeholder="${menitor.priovatephone!}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastname" class="col-sm-2 control-label">办公地址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="officeadress" id="officeadress"
                                value="${menitor.officeadress!}"   placeholder="${menitor.officeadress!}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastname" class="col-sm-2 control-label">qq</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="qq" id="qq"
                                value="${menitor.qq!}"   placeholder="${menitor.qq!}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastname" class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="email" id="email"
                               value="${menitor.email!}"    placeholder="${menitor.email!}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastname" class="col-sm-2 control-label">承担课程</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="course" id="course"
                                value="${menitor.course!}"   placeholder="${menitor.course!}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastname" class="col-sm-2 control-label">研究方向</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="research" id="research"
                                value="${menitor.research!}"   placeholder="${menitor.research!}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="button" onclick="modifyInfo()" class="btn btn-default">保存</button>
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