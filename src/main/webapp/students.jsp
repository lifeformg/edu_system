<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>教务系统</title>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/alte/plugins/fontawesome-free/css/all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/alte/dist/css/adminlte.min.css">
</head>
<body>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- Left navbar links -->

        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown">
                <h1>用户名</h1>
            </li>
        </ul>
    </nav>


    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">

        <!-- Sidebar -->
        <div class="sidebar">

            <!-- Sidebar Menu -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
                    data-accordion="false">
                    <!-- Add icons to the links using the .nav-icon class
                         with font-awesome or any other icon font library -->
                    <li class="nav-item menu-open">
                        <a href="../widgets.html" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Widgets
                                <%--                                <span class="right badge badge-danger">New</span>--%>
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="../widgets.html" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Widgets
                                <%--                                <span class="right badge badge-danger">New</span>--%>
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="../widgets.html" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Widgets
                                <%--                                <span class="right badge badge-danger">New</span>--%>
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="../widgets.html" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Widgets
                                <%--                                <span class="right badge badge-danger">New</span>--%>
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="../widgets.html" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Widgets
                                <%--                                <span class="right badge badge-danger">New</span>--%>
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="../widgets.html" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Widgets
                                <%--                                <span class="right badge badge-danger">New</span>--%>
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="../widgets.html" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Widgets
                                <%--                                <span class="right badge badge-danger">New</span>--%>
                            </p>
                        </a>
                    </li>

                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title">学生信息</h3>



                                <div class="card-tools">

                                    <div class="input-group input-group-sm" style="width: 150px;">

                                        <div class="input-group-prepend">
                                            <button type="button" class="btn btn-default btn-info"><a href="${pageContext.request.contextPath}/admin/studentAddPage">添加</a></button>
                                        </div>


                                        <input type="text" name="table_search" class="form-control float-right"
                                               placeholder="Search">

                                        <div class="input-group-append">
                                            <button type="submit" class="btn btn-default">
                                                <i class="fas fa-search"></i>
                                            </button>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <table id="example2" class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>用户ID</th>
                                        <th>用户名</th>
                                        <th>性别</th>
                                        <th>出生日期</th>
                                        <th>入学日期</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <c:forEach items="${students}" var="student">
                                        <tr>
                                            <td>${student.userid}</td>
                                            <td>${student.username}</td>
                                            <td>${student.sex}</td>
                                            <td>${student.birthyear}</td>
                                            <td>${student.grade}</td>
                                            <td class="text-right py-0 align-middle">
                                                <div class="btn-group btn-group-sm">
                                                    <a href="${pageContext.request.contextPath}/admin/studentUpdatePage?userid=${student.userid}" class="btn btn-info"><i class="fas fa-edit"></i></a>
                                                    <a href="${pageContext.request.contextPath}/admin/delete?userid=${student.userid}" class="btn btn-danger"><i class="fas fa-trash"></i></a>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                            <!-- 分页器 -->
                            <div class="row ml-1" >
                                <div class="col-sm-12 col-md-7">
                                    <div class="dataTables_paginate paging_simple_numbers" id="example1_paginate">
                                        <ul class="pagination">

                                            <li class="paginate_button page-item previous"
                                                id="example1_previous">
                                                <a href="${pageContext.request.contextPath}/admin/students?page=${page.pageNow-1}"
                                                                          data-dt-idx="${page.pageNow+1}" tabindex="0"
                                                                          class="page-link">Previous</a>

                                            </li>
                                            <c:forEach begin="1" end="${page.pageTotal}" var="index">

                                                <c:if test="${index != page.pageNow}">
                                                    <li class="paginate_button page-item">
                                                        <a href="${pageContext.request.contextPath}/admin/students?page=${index}"
                                                           aria-controls="example1"
                                                           data-dt-idx="${index}" tabindex="0"
                                                           class="page-link">${index}</a>
                                                    </li>
                                                </c:if>
                                                <c:if test="${index == page.pageNow}">
                                                    <li class="paginate_button page-item active">
                                                        <a href="${pageContext.request.contextPath}/admin/students?page=${index}"
                                                           aria-controls="example1"
                                                           data-dt-idx="${index}" tabindex="0"
                                                           class="page-link">${index}</a>
                                                    </li>
                                                </c:if>

                                            </c:forEach>


                                            <li class="paginate_button page-item next" id="example1_next">
                                                <a href="${pageContext.request.contextPath}/admin/students?page=${page.pageNow+1}"
                                                         aria-controls="example1"
                                                         data-dt-idx="${page.pageNow+1}"
                                                         tabindex="0"
                                                         class="page-link">Next</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.card -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>


    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/static/alte/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/static/alte/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- DataTables  & Plugins -->
<script src="${pageContext.request.contextPath}/static/alte/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/static/alte/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="${pageContext.request.contextPath}/static/alte/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath}/static/alte/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="${pageContext.request.contextPath}/static/alte/plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="${pageContext.request.contextPath}/static/alte/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script src="${pageContext.request.contextPath}/static/alte/plugins/jszip/jszip.min.js"></script>
<script src="${pageContext.request.contextPath}/static/alte/plugins/pdfmake/pdfmake.min.js"></script>
<script src="${pageContext.request.contextPath}/static/alte/plugins/pdfmake/vfs_fonts.js"></script>
<script src="${pageContext.request.contextPath}/static/alte/plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="${pageContext.request.contextPath}/static/alte/plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="${pageContext.request.contextPath}/static/alte/plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/static/alte/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/static/alte/dist/js/demo.js"></script>
<!-- Page specific script -->
<script>
    $(function () {
        $("#example1").DataTable({
            "responsive": true, "lengthChange": false, "autoWidth": false,
            "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
        }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
        $('#example2').DataTable({
            "paging": false,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": false,
            "autoWidth": false,
            "responsive": true,
        });
    });
</script>
</body>
</body>
</html>
