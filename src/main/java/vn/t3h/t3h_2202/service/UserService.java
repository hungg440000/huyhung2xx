package vn.t3h.t3h_2202.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import vn.t3h.t3h_2202.dto.ResponseListDto;
import vn.t3h.t3h_2202.dto.UserDto;
import vn.t3h.t3h_2202.util.DBUtils;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service// tạo ra 1 object được lưu trong spring bean
public class UserService {



    public UserDto saveUser(UserDto userDto) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO USER (USER_NAME, PASSWORD, FULL_NAME, EMAIL, PHONE, GENDER, STATUS, ROLE) VALUES ('");
        sql.append(userDto.getUserName()).append("','");
        sql.append(userDto.getPassword()).append("','");
        sql.append(userDto.getFullName()).append("','");
        sql.append(userDto.getEmail()).append("','");
        sql.append(userDto.getPhone()).append("',");
        sql.append(userDto.getGender()).append(",");
        sql.append(userDto.getStatus()).append(",'");
        sql.append(userDto.getRole()).append("')");
        try {
            DBUtils.create(sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDto;
    }

    public UserDto editUser(UserDto userDto) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE USER SET ");
        sql.append("USER_NAME='").append(userDto.getUserName()).append("',");
        sql.append("FULL_NAME='").append(userDto.getFullName()).append("',");
        sql.append("EMAIL='").append(userDto.getEmail()).append("',");
        sql.append("PHONE='").append(userDto.getPhone()).append("',");
        sql.append("GENDER=").append(userDto.getGender()).append(",");
        sql.append("STATUS=").append(userDto.getStatus()).append(",");
        sql.append("ROLE='").append(userDto.getRole()).append("'");
        sql.append(" WHERE ID =").append(userDto.getId());
        try {
            DBUtils.create(sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDto;
    }

    public UserDto detail(long id) {
        try {
            return DBUtils.detail(id);
        } catch (SQLException e) {
            return new UserDto();
        }
    }

    public ResponseListDto danhsach(Integer page, Integer perpage, String key) throws SQLException {
        List<UserDto> data = DBUtils.danhSachUser(key, page, perpage);
        Long total = DBUtils.countUser(key);
        ResponseListDto dto = new ResponseListDto();
        dto.setData(data);
        dto.setPage(page);
        dto.setPerpage(perpage);
        dto.setTotal(total);
        dto.setNumberPage((total % perpage == 0) ? (total/perpage) : (total/perpage + 1));
        return dto;
    }
}
