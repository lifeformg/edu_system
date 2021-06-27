<%--
  Created by IntelliJ IDEA.
  User: 29254
  Date: 2021/6/25
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- 分页器 -->
<div class="row ml-1" >
    <div class="col-sm-12 col-md-7">
        <div class="dataTables_paginate paging_simple_numbers" id="example1_paginate">
            <ul class="pagination">

                <li class="paginate_button page-item previous"
                    id="example1_previous">
                    <a href="${pageContext.request.contextPath}${page.jumpLink}&page=${page.pageNow-1}"
                       data-dt-idx="${page.pageNow+1}" tabindex="0"
                       class="page-link">Previous</a>

                </li>
                <c:forEach begin="1" end="${page.pageTotal}" var="index">

                    <c:if test="${index != page.pageNow}">
                        <li class="paginate_button page-item">
                            <a href="${pageContext.request.contextPath}${page.jumpLink}&page=${index}"
                               aria-controls="example1"
                               data-dt-idx="${index}" tabindex="0"
                               class="page-link">${index}</a>
                        </li>
                    </c:if>
                    <c:if test="${index == page.pageNow}">
                        <li class="paginate_button page-item active">
                            <a href="${pageContext.request.contextPath}${page.jumpLink}&page=${index}"
                               aria-controls="example1"
                               data-dt-idx="${index}" tabindex="0"
                               class="page-link">${index}</a>
                        </li>
                    </c:if>

                </c:forEach>


                <li class="paginate_button page-item next" id="example1_next">
                    <a href="${pageContext.request.contextPath}${page.jumpLink}&page=${page.pageNow+1}"
                       aria-controls="example1"
                       data-dt-idx="${page.pageNow+1}"
                       tabindex="0"
                       class="page-link">Next</a>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
