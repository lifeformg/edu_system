<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>教务系统</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/alte/plugins/fontawesome-free/css/all.min.css">
  <!-- daterange picker -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/alte/plugins/daterangepicker/daterangepicker.css">
  <!-- iCheck for checkboxes and radio inputs -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/alte/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- Bootstrap Color Picker -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/alte/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.min.css">
  <!-- Tempusdominus Bootstrap 4 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/alte/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- Select2 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/alte/plugins/select2/css/select2.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/alte/plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css">
  <!-- Bootstrap4 Duallistbox -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/alte/plugins/bootstrap4-duallistbox/bootstrap-duallistbox.min.css">
  <!-- BS Stepper -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/alte/plugins/bs-stepper/css/bs-stepper.min.css">
  <!-- dropzonejs -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/alte/plugins/dropzone/min/dropzone.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/alte/dist/css/adminlte.min.css">
</head>
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
    <jsp:include page="../sidebar/adminSidebar.jsp" flush="true">
        <jsp:param name="activate" value="course"/>
    </jsp:include>

  <div class="content-wrapper">

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">
            <div class="card">

              <!-- /.card -->
              <!-- Horizontal Form -->
              <div class="card card-info">
                <div class="card-header">
                  <h3 class="card-title">Horizontal Form</h3>
                </div>
                <!-- /.card-header -->
                <!-- form start -->
                  <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}${prefix}/add">

                      <div class="card-body">
                          <div class="form-group row">
                              <label for="inputEmail3" class="col-sm-2 col-form-label">课程ID</label>
                              <div class="col-sm-10">
                                  <input type="number" min="0" class="form-control" id="inputEmail3" placeholder="课程ID" name="courseid" value="${course.courseid}">
                              </div>
                          </div>

                          <div class="form-group row">
                              <label for="inputPassword3" class="col-sm-2 col-form-label">课程名称</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" id="inputPassword3" placeholder="课程名称" name="coursename" value="${course.coursename}">
                              </div>
                          </div>

                          <div class="form-group row">
                              <label for="s2" class="col-sm-2 col-form-label">教师ID</label>
                              <div class="col-sm-10">
                                  <select class="form-control select2" id="s2" name="teacherid">
                                      <c:forEach items="${teachers}" var="teacher">
                                          <option value="${teacher.userid}" ${course.teacherid==teacher.userid?"selected":""}>${teacher.userid}</option>
                                      </c:forEach>
                                  </select>
                              </div>
                          </div>

                          <div class="form-group row">
                              <label for="s3" class="col-sm-2 col-form-label">上课时间</label>
                              <div class="col-sm-10">
                                  <select class="form-control select2" id="s3" name="coursetime">
                                      <option value="周一" ${"周一".equals(course.coursetime)?"selected":""}>周一</option>
                                      <option value="周二" ${"周一".equals(course.coursetime)?"selected":""}>周二</option>
                                      <option value="周三" ${"周一".equals(course.coursetime)?"selected":""}>周三</option>
                                      <option value="周四" ${"周一".equals(course.coursetime)?"selected":""}>周四</option>
                                      <option value="周五" ${"周一".equals(course.coursetime)?"selected":""}>周五</option>
                                      <option value="周六" ${"周一".equals(course.coursetime)?"selected":""}>周六</option>
                                      <option value="周日" ${"周一".equals(course.coursetime)?"selected":""}>周日</option>
                                  </select>
                              </div>
                          </div>

                          <div class="form-group row">
                              <label for="inputPassword3" class="col-sm-2 col-form-label">上课教室</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" id="inputPassword5" placeholder="上课教室" name="classroom" value="${course.classroom}">
                              </div>
                          </div>

                          <div class="form-group row">
                              <label for="inputPassword3" class="col-sm-2 col-form-label">周数</label>
                              <div class="col-sm-10">
                                  <input type="number" min="0" class="form-control" id="inputPassword6" placeholder="周数" name="courseweek" value="${course.courseweek}">
                              </div>
                          </div>

                          <div class="form-group row">
                              <label for="inputPassword3" class="col-sm-2 col-form-label">课程类型</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" id="inputPassword7" placeholder="课程类型" name="coursetype" value="${course.coursetype}">
                              </div>
                          </div>

                          <div class="form-group row">
                              <label for="s1" class="col-sm-2 col-form-label">院系</label>
                              <div class="col-sm-10">
                                  <select class="form-control select2" id="s1" name="collegeid">
                                      <%--                          <option selected="selected">Alabama</option>--%>
                                      <c:forEach items="${colleges}" var="college">
                                          <option value="${college.collegeid}" ${course.collegeid==college.collegeid?"selected":""}>${college.collegename}</option>
                                      </c:forEach>
                                  </select>
                              </div>
                          </div>

                          <div class="form-group row">
                              <label for="inputEmail3" class="col-sm-2 col-form-label">学分</label>
                              <div class="col-sm-10">
                                  <input type="number" min="0" class="form-control" placeholder="学分" name="score" value="${course.score}">
                              </div>
                          </div>



                          <!-- /.card-body -->
                          <div class="card-footer">
                              <button type="submit" class="btn btn-info">Sign in</button>
                          </div>

                      </div>
                      <!-- /.card-footer -->
                  </form>

              </div>
              <!-- /.card -->

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
<!-- Select2 -->
<script src="${pageContext.request.contextPath}/static/alte/plugins/select2/js/select2.full.min.js"></script>
<!-- Bootstrap4 Duallistbox -->
<script src="${pageContext.request.contextPath}/static/alte/plugins/bootstrap4-duallistbox/jquery.bootstrap-duallistbox.min.js"></script>
<!-- InputMask -->
<script src="${pageContext.request.contextPath}/static/alte/plugins/moment/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/static/alte/plugins/inputmask/jquery.inputmask.min.js"></script>
<!-- date-range-picker -->
<script src="${pageContext.request.contextPath}/static/alte/plugins/daterangepicker/daterangepicker.js"></script>
<!-- bootstrap color picker -->
<script src="${pageContext.request.contextPath}/static/alte/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.min.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/static/alte/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Bootstrap Switch -->
<script src="${pageContext.request.contextPath}/static/alte/plugins/bootstrap-switch/js/bootstrap-switch.min.js"></script>
<!-- BS-Stepper -->
<script src="${pageContext.request.contextPath}/static/alte/plugins/bs-stepper/js/bs-stepper.min.js"></script>
<!-- dropzonejs -->
<script src="${pageContext.request.contextPath}/static/alte/plugins/dropzone/min/dropzone.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/static/alte/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/static/alte/dist/js/demo.js"></script>
<!-- Page specific script -->
<script>
  $(function () {
    //Initialize Select2 Elements
    $('.select2').select2()

    //Initialize Select2 Elements
    $('.select2bs4').select2({
      theme: 'bootstrap4'
    })

    //Datemask dd/mm/yyyy
    $('#datemask').inputmask('dd/mm/yyyy', { 'placeholder': 'dd/mm/yyyy' })
    //Datemask2 mm/dd/yyyy
    $('#datemask2').inputmask('mm/dd/yyyy', { 'placeholder': 'mm/dd/yyyy' })
    //Money Euro
    $('[data-mask]').inputmask()

    //Date picker
    $('#reservationdate').datetimepicker({
        format: 'L'
    });

    $('#reservationdate2').datetimepicker({
      format: 'L'
    });

    //Date and time picker
    $('#reservationdatetime').datetimepicker({ icons: { time: 'far fa-clock' } });

    //Date range picker
    $('#reservation').daterangepicker()
    //Date range picker with time picker
    $('#reservationtime').daterangepicker({
      timePicker: true,
      timePickerIncrement: 30,
      locale: {
        format: 'MM/DD/YYYY hh:mm A'
      }
    })
    //Date range as a button
    $('#daterange-btn').daterangepicker(
      {
        ranges   : {
          'Today'       : [moment(), moment()],
          'Yesterday'   : [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
          'Last 7 Days' : [moment().subtract(6, 'days'), moment()],
          'Last 30 Days': [moment().subtract(29, 'days'), moment()],
          'This Month'  : [moment().startOf('month'), moment().endOf('month')],
          'Last Month'  : [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
        },
        startDate: moment().subtract(29, 'days'),
        endDate  : moment()
      },
      function (start, end) {
        $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'))
      }
    )

    //Timepicker
    $('#timepicker').datetimepicker({
      format: 'LT'
    })

    //Bootstrap Duallistbox
    $('.duallistbox').bootstrapDualListbox()

    //Colorpicker
    $('.my-colorpicker1').colorpicker()
    //color picker with addon
    $('.my-colorpicker2').colorpicker()

    $('.my-colorpicker2').on('colorpickerChange', function(event) {
      $('.my-colorpicker2 .fa-square').css('color', event.color.toString());
    })

    $("input[data-bootstrap-switch]").each(function(){
      $(this).bootstrapSwitch('state', $(this).prop('checked'));
    })

  })
  // BS-Stepper Init
  document.addEventListener('DOMContentLoaded', function () {
    window.stepper = new Stepper(document.querySelector('.bs-stepper'))
  })

  // DropzoneJS Demo Code Start
  Dropzone.autoDiscover = false

  // Get the template HTML and remove it from the doumenthe template HTML and remove it from the doument
  var previewNode = document.querySelector("#template")
  previewNode.id = ""
  var previewTemplate = previewNode.parentNode.innerHTML
  previewNode.parentNode.removeChild(previewNode)

  var myDropzone = new Dropzone(document.body, { // Make the whole body a dropzone
    url: "/target-url", // Set the url
    thumbnailWidth: 80,
    thumbnailHeight: 80,
    parallelUploads: 20,
    previewTemplate: previewTemplate,
    autoQueue: false, // Make sure the files aren't queued until manually added
    previewsContainer: "#previews", // Define the container to display the previews
    clickable: ".fileinput-button" // Define the element that should be used as click trigger to select files.
  })

  myDropzone.on("addedfile", function(file) {
    // Hookup the start button
    file.previewElement.querySelector(".start").onclick = function() { myDropzone.enqueueFile(file) }
  })

  // Update the total progress bar
  myDropzone.on("totaluploadprogress", function(progress) {
    document.querySelector("#total-progress .progress-bar").style.width = progress + "%"
  })

  myDropzone.on("sending", function(file) {
    // Show the total progress bar when upload starts
    document.querySelector("#total-progress").style.opacity = "1"
    // And disable the start button
    file.previewElement.querySelector(".start").setAttribute("disabled", "disabled")
  })

  // Hide the total progress bar when nothing's uploading anymore
  myDropzone.on("queuecomplete", function(progress) {
    document.querySelector("#total-progress").style.opacity = "0"
  })

  // Setup the buttons for all transfers
  // The "add files" button doesn't need to be setup because the config
  // `clickable` has already been specified.
  document.querySelector("#actions .start").onclick = function() {
    myDropzone.enqueueFiles(myDropzone.getFilesWithStatus(Dropzone.ADDED))
  }
  document.querySelector("#actions .cancel").onclick = function() {
    myDropzone.removeAllFiles(true)
  }
  // DropzoneJS Demo Code End
</script>
</body>
</html>
