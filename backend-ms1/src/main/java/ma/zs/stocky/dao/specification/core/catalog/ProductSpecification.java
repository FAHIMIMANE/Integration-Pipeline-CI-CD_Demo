package  ma.zs.stocky.dao.specification.core.catalog;

import ma.zs.stocky.dao.criteria.core.catalog.ProductCriteria;
import ma.zs.stocky.bean.core.catalog.Product;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class ProductSpecification extends  AbstractSpecification<ProductCriteria, Product>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
    }

    public ProductSpecification(ProductCriteria criteria) {
        super(criteria);
    }

    public ProductSpecification(ProductCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
