package  ma.zs.zyn.ws.converter.money;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.zyn.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;

import ma.zs.zyn.ws.converter.money.PurchaseConverter;
import ma.zs.zyn.bean.core.money.Purchase;
import ma.zs.zyn.ws.converter.catalog.ProductConverter;
import ma.zs.zyn.bean.core.catalog.Product;

import ma.zs.zyn.bean.core.money.Purchase;


import ma.zs.zyn.zynerator.util.StringUtil;
import ma.zs.zyn.zynerator.converter.AbstractConverter;
import ma.zs.zyn.zynerator.util.DateUtil;
import ma.zs.zyn.bean.core.money.PurchaseItem;
import ma.zs.zyn.ws.dto.money.PurchaseItemDto;

@Component
public class PurchaseItemConverter {

    @Autowired
    private PurchaseConverter purchaseConverter ;
    @Autowired
    private ProductConverter productConverter ;
    private boolean product;
    private boolean purchase;

    public  PurchaseItemConverter() {
        initObject(true);
    }

    public PurchaseItem toItem(PurchaseItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        PurchaseItem item = new PurchaseItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getPrice()))
                item.setPrice(dto.getPrice());
            if(StringUtil.isNotEmpty(dto.getQuantity()))
                item.setQuantity(dto.getQuantity());
            if(this.product && dto.getProduct()!=null)
                item.setProduct(productConverter.toItem(dto.getProduct())) ;

            if(dto.getPurchase() != null && dto.getPurchase().getId() != null){
                item.setPurchase(new Purchase());
                item.getPurchase().setId(dto.getPurchase().getId());
                item.getPurchase().setReference(dto.getPurchase().getReference());
            }




        return item;
        }
    }


    public PurchaseItemDto toDto(PurchaseItem item) {
        if (item == null) {
            return null;
        } else {
            PurchaseItemDto dto = new PurchaseItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getPrice()))
                dto.setPrice(item.getPrice());
            if(StringUtil.isNotEmpty(item.getQuantity()))
                dto.setQuantity(item.getQuantity());
            if(this.product && item.getProduct()!=null) {
                dto.setProduct(productConverter.toDto(item.getProduct())) ;

            }
            if(this.purchase && item.getPurchase()!=null) {
                dto.setPurchase(purchaseConverter.toDto(item.getPurchase())) ;

            }


        return dto;
        }
    }

    public void init(boolean value) {
        initObject(value);
    }

    public void initObject(boolean value) {
        this.product = value;
        this.purchase = value;
    }
	
    public List<PurchaseItem> toItem(List<PurchaseItemDto> dtos) {
        List<PurchaseItem> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (PurchaseItemDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<PurchaseItemDto> toDto(List<PurchaseItem> items) {
        List<PurchaseItemDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (PurchaseItem item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(PurchaseItemDto dto, PurchaseItem t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
        if(t.getProduct() == null  && dto.getProduct() != null){
            t.setProduct(new Product());
        }
        if(t.getPurchase() == null  && dto.getPurchase() != null){
            t.setPurchase(new Purchase());
        }
        if (dto.getProduct() != null)
        productConverter.copy(dto.getProduct(), t.getProduct());
        if (dto.getPurchase() != null)
        purchaseConverter.copy(dto.getPurchase(), t.getPurchase());
    }

    public List<PurchaseItem> copy(List<PurchaseItemDto> dtos) {
        List<PurchaseItem> result = new ArrayList<>();
        if (dtos != null) {
            for (PurchaseItemDto dto : dtos) {
                PurchaseItem instance = new PurchaseItem();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


    public PurchaseConverter getPurchaseConverter(){
        return this.purchaseConverter;
    }
    public void setPurchaseConverter(PurchaseConverter purchaseConverter ){
        this.purchaseConverter = purchaseConverter;
    }
    public ProductConverter getProductConverter(){
        return this.productConverter;
    }
    public void setProductConverter(ProductConverter productConverter ){
        this.productConverter = productConverter;
    }
    public boolean  isProduct(){
        return this.product;
    }
    public void  setProduct(boolean product){
        this.product = product;
    }
    public boolean  isPurchase(){
        return this.purchase;
    }
    public void  setPurchase(boolean purchase){
        this.purchase = purchase;
    }
}
