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
        function chose() {
            var id=$("#projectId").val();
            //alert(id)
            //通过ajax请求，如果该生已经选择了，则不能再此选择
            $.ajax({
                type:"post",
                url:"${request.contextPath}/student/choseProject",
                dataType:"json",
                data:{"id":id},
                success:function (result){
                    if(result.status==200){
                        alert(result.message)
                        var text="<td>"+result.project.title+"</td><td><a href='${request.contextPath}/static/upload/"+result.project.documentpdf+"'target='_blank'>" +
                        "<button>预览</button></a>&nbsp;&nbsp;<a href='${request.contextPath}/student/down?id="+id+"'><button>下载</button></a></td><td><form action='${request.contextPath}/student/deleteMyProject?id="+id+"'method='post' onsubmit='sumbit_sure()'><button type='submit'>删除</button></td>";
                        //$("#ajaxText").html($("#ajaxText").html() + text);
                        document.getElementById("ajaxText").innerHTML =text;
                        document.getElementById("select").innerHTML = "已被选择";
                    }else if (result.status==500){
                        alert(result.message)
                    }else{
                        alert(result.message)
                        location.href="${request.contextPath}/toStudentLogin";
                    }
                }
            })
        }
        function deleteMyPro() {
            var id=$("#myProjectId").val();
            $.ajax({
                type:"post",
                url:"${request.contextPath}/student/deleteMyProject",
                dataType:"json",
                data:{"id":id},
                success:function (result) {
                    if(result.status==200){
                        alert(result.message)
                        var text="<td>还未选择课题</td>";
                        var text1="<button onclick='deleteMyPro()' value="+id+">删除</button>";

                        //$("#ajaxText").html($("#ajaxText").html() + text);
                        document.getElementById("ajaxText").innerHTML = text;
                        document.getElementById("noselect").innerHTML = text1;
                        //将已被选择换成按钮
                    }else{
                        alert(result.message);
                        location.href= "${request.contextPath}/toStudentLogin";
                    }
                }
            })



        }
    </script>
</head>
<body>
<section id="main">
    <center><span>一个学生只能选择一个课题</span></center>
    <div style="margin-left: 50px">
        <table class="table">
            <caption>我的课题</caption>
            <thead>
            <tr>
                <th>题目</th>
                <th>文档</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr id="ajaxText">
                <#if myProject??>
                    <td>${myProject.title!}</td>
                    <td><a href="${request.contextPath}/static/upload/${myProject.documentpdf!}" target="_blank"><button>预览</button></a>&nbsp;&nbsp;<a href="${request.contextPath}/student/down?id=${myProject.id}"><button>下载</button></a></td>
                    <td>
                    <form action="${request.contextPath}/student/deleteMyProject?id=${myProject.id}" onsubmit="return sumbit_sure()" method="post">
                        <button type="submit">删除</button>
                    </form></td>
                <#else>
                    <td>还未选择课题</td>
                </#if>
            </tr>
        </table>
            </tbody>
        <table class="table">
            <caption>所有的课题</caption>
            <thead>
            <tr>
                <th>题目</th>
                <th>文档</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <#if project?? && (project?size>0)>
            <#list project as project>
            <tr>
                <td>${project.title}</td>
                <td><a href="${request.contextPath}/static/upload/${project.documentpdf}" target="_blank"><button>预览</button></a>&nbsp;&nbsp;<a href="${request.contextPath}/student/down?id=${project.id}"><button>下载</button></a>&nbsp;&nbsp;</td>
                <#if (project.status==0)>
                <td id="select"><button onclick="chose()" id="projectId" value="${project.id}">选择</button></td>
                <#else>
                <td id="noselect">已被选择</td>
                </#if>
            </tr>
            </#list>
            </#if>
            </tbody>
        </table>
    </div>
</section>
<script src="${request.contextPath}/static/plugins/jquery.1.12.4.min.js"></script>
<script src="${request.contextPath}/static/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
</body>
</html>