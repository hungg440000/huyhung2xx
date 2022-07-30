<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/backend/common/head.jsp"></jsp:include>
<body>
<jsp:include page="/WEB-INF/jsp/backend/common/nav.jsp"></jsp:include>
<div class="container">
    <div>
        <div class="bg-light p-5 rounded">
            <div class="col-sm-8 mx-auto">
                <h1>Danh sách tài khoản</h1>
                <p style="color: red">${message}</p>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Tên đăng nhập</th>
                        <th scope="col">Họ và tên</th>
                        <th scope="col">Giới tính</th>
                        <th scope="col">Trạng thái</th>
                        <th scope="col">Quyền</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="stt" value="1"></c:set>
                    <c:forEach items="${list.data}" var="user">
                        <tr>
                            <th scope="row">${stt}</th>
                            <td><a href="/backend/user/edit/${user.id}">${user.userName}</a></td>
                            <td>${user.fullName}</td>
                            <td><c:if test="${user.gender == 1}">Nam</c:if>
                                <c:if test="${user.gender == 2}">Nữ</c:if></td>
                            <td><c:if test="${user.status == 1}">Kích hoạt</c:if>
                                <c:if test="${user.gender == 0}">Tạm dừng</c:if></td>
                            <td>${user.role}</td>
                            <c:set var="stt" value="${stt + 1}"></c:set>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>

            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item <c:if test="${list.page == 1}">disabled</c:if>">
                        <a class="page-link" href="/backend/user/list?page=${list.page - 1}&perpage=${list.perpage}">Trước</a></li>
                    <c:forEach begin="1" step="1" end="${list.numberPage}" var="num">
                        <li class="page-item <c:if test="${list.page == num}">active</c:if>">
                            <a class="page-link " href="/backend/user/list?page=${num}&perpage=${list.perpage}">${num}
                            </a>
                        </li>
                    </c:forEach>
                    <li class="page-item <c:if test="${list.page == list.numberPage}">disabled</c:if>">
                        <a class="page-link" href="/backend/user/list?page=${list.page + 1}&perpage=${list.perpage}">Sau</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>

