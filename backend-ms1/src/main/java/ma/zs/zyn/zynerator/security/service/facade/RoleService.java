package ma.zs.zyn.zynerator.security.service.facade;

import ma.zs.zyn.zynerator.security.bean.Role;
import ma.zs.zyn.zynerator.security.dao.criteria.core.RoleCriteria;
import ma.zs.zyn.zynerator.service.IService;



public interface RoleService extends  IService<Role,RoleCriteria>  {
    Role findByAuthority(String authority);
    int deleteByAuthority(String authority);


    



}
