package vn.t3h.t3h_2202.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseListDto {
    Integer page;
    Integer perpage;
    List<UserDto> data;
    long total;
    long numberPage;

}
