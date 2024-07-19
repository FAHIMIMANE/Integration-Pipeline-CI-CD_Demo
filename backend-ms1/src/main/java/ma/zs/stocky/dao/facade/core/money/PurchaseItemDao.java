package ma.zs.stocky.dao.facade.core.money;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.money.PurchaseItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PurchaseItemDao extends AbstractRepository<PurchaseItem,Long>  {

    List<PurchaseItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    long countByProductCode(String code);
    List<PurchaseItem> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);
    long countByPurchaseReference(String reference);


}
