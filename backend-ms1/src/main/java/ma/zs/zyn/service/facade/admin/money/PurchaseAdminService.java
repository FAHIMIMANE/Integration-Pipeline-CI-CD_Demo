package ma.zs.zyn.service.facade.admin.money;

import java.util.List;
import ma.zs.zyn.bean.core.money.Purchase;
import ma.zs.zyn.dao.criteria.core.money.PurchaseCriteria;
import ma.zs.zyn.zynerator.service.IService;



public interface PurchaseAdminService {



    List<Purchase> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientId(Long id);




	Purchase create(Purchase t);

    Purchase update(Purchase t);

    List<Purchase> update(List<Purchase> ts,boolean createIfNotExist);

    Purchase findById(Long id);

    Purchase findOrSave(Purchase t);

    Purchase findByReferenceEntity(Purchase t);

    Purchase findWithAssociatedLists(Long id);

    List<Purchase> findAllOptimized();

    List<Purchase> findAll();

    List<Purchase> findByCriteria(PurchaseCriteria criteria);

    List<Purchase> findPaginatedByCriteria(PurchaseCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(PurchaseCriteria criteria);

    List<Purchase> delete(List<Purchase> ts);

    boolean deleteById(Long id);

    List<List<Purchase>> getToBeSavedAndToBeDeleted(List<Purchase> oldList, List<Purchase> newList);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

}
