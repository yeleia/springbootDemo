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
    <table class="table table-condensed" style="margin: 40px">
        <thead>
        <tr>
            <th>学生学号</th>
            <th>学生姓名</th>
            <th>选择课题</th>
            <th>上传时间</th>
            <th>上传的论文</th>
        </tr>
        </thead>
        <tbody>
       <#if myPaperList?? && (myPaperList?size>0)>
        <#list myPaperList as myPaperList>
        <tr>
            <td>${myPaperList.studentNum}</td>
            <td>${myPaperList.studentName}</td>
            <td>${myPaperList.studentProject}</td>
            <td>${myPaperList.paperTime?string("yyyy-MM-dd HH:mm:ss")}</td>
            <td><a href="/static/upload/${myPaperList.studentPaper}" target="_blank"><button>预览</button></a>&nbsp;&nbsp;<a href="/downPaper?id=${myPaperList.paperId}"><button>下载</button></a></td>
        </tr>
     </#list>
      </#if>
        </tbody>
    </table>

</section>

</div>
<script src="${request.contextPath}/static/plugins/jquery.1.12.4.min.js"></script>
<script src="${request.contextPath}/static/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
</body>
</html>