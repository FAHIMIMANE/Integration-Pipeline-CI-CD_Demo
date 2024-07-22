package ma.zs.zyn.zynerator.security.service.facade;

import ma.zs.zyn.zynerator.security.bean.ActionPermission;
import ma.zs.zyn.zynerator.security.dao.criteria.core.ActionPermissionCriteria;
import ma.zs.zyn.zynerator.service.IService;
import java.util.List;


public interface ActionPermissionService extends  IService<ActionPermission,ActionPermissionCriteria>  {

    List<ActionPermission> findAllOptimized();

}
