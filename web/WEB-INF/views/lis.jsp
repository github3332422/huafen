<%--
  Created by IntelliJ IDEA.
  User: mailz
  Date: 2019/7/20
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% pageContext.setAttribute("Base_Path",request.getContextPath());%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>lis</title>
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
                <h1>客户管理系统</h1>
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
                        <th>员工ID</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>邮箱</th>
                        <th>部门</th>
                        <th>
                            操作
                        </th>
                    </tr>
                    <c:forEach items="${pageInfo.list}" var="emp">
                        <tr>
                            <td>#</td>
                            <td>${emp.emp_id}</td>
                            <td>${emp.emp_name}</td>
                            <td>${emp.emp_gender}</td>
                            <td>${emp.email}</td>
                            <td>${emp.department.deptName}</td>
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

        <!-- 分页 -->
        <div class="row">
            <div class="col-md-6">
                当前页${pageInfo.pageNum}
                总页数${pageInfo.pages}
                总记录${pageInfo.total}
            </div>
            <div class="col-md-6">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li><a href="${Base_Path}/emps?pn=1">首页</a></li>
                        <c:if test="${pageInfo.hasPreviousPage}">
                            <li>
                                <a href="${Base_Path}/emps?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>

                        <!--连续要显示的页码-->
                        <c:forEach items="${pageInfo.navigatepageNums}" var="pagenum">
                            <c:if test="${pagenum == pageInfo.pageNum}">
                                <li class="active"><a href="#">${pagenum} <span class="sr-only">(current)</span></a></li>
                            </c:if>
                            <c:if test="${pagenum != pageInfo.pageNum}">
                                <li><a href="${Base_Path}/emps?pn=${pagenum}">${pagenum} <span class="sr-only">(current)</span></a></li>
                            </c:if>
                        </c:forEach>
                        <c:if test="${pageInfo.hasNextPage}">
                            <li>
                                <a href="${Base_Path}/emps?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>

                        <li>
                            <a href="${Base_Path}/emps?pn=${pageInfo.pages}">末页</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>


</body>
</html>
