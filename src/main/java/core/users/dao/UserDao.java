package core.users.dao;

import core.users.model.User;

public interface UserDao {

    User findByUserName(String username);

}

