package vn.t3h.t3h_2202.util;

import org.springframework.util.StringUtils;
import vn.t3h.t3h_2202.dto.UserDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    static String DB_INFO = "jdbc:mysql://localhost:3306/hung";
    static String USER_NAME = "root";
    static String PASS = "1234";

    public static void create(String sql) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_INFO, USER_NAME, PASS);
        Statement sqlFile = conn.createStatement();
        try {
            System.out.println("SQL: " + sql);
            sqlFile.executeUpdate(sql);

        } finally {
            // Bước 4 đóng kết nối
            sqlFile.close();
            conn.close();
        }
    }

    public static List<UserDto> danhSachUser(String key, int page, int perpage) throws SQLException {
        List<UserDto> userDtoList = new ArrayList<>();
        Connection conn = DriverManager.getConnection(DB_INFO, USER_NAME, PASS);
        Statement sqlFile = conn.createStatement();
        try {
            StringBuilder sql = new StringBuilder("SELECT u.* FROM USER u WHERE 1=1 ");
            if (!StringUtils.isEmpty(key))
                sql.append(" u.USER_NAME LIKE '%")
                    .append(key).append( "%' OR u.FULL_NAME LIKE '%" )
                    .append(key).append("%'");
            sql.append(" LIMIT ").append(perpage).append(" OFFSET ").append((page - 1) * perpage);

            ResultSet resultSet = sqlFile.executeQuery(sql.toString());
            while (resultSet != null && resultSet.next()) {
                Long id = resultSet.getLong(1);
                String userName = resultSet.getString(2);
                String fullName = resultSet.getString(4);
                String email = resultSet.getString(5);
                String phone = resultSet.getString(6);
                Integer gender = resultSet.getInt(7);
                Integer status = resultSet.getInt(8);
                String role = resultSet.getString(9);

                userDtoList.add(new UserDto(id, userName, null, fullName, null, email, phone, gender, status, role));
            }

        } finally {
            // Bước 4 đóng kết nối
            sqlFile.close();
            conn.close();
        }
        return userDtoList;
    }

    public static long countUser(String key) throws SQLException {
        List<UserDto> userDtoList = new ArrayList<>();
        Connection conn = DriverManager.getConnection(DB_INFO, USER_NAME, PASS);
        Statement sqlFile = conn.createStatement();
        try {
            StringBuilder sql = new StringBuilder("SELECT count(u.id) FROM USER u WHERE 1=1 ");
            if (!StringUtils.isEmpty(key))
                sql.append(" u.USER_NAME LIKE '%")
                        .append(key).append( "%' OR u.FULL_NAME LIKE '%" )
                        .append(key).append("%'");

            ResultSet resultSet = sqlFile.executeQuery(sql.toString());
            while (resultSet != null && resultSet.next()) {
                Long count = resultSet.getLong(1);
                return count;

            }

        } finally {
            // Bước 4 đóng kết nối
            sqlFile.close();
            conn.close();
        }
        return 0L;
    }


    public static UserDto detail(Long id) throws SQLException {
        List<UserDto> userDtoList = new ArrayList<>();
        Connection conn = DriverManager.getConnection(DB_INFO, USER_NAME, PASS);
        Statement sqlFile = conn.createStatement();
        try {
            StringBuilder sql = new StringBuilder("SELECT u.* FROM USER u WHERE id =  ");
            sql.append(id);

            ResultSet resultSet = sqlFile.executeQuery(sql.toString());
            while (resultSet != null && resultSet.next()) {
                String userName = resultSet.getString(2);
                String fullName = resultSet.getString(4);
                String email = resultSet.getString(5);
                String phone = resultSet.getString(6);
                Integer gender = resultSet.getInt(7);
                Integer status = resultSet.getInt(8);
                String role = resultSet.getString(9);

                userDtoList.add(new UserDto(id, userName, null, fullName, null, email, phone, gender, status, role));
            }

        } finally {
            // Bước 4 đóng kết nối
            sqlFile.close();
            conn.close();
        }
        return userDtoList.get(0);
    }
}
