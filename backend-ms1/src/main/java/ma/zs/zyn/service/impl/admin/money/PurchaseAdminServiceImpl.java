package ma.zs.zyn.service.impl.admin.money;


import ma.zs.zyn.zynerator.exception.EntityNotFoundException;
import ma.zs.zyn.bean.core.money.Purchase;
import ma.zs.zyn.dao.criteria.core.money.PurchaseCriteria;
import ma.zs.zyn.dao.facade.core.money.PurchaseDao;
import ma.zs.zyn.dao.specification.core.money.PurchaseSpecification;
import ma.zs.zyn.service.facade.admin.money.PurchaseAdminService;
import ma.zs.zyn.zynerator.service.AbstractServiceImpl;
import static ma.zs.zyn.zynerator.util.ListUtil.*;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import ma.zs.zyn.zynerator.util.RefelexivityUtil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.zyn.service.facade.admin.money.PurchaseItemAdminService ;
import ma.zs.zyn.bean.core.money.PurchaseItem ;
import ma.zs.zyn.service.facade.admin.crm.ClientAdminService ;
import ma.zs.zyn.bean.core.crm.Client ;

import java.util.List;
@Service
public class PurchaseAdminServiceImpl implements PurchaseAdminService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Purchase update(Purchase t) {
        Purchase loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{Purchase.class.getSimpleName(), t.getId().toString()});
        } else {
            updateWithAssociatedLists(t);
            dao.save(t);
            return loadedItem;
        }
    }

    public Purchase findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public Purchase findOrSave(Purchase t) {
        if (t != null) {
            findOrSaveAssociatedObject(t);
            Purchase result = findByReferenceEntity(t);
            if (result == null) {
                return dao.save(t);
            } else {
                return result;
            }
        }
        return null;
    }

    public List<Purchase> findAll() {
        return dao.findAll();
    }

    public List<Purchase> findByCriteria(PurchaseCriteria criteria) {
        List<Purchase> content = null;
        if (criteria != null) {
            PurchaseSpecification mySpecification = constructSpecification(criteria);
            if (criteria.isPeagable()) {
                Pageable pageable = PageRequest.of(0, criteria.getMaxResults());
                content = dao.findAll(mySpecification, pageable).getContent();
            } else {
                content = dao.findAll(mySpecification);
            }
        } else {
            content = dao.findAll();
        }
        return content;

    }


    private PurchaseSpecification constructSpecification(PurchaseCriteria criteria) {
        PurchaseSpecification mySpecification =  (PurchaseSpecification) RefelexivityUtil.constructObjectUsingOneParam(PurchaseSpecification.class, criteria);
        return mySpecification;
    }

    public List<Purchase> findPaginatedByCriteria(PurchaseCriteria criteria, int page, int pageSize, String order, String sortField) {
        PurchaseSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(PurchaseCriteria criteria) {
        PurchaseSpecification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }

    public List<Purchase> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }
    public long countByClientId(Long id){
        return dao.countByClientId(id);
    }
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
	public boolean deleteById(Long id) {
        boolean condition = (id != null);
        if (condition) {
            deleteAssociatedLists(id);
            dao.deleteById(id);
        }
        return condition;
    }

    public void deleteAssociatedLists(Long id) {
        purchaseItemService.deleteByPurchaseId(id);
    }




    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Purchase> delete(List<Purchase> list) {
		List<Purchase> result = new ArrayList();
        if (list != null) {
            for (Purchase t : list) {
                if(dao.findById(t.getId()).isEmpty()){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Purchase create(Purchase t) {
        Purchase loaded = findByReferenceEntity(t);
        Purchase saved;
        if (loaded == null) {
            saved = dao.save(t);
            if (t.getPurchaseItems() != null) {
                t.getPurchaseItems().forEach(element-> {
                    element.setPurchase(saved);
                    purchaseItemService.create(element);
                });
            }
        }else {
            saved = null;
        }
        return saved;
    }

    public Purchase findWithAssociatedLists(Long id){
        Purchase result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setPurchaseItems(purchaseItemService.findByPurchaseId(id));
        }
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Purchase> update(List<Purchase> ts, boolean createIfNotExist) {
        List<Purchase> result = new ArrayList<>();
        if (ts != null) {
            for (Purchase t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    Purchase loadedItem = dao.findById(t.getId()).orElse(null);
                    if (isEligibleForCreateOrUpdate(createIfNotExist, t, loadedItem)) {
                        dao.save(t);
                    } else {
                        result.add(t);
                    }
                }
            }
        }
        return result;
    }


    private boolean isEligibleForCreateOrUpdate(boolean createIfNotExist, Purchase t, Purchase loadedItem) {
        boolean eligibleForCreateCrud = t.getId() == null;
        boolean eligibleForCreate = (createIfNotExist && (t.getId() == null || loadedItem == null));
        boolean eligibleForUpdate = (t.getId() != null && loadedItem != null);
        return (eligibleForCreateCrud || eligibleForCreate || eligibleForUpdate);
    }

    public void updateWithAssociatedLists(Purchase purchase){
    if(purchase !=null && purchase.getId() != null){
        List<List<PurchaseItem>> resultPurchaseItems= purchaseItemService.getToBeSavedAndToBeDeleted(purchaseItemService.findByPurchaseId(purchase.getId()),purchase.getPurchaseItems());
            purchaseItemService.delete(resultPurchaseItems.get(1));
        emptyIfNull(resultPurchaseItems.get(0)).forEach(e -> e.setPurchase(purchase));
        purchaseItemService.update(resultPurchaseItems.get(0),true);
        }
    }








    public Purchase findByReferenceEntity(Purchase t){
        return t==null? null : dao.findByReference(t.getReference());
    }
    public void findOrSaveAssociatedObject(Purchase t){
        if( t != null) {
            t.setClient(clientService.findOrSave(t.getClient()));
        }
    }



    public List<Purchase> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<Purchase>> getToBeSavedAndToBeDeleted(List<Purchase> oldList, List<Purchase> newList) {
        List<List<Purchase>> result = new ArrayList<>();
        List<Purchase> resultDelete = new ArrayList<>();
        List<Purchase> resultUpdateOrSave = new ArrayList<>();
        if (isEmpty(oldList) && isNotEmpty(newList)) {
            resultUpdateOrSave.addAll(newList);
        } else if (isEmpty(newList) && isNotEmpty(oldList)) {
            resultDelete.addAll(oldList);
        } else if (isNotEmpty(newList) && isNotEmpty(oldList)) {
			extractToBeSaveOrDelete(oldList, newList, resultUpdateOrSave, resultDelete);
        }
        result.add(resultUpdateOrSave);
        result.add(resultDelete);
        return result;
    }

    private void extractToBeSaveOrDelete(List<Purchase> oldList, List<Purchase> newList, List<Purchase> resultUpdateOrSave, List<Purchase> resultDelete) {
		for (int i = 0; i < oldList.size(); i++) {
                Purchase myOld = oldList.get(i);
                Purchase t = newList.stream().filter(e -> myOld.equals(e)).findFirst().orElse(null);
                if (t != null) {
                    resultUpdateOrSave.add(t); // update
                } else {
                    resultDelete.add(myOld);
                }
            }
            for (int i = 0; i < newList.size(); i++) {
                Purchase myNew = newList.get(i);
                Purchase t = oldList.stream().filter(e -> myNew.equals(e)).findFirst().orElse(null);
                if (t == null) {
                    resultUpdateOrSave.add(myNew); // create
                }
            }
	}

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }







    @Autowired
    private PurchaseItemAdminService purchaseItemService ;
    @Autowired
    private ClientAdminService clientService ;

    public PurchaseAdminServiceImpl(PurchaseDao dao) {
        this.dao = dao;
    }

    private PurchaseDao dao;
}
