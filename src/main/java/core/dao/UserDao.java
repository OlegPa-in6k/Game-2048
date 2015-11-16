package core.dao;

import core.entity.Users;

/**
 * Created by employee on 11/16/15.
 */
public interface UserDao extends BaseDao<Users> {
    Users getUserByName(String username);

}
