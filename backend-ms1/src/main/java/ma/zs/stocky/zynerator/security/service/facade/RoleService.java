package ma.zs.stocky.zynerator.security.service.facade;

import ma.zs.stocky.zynerator.security.bean.Role;
import ma.zs.stocky.zynerator.security.dao.criteria.core.RoleCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface RoleService extends  IService<Role,RoleCriteria>  {
    Role findByAuthority(String authority);
    int deleteByAuthority(String authority);


    



}
