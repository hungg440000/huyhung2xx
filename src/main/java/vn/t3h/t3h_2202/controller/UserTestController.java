package vn.t3h.t3h_2202.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.t3h.t3h_2202.dto.UserDto;
import vn.t3h.t3h_2202.util.DBUtils;

import java.sql.SQLException;
import java.util.List;

@Controller
public class UserTestController {
    // Thông tin user :username(suy nhất) giới tính (chọn nam hoặc nữ), trạng thái(1: kích hoặt, 0 tạm dừng), role(Quyền chọn CUSTOMER, ADMIN), address (địa chỉ), số điện thoại, email
       // màn hình hiển thị chi user khi người dùng request id lên
       // Màn hình cập nhật user
//       Màn hình danh sách user có phân trang
    @GetMapping("user/create")
    public String loadPage() {
        return "user/create";
    }

    @GetMapping("user/list")
    public String loadPageList(Model model) throws SQLException {
        List<UserDto> userDtoList = DBUtils.danhSachUser(null, 1, 1000);
        model.addAttribute("danhsach", userDtoList);
        return "user/list";
    }

    @PostMapping("user/create")
    @ResponseBody
    public UserDto createUser(@RequestBody UserDto userDto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO USER (USER_NAME, PASSWORD, FULL_NAME) VALUES ('");
        sql.append(userDto.getUserName()).append("','");
        sql.append(userDto.getPassword()).append("','");
        sql.append(userDto.getFullName()).append("')");
        DBUtils.create(sql.toString());
        return userDto;
    }

    @PostMapping(value = "user/create-form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createUser1(UserDto userDto, Model model) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO USER (USER_NAME, PASSWORD, FULL_NAME) VALUES ('");
        sql.append(userDto.getUserName()).append("','");
        sql.append(userDto.getPassword()).append("','");
        sql.append(userDto.getFullName()).append("')");
        DBUtils.create(sql.toString());
        model.addAttribute("message", "Tạo mới tài khoản " + userDto.getFullName() + " thành công!");
        return "user/create";
    }

    @GetMapping("user/listjson")
    @ResponseBody
    public List<UserDto> layDanhsachUser(
            @RequestParam(required = false) String key,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "3") Integer perpage) throws SQLException {
        return DBUtils.danhSachUser(key, page, perpage);
    }
}
