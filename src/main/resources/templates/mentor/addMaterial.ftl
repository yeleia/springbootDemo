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
        <form role="form" action="${request.contextPath}/addMaterial" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name">名称</label>
                <input type="text" class="form-control" id="name" name="title"
                       placeholder="请输入名称">
                <label for="discrible">说明</label>
                <input type="text" class="form-control" id="describle" name="describle"
                        placeholder="请输入说明">
            </div>
            <div class="form-group">
                <label for="inputfile">文件输入</label>
                <input type="file" id="inputfile" name="file">
            </div>
            <button type="submit" class="btn btn-default">提交</button>
        </form>
    </div>

</section>

</div>
<script src="${request.contextPath}/static/plugins/jquery.1.12.4.min.js"></script>
<script src="${request.contextPath}/static/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
</body>
</html>