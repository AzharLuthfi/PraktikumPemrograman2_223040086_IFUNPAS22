package model;

import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> getAllUsers();

    @Insert("INSERT INTO users (name, email) VALUES (#{name}, #{email})")
    void insertUser(User user);
    
    @Update("UPDATE users SET name = #{name} WHERE email = #{email}")
    void updateUser(User user);

    @Delete("DELETE FROM users WHERE email = #{email}")
    void deleteUser(String email);
}
