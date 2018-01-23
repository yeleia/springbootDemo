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
        <table class="table">
            <thead>
            <tr>
                <th>题目</th>
                <th>发表时间</th>
                <th>说明</th>
                <th>资料</th>
            </tr>
            </thead>
            <tbody>
            <#if material??&&(material?size>0)>
            <#list material as material>
            <tr class="active">
                <td>${material.title}</td>
                <td>${material.uploadtime?string("yyyy-MM-dd HH:mm:ss")}</td>
                <td>${material.describle}</td>
                <td><a href="${request.contextPath}/static/upload/${material.pdfpath}" target="_blank"><button>预览</button></a>&nbsp;&nbsp;<a href="${request.contextPath}/student/downMaterial?id=${material.id}"><button>下载</button></a></td>
                <style>
                    .active .butny{
                        display:block;
                        float:left;
                    }
                </style>
            </tr>
            </#list>
            </#if>
            </tbody>
        </table>
    </div>
</section>

</div>
<script src="${request.contextPath}/static/plugins/jquery.1.12.4.min.js"></script>
<script src="${request.contextPath}/static/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
</body>
</html>