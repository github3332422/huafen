<%--
  Created by IntelliJ IDEA.
  User: mailz
  Date: 2019/7/28
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% pageContext.setAttribute("Base_Path",request.getContextPath());%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dept</title>
    <script type="text/javascript"
            src="${Base_Path }/static/js/jquery-1.12.4.min.js"></script>
    <link
            href="${Base_Path }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
            rel="stylesheet">
    <script
            src="${Base_Path }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container ">

    <!-- 标题栏 -->
    <div class="row">
        <div class=".col-xs-6">
            <h1>部门管理系统</h1>
        </div>
    </div>

    <!-- 显示按钮 -->
    <div class="row">
        <div class="col-md-3 col-md-offset-0">
            <button type="button" class="btn btn-success">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加
            </button>
            <button type="button" class="btn btn-danger">
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
            </button>
        </div>
    </div>

    <!-- 显示表格数据 -->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <tr>
                    <th>#</th>
                    <th>部门ID</th>
                    <th>部门名称</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${pageInfo.list}" var="emp">
                    <tr>
                        <td>#</td>
                        <td>${emp.deptId}</td>
                        <td>${emp.deptName}</td>
                        <td>
                            <button type="button" class="btn btn-warning btn-sm">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑
                            </button>
                            <button type="button" class="btn btn-danger btn-sm">
                                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                删除
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
