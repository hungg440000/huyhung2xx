package vn.t3h.t3h_2202.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.t3h.t3h_2202.dto.UserDto;
import vn.t3h.t3h_2202.service.UserService;
import vn.t3h.t3h_2202.util.DBUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("backend/user")
public class BackendUserController {

    @Autowired
    UserService userService;

    @GetMapping("create")
    public String loadPageCreate(Model model) {
//        model.addAttribute()
        return "backend/user/create";
    }

    @GetMapping("list")
    public String loadPageList(Model model, @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "5") Integer perpage, @RequestParam(required = false) String key) throws SQLException {
        model.addAttribute("list", userService.danhsach(page, perpage, key));
        return "backend/user/list";
    }

    @PostMapping("create")
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

    @PostMapping(value = "create-form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createUserForm(UserDto userDto, RedirectAttributes redirectAttributes,
                                 HttpServletResponse response, HttpServletRequest request) throws SQLException {
        userService.saveUser(userDto);
//        request.setAttribute();
        redirectAttributes.addFlashAttribute("message", "Tạo mới tài khoản " + userDto.getFullName() + " thành công!");
//        response.sendRedirect("/backend/user/create");
        return "redirect:/backend/user/create";
    }

    @GetMapping("listjson")
    @ResponseBody
    public List<UserDto> layDanhsachUser(
            @RequestParam(required = false) String key,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "3") Integer perpage,
            HttpServletRequest request) throws SQLException {
        request.getParameter("key").toString();
        return DBUtils.danhSachUser(key, page, perpage);
    }

    @GetMapping("edit/{id}")
    public String loadPageEdit(Model model, @PathVariable Long id) {
        model.addAttribute("user", userService.detail(id));
        return "backend/user/edit";
    }

    @PostMapping(value = "edit-form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String editUserForm(UserDto userDto, RedirectAttributes redirectAttributes,
                                 HttpServletResponse response, HttpServletRequest request) throws SQLException {
        userService.editUser(userDto);
//        request.setAttribute();
        redirectAttributes.addFlashAttribute("message", "Cập nhật tài khoản " + userDto.getFullName() + " thành công!");
//        response.sendRedirect("/backend/user/create");
        return "redirect:/backend/user/list";
    }

}
