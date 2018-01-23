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
    <style>
        .element{
            display:none; //元素默认是隐藏的
        }
        .father:hover .element{
            display:block ;
        }

    </style>

</head>
<body>
<section style="margin: 5%" id="main">

    <table  class="table table-striped">
        <thead>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>校区</th>
            <th>院系</th>
            <th>专业</th>
            <th>其他信息</th>
        </tr>
        </thead>
        <tbody>
        <#if student?? &&(student?size>0)>
        <#list student as student>
        <tr>
            <td>${student.studentlogin!}</td>
            <td>${student.studentname!}</td>
            <td>${student.sex!}</td>
            <td>${student.campus!}</td>
            <td>${student.departmentroom!}</td>
            <td>${student.major!}</td>
            <td><a href="${request.contextPath}/seeStudentInfo?id=${student.id!}">详细信息</a></td>

        </tr>
        </#list>
        <#else>
        <tr>
            <td>还未添加学生</td>
        </tr>
        </#if>
        </tbody>
        <style>
            .father{
                position:relative;
            }
            .father .fatherInfo{
                display: none;
                position: absolute;
                width:100%;
                height:60px;
                border:1px solid grey;
                top:-60px;
                background:darkgray;
                color:#fff;
            }
            .fatherInfo::after{
                content: '';
                display: block;
                width: 0;
                height: 0;
                margin-top:-16px;
                border-top: 20px solid darkgray;
                border-right: 20px solid transparent;
                border-left: 20px solid transparent;
            }
            .father:hover .fatherInfo{display:block;cursor:pointer}
        </style>

    </table>
</section>
<script src="${request.contextPath}/static/plugins/jquery.1.12.4.min.js"></script>
<script src="${request.contextPath}/static/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
</body>
</html>