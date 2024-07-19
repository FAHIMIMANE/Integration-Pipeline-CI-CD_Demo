package ma.zs.stocky.zynerator.security.dao.facade.core;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.zynerator.security.bean.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserDao extends AbstractRepository<User,Long>  {
    User findByEmail(String email);
    User findByLinkValidationCode(String linkValidationCode);
    int deleteByEmail(String email);
    User findByUsername(String username);
    int deleteByUsername(String username);


    @Query("SELECT NEW User(item.id,item.email) FROM User item")
    List<User> findAllOptimized();

}
