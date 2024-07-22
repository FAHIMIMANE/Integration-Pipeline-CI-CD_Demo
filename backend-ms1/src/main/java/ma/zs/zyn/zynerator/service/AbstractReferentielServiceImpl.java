package ma.zs.zyn.zynerator.service;

import ma.zs.zyn.zynerator.bean.BaseEntity;
import ma.zs.zyn.zynerator.criteria.BaseCriteria;
import ma.zs.zyn.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends BaseEntity, CRITERIA extends BaseCriteria, REPO extends AbstractRepository<T, Long>> extends AbstractServiceImpl<T, CRITERIA, REPO> {

    public AbstractReferentielServiceImpl(REPO dao) {
        super(dao);
    }

}
