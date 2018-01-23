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
        <button type="button" class="btn btn-info" data-toggle="modal"  data-target="#myModal">添加课题</button>
    <table class="table">
       <#-- <caption>上下文表格布局</caption>-->
        <thead>
        <tr>
            <th>题目</th>
            <th>发表时间</th>
            <th>文档</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
       <#if project?? && (project?size>0)>
        <#list project as project>
        <tr class="active">
            <td>${project.title!}</td>
            <td>${project.publishtime?string("yyyy-MM-dd HH:mm:ss")}</td>
            <td><a href="${request.contextPath}/static/upload/${project.documentpdf!}" target="_blank"><button>预览</button></a>&nbsp;&nbsp;<a href="${request.contextPath}/down?id=${project.id}"><button>下载</button></a></td>
            <td><button class="butny" data-toggle="modal"  data-target="#${project.id}">修改</button>&nbsp;&nbsp;
                <form action="${request.contextPath}/delete?id=${project.id}" onsubmit="return sumbit_sure()" method="post">
                    <button class="butny"  type="submit">删除</button>
                </form></td>
            <style>
                .active form{
                    display:inline-block;
                    width:60px;
                }
                .active .butny{
                    display:block;
                    float:left;
                }
            </style>
        </tr>
        <!-- 修改模态框（Modal） -->
        <div class="modal fade" id="${project.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <h4 class="modal-title" id="myModalLabel">
                            修改课题
                        </h4>
                    </div>
                    <div class="modal-body">
                        <form role="form" action="${request.contextPath}/updateProject" method="post" enctype="multipart/form-data">
                            <div class="form-group">
                                <input name="id" type="hidden" value="${project.id}">
                                <label for="name">题目</label>
                                <input name="title" type="text" class="form-control" id="name"
                                   value="${project.title}"    placeholder="${project.title}">
                            </div>
                            <div class="form-group">
                                <label for="inputfile">上传文件</label>
                                <input type="file" name="file" id="inputfile">
                            </div>
                            <button type="submit" class="btn btn-default">提交</button>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button>
                    <#-- <button type="button" class="btn btn-primary">
                         提交更改
                     </button>-->
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
        </#list>
       </#if>
        </tbody>
    </table>
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
                    添加课题
                </h4>
            </div>
            <div class="modal-body">
                <form role="form" action="${request.contextPath}/addProject" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="name">题目</label>
                        <input name="title" type="text" class="form-control" id="name"
                               placeholder="请输入题目">
                    </div>
                    <div class="form-group">
                        <label for="inputfile">上传文件</label>
                        <input type="file" name="file" id="inputfile">
                    </div>
                    <button type="submit" class="btn btn-default">提交</button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
               <#-- <button type="button" class="btn btn-primary">
                    提交更改
                </button>-->
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script src="${request.contextPath}/static/plugins/jquery.1.12.4.min.js"></script>
<script src="${request.contextPath}/static/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
</body>
</html>