package  ma.zs.stocky.dao.criteria.core.money;



import ma.zs.stocky.zynerator.criteria.BaseCriteria;

import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class PurchaseCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime purchaseDate;
    private LocalDateTime purchaseDateFrom;
    private LocalDateTime purchaseDateTo;
    private String image;
    private String imageLike;
    private String total;
    private String totalMin;
    private String totalMax;
    private String description;
    private String descriptionLike;



    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getReferenceLike(){
        return this.referenceLike;
    }
    public void setReferenceLike(String referenceLike){
        this.referenceLike = referenceLike;
    }

    public LocalDateTime getPurchaseDate(){
        return this.purchaseDate;
    }
    public void setPurchaseDate(LocalDateTime purchaseDate){
        this.purchaseDate = purchaseDate;
    }
    public LocalDateTime getPurchaseDateFrom(){
        return this.purchaseDateFrom;
    }
    public void setPurchaseDateFrom(LocalDateTime purchaseDateFrom){
        this.purchaseDateFrom = purchaseDateFrom;
    }
    public LocalDateTime getPurchaseDateTo(){
        return this.purchaseDateTo;
    }
    public void setPurchaseDateTo(LocalDateTime purchaseDateTo){
        this.purchaseDateTo = purchaseDateTo;
    }
    public String getImage(){
        return this.image;
    }
    public void setImage(String image){
        this.image = image;
    }
    public String getImageLike(){
        return this.imageLike;
    }
    public void setImageLike(String imageLike){
        this.imageLike = imageLike;
    }

    public String getTotal(){
        return this.total;
    }
    public void setTotal(String total){
        this.total = total;
    }   
    public String getTotalMin(){
        return this.totalMin;
    }
    public void setTotalMin(String totalMin){
        this.totalMin = totalMin;
    }
    public String getTotalMax(){
        return this.totalMax;
    }
    public void setTotalMax(String totalMax){
        this.totalMax = totalMax;
    }
      
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }


}
