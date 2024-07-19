package ma.zs.stocky.zynerator.security.service.facade;

import ma.zs.stocky.zynerator.security.bean.ModelPermission;
import ma.zs.stocky.zynerator.security.dao.criteria.core.ModelPermissionCriteria;
import ma.zs.stocky.zynerator.service.IService;
import java.util.List;



public interface ModelPermissionService extends  IService<ModelPermission,ModelPermissionCriteria>  {
    List<ModelPermission> findAllOptimized();

}
