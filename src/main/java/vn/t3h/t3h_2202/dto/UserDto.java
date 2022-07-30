package vn.t3h.t3h_2202.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String userName;
    private String password;
    private String fullName;
    private String rePassword;
    private String email;
    private String phone;
    private Integer gender;
    private Integer status;
    private String role;
}
