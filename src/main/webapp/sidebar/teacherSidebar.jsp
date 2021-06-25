<%--
  Created by IntelliJ IDEA.
  User: 29254
  Date: 2021/6/24
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<aside class="main-sidebar sidebar-dark-primary elevation-4">

    <!-- Sidebar -->
    <div class="sidebar">

        <!-- Sidebar Menu -->
        <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
                data-accordion="false">
                <!-- Add icons to the links using the .nav-icon class
                     with font-awesome or any other icon font library -->
                <li class="nav-item ${param.get("activate").equals("course")?"menu-open":""}">
                    <a href="${pageContext.request.contextPath}/teacher/course/courses" class="nav-link">
                        <i class="nav-icon fas fa-1x"></i>
                        <p>
                            我的课程
                        </p>
                    </a>
                </li>

                <li class="nav-item ${param.get("activate").equals("changePassword")?"menu-open":""}">
                    <a href="${pageContext.request.contextPath}/changePasswordPage" class="nav-link">
                        <i class="nav-icon fas fa-1x"></i>
                        <p>
                            修改密码
                        </p>
                    </a>
                </li>

                <li class="nav-item ${param.get("activate").equals("#")?"menu-open":""}">
                    <a href="${pageContext.request.contextPath}/logout" class="nav-link">
                        <i class="nav-icon fas fa-1x"></i>
                        <p>
                            退出系统
                        </p>
                    </a>
                </li>


            </ul>
        </nav>
        <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
</aside>
</body>
</html>
