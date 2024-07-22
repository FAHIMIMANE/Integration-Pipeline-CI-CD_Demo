package ma.zs.zyn.zynerator.security.service.facade;

import ma.zs.zyn.zynerator.security.bean.ModelPermission;
import ma.zs.zyn.zynerator.security.dao.criteria.core.ModelPermissionCriteria;
import ma.zs.zyn.zynerator.service.IService;
import java.util.List;



public interface ModelPermissionService extends  IService<ModelPermission,ModelPermissionCriteria>  {
    List<ModelPermission> findAllOptimized();

}
