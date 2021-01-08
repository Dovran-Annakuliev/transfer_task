package ru.sberstart.transfer.service;

import org.springframework.stereotype.Service;
import ru.sberstart.transfer.dao.UsersDao;
import ru.sberstart.transfer.model.User;

import java.util.List;

@Service
public class UsersService {
    private final UsersDao usersDao;

    public UsersService(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public List<User> getUsers() {
        return usersDao.getUsers();
    }
}
