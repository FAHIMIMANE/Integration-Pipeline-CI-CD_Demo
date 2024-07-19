package ma.zs.stocky.service.facade.admin.catalog;

import java.util.List;
import ma.zs.stocky.bean.core.catalog.Product;
import ma.zs.stocky.dao.criteria.core.catalog.ProductCriteria;
import ma.zs.stocky.zynerator.service.IService;



public interface ProductAdminService {







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
