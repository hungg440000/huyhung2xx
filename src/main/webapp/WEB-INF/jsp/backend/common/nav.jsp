<%@page pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" aria-label="Ninth navbar example">
    <div class="container-xl">
        <a class="navbar-brand" href="#">Trang chủ</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample07XL" aria-controls="navbarsExample07XL" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsExample07XL">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="#">Link</a>--%>
<%--                </li>--%>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown07XL" data-bs-toggle="dropdown" aria-expanded="false">Tài khoản</a>
                    <ul class="dropdown-menu" aria-labelledby="dropdown07XL">
                        <li><a class="dropdown-item" href="/backend/user/create">Tạo mới</a></li>
                        <li><a class="dropdown-item" href="/backend/user/list">Danh sách</a></li>
                    </ul>
                </li>
            </ul>
            <form>
                <input class="form-control" type="text" placeholder="Search" aria-label="Tìm kiếm">
            </form>
        </div>
    </div>
</nav>
