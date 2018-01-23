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
        function loadPaper() {
            var formData = new FormData(document.getElementById("form"));
            if (formData==null){
                alert("请选择文件")
            }else {
                $.ajax({
                    url:"${request.contextPath}/student/uploadPaper",
                    type:"post",
                    data:formData,
                    async: false,
                    cache: false,
                    contentType: false,
                    processData: false,
                    success:function (result) {
                        if (result.status==200){
                            var text1=
                        }
                    }
                })
            }

        }
    </script>
</head>
<body>
<section id="main">
    <div style="margin-left: 50px">
       <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">上传论文</button>
        <table class="table" style="margin-top: 50px">
            <thead>
            <tr>
                <th>操作</th>
                <th>提交时间</th>
                <th>是否已阅</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <#if paper?? && (paper?size>0)>
                <td><a href="${request.contextPath}/static/upload/${paper.paper}" target="_blank"><button>预览</button></a> &nbsp;&nbsp;<a href="${request.contextPath}/student/loadPa?id=${paper.id}"><button>下载</button></a> </td>
                <td>${paper.uploadtime?string("yyyy-MM-dd HH:mm:ss")}</td>
                    <#if (paper.pstatus=="0")>
                <td>未阅</td>
                  <#else>
                  <td>已阅</td>
                  </#if>
                  <#--  <#else>
                    <td>还未上传论文</td>-->
                </#if>
            </tr>
            </tbody>
        </table>        ​        ​
    </div>
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
                  上传论文
                </h4>
            </div>
            <div class="modal-body">
                <form id="form" action="${request.contextPath}/student/uploadPaper" method="post" enctype="multipart/form-data">
                    <label style="color: #A60000">只能上传pdf文档</label><br><br>
                    <input type="file" name="file" id="file"><br><br>
                    <button type="submit">上传</button>
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