<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <base id="base" href="">
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
    <style>
        .mycss{
            width: 15%;
            height: 15%;
            float: left;
        }
    </style>
</head>
<body style="overflow: auto" >
<section id="main">
    <div  style="overflow: auto;margin-left: 50px">
        <img class="mycss" style="height: 200px;width: 150px" id="myImage" src="${request.contextPath}/static/uploadImage/${myMenitor.menitorimage!}">
    <#-- <div class="mycss2">-->
        <form class="form-horizontal"  style="margin-left: 200px" role="form">
            <div class="form-group" style="height:34px;">
                <label for="firstname" class="col-sm-2 control-label">登录帐号</label>
                <div class="col-sm-10">
                    <input type="hidden" id="id" value="${myMenitor.id}">
                    <input type="text" class="form-control" name="loginname" id="loginname" disabled="true"
                           value="${myMenitor.loginname!}"   placeholder="${myMenitor.loginname!}">
                </div>
            </div>
            <div class="form-group"  style="height:34px;">
                <label for="lastname" class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="myMenitorname" id="myMenitorname"
                           value="${myMenitor.myMenitorname!}"     placeholder="${myMenitor.myMenitorname!}">
                </div>
            </div>
            <div class="form-group"  style="height:34px;">
                <label for="lastname" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" name="loginpass" id="loginpass"
                           value="${myMenitor.loginpass!}" <#--  placeholder="${myMenitor.loginpass!}"-->>
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">性别</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="sex" id="sex"
                           value="${myMenitor.sex!}"  placeholder="${myMenitor.sex!}">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">校区</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="campus" id="campus"
                           value="${myMenitor.campus!}"   placeholder="${myMenitor.campus!}">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">院系</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="department" id="department"
                           value="${myMenitor.department!}"    placeholder="${myMenitor.department!}">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">学历</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="education" id="education"
                           value="${myMenitor.education!}"    placeholder="${myMenitor.education!}">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">办公电话</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="officephone" id="officephone"
                           value="${myMenitor.officephone!}"   placeholder="${myMenitor.officephone!}">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">移动电话</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="priovatephone" id="priovatephone"
                           value="${myMenitor.priovatephone!}"    placeholder="${myMenitor.priovatephone!}">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">办公地址</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="officeadress" id="officeadress"
                           value="${myMenitor.officeadress!}"   placeholder="${myMenitor.officeadress!}">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">qq</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="qq" id="qq"
                           value="${myMenitor.qq!}"   placeholder="${myMenitor.qq!}">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">email</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="email" id="email"
                           value="${myMenitor.email!}"    placeholder="${myMenitor.email!}">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">承担课程</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="course" id="course"
                           value="${myMenitor.course!}"   placeholder="${myMenitor.course!}">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">研究方向</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="research" id="research"
                           value="${myMenitor.research!}"   placeholder="${myMenitor.research!}">
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
</section>
<script src="${request.contextPath}/static/plugins/jquery.1.12.4.min.js"></script>
<script src="${request.contextPath}/static/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
</body>
</html>