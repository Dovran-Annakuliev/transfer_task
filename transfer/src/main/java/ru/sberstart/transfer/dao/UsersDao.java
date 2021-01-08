package ru.sberstart.transfer.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Service;
import ru.sberstart.transfer.model.User;

import java.util.List;

@Service
public class UsersDao {
    private final JdbcOperations jdbcOperations;

    public UsersDao(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public List<User> getUsers() {
        return jdbcOperations.query("select id, name, middlename, surname from users", (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setMiddleName(rs.getString("middlename"));
            user.setSurname(rs.getString("surname"));
            return user;
        });
    }
}
