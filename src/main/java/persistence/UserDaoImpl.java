package persistence;


import core.dao.UserDao;
import core.entity.Users;
import org.hibernate.Query;


/**
 * Created by Oleg on 27.10.2015.
 */
public class UserDaoImpl extends BaseDaoImpl<Users> implements UserDao {


    @Override
    public Users getUserByName(String username) {
        Query query = startSession().createQuery("FROM users WHERE  username LIKE :username");
        query.setParameter("username", username);
        return (Users) query.uniqueResult();
    }

}
