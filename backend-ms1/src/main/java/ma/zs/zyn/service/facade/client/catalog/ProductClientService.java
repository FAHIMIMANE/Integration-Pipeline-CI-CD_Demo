package ma.zs.zyn.service.facade.client.catalog;

import java.util.List;
import ma.zs.zyn.bean.core.catalog.Product;
import ma.zs.zyn.dao.criteria.core.catalog.ProductCriteria;
import ma.zs.zyn.zynerator.service.IService;



public interface ProductClientService {







	Product create(Product t);

    Product update(Product t);

    List<Product> update(List<Product> ts,boolean createIfNotExist);

    Product findById(Long id);

    Product findOrSave(Product t);

    Product findByReferenceEntity(Product t);

    Product findWithAssociatedLists(Long id);

    List<Product> findAllOptimized();

    List<Product> findAll();

    List<Product> findByCriteria(ProductCriteria criteria);

    List<Product> findPaginatedByCriteria(ProductCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(ProductCriteria criteria);

    List<Product> delete(List<Product> ts);

    boolean deleteById(Long id);

    List<List<Product>> getToBeSavedAndToBeDeleted(List<Product> oldList, List<Product> newList);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

}
