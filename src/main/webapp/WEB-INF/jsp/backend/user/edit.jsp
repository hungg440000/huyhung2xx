<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" %>
<jsp:include page="/WEB-INF/jsp/backend/common/head.jsp"></jsp:include>
<body>
<jsp:include page="/WEB-INF/jsp/backend/common/nav.jsp"></jsp:include>
<div class="container">
    <div>
        <div class="bg-light p-5 rounded">
            <div class="col-sm-8 mx-auto">
                <h1>Cập nhật tài khoản</h1>
                <p style="color: red">${message}</p>
                <form action="/backend/user/edit-form" method="post">
                    <div class="row">
                        <input name="id" value="${user.id}" hidden>
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Tên đăng nhập</label>
                                <input type="text" name="userName" value="${user.userName}" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Họ và tên</label>
                                <input type="text" name="fullName" value="${user.fullName}" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Email</label>
                                <input type="email" name="email" value="${user.email}" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Số điện thoại</label>
                                <input type="text" name="phone" value="${user.phone}" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Giới tính</label>
                                <select name="gender" class="form-select" aria-label="Default select example">
                                    <option <c:if  test="${user.gender == 1}">selected</c:if> value="1">Name</option>
                                    <option <c:if  test="${user.gender == 2}">selected</c:if> value="2">Nữ</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Trạng thái</label>
                                <select name="status" class="form-select" aria-label="Default select example">
                                    <option <c:if  test="${user.status == 0}">selected</c:if> value="0">Tạm dừng</option>
                                    <option <c:if  test="${user.status == 1}">selected</c:if> value="1">Kích hoạt</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Quyền</label>
                                <select name="role" class="form-select" aria-label="Default select example">
                                    <option <c:if  test="${user.role == 'CUSTOMER'}">selected</c:if> value="CUSTOMER">CUSTOMER</option>
                                    <option <c:if  test="${user.role == 'ADMIN'}">selected</c:if> value="ADMIN">ADMIN</option>
                                </select>
                            </div>
                        </div>

                    </div>

                    <button type="submit" class="btn btn-primary">Tạo mới</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
