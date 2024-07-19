package ma.zs.stocky.zynerator.security.service.facade;

import ma.zs.stocky.zynerator.security.bean.ActionPermission;
import ma.zs.stocky.zynerator.security.dao.criteria.core.ActionPermissionCriteria;
import ma.zs.stocky.zynerator.service.IService;
import java.util.List;


public interface ActionPermissionService extends  IService<ActionPermission,ActionPermissionCriteria>  {

    List<ActionPermission> findAllOptimized();

}
