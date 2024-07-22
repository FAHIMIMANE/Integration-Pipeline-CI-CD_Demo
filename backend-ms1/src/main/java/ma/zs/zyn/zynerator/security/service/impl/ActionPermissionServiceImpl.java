package ma.zs.zyn.zynerator.security.service.impl;


import ma.zs.zyn.zynerator.security.bean.ActionPermission;
import ma.zs.zyn.zynerator.security.dao.criteria.core.ActionPermissionCriteria;
import ma.zs.zyn.zynerator.security.dao.facade.core.ActionPermissionDao;
import ma.zs.zyn.zynerator.security.dao.specification.core.ActionPermissionSpecification;
import ma.zs.zyn.zynerator.security.service.facade.ActionPermissionService;
import ma.zs.zyn.zynerator.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionPermissionServiceImpl extends AbstractServiceImpl<ActionPermission, ActionPermissionCriteria, ActionPermissionDao> implements ActionPermissionService {





    public ActionPermission findByReferenceEntity(ActionPermission t){
        return  dao.findByReference(t.getReference());
    }


    public List<ActionPermission> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(ActionPermission.class, ActionPermissionSpecification.class);
    }



    public ActionPermissionServiceImpl(ActionPermissionDao dao) {
        super(dao);
    }

}
