package ma.zs.zyn.zynerator.audit;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import ma.zs.zyn.zynerator.bean.BusinessObject;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

/**
 * Classe mère abstraite de tous les Objets métier hl7 et order.
 *
 * @author JAF
 * @version 1.2
 */


@MappedSuperclass
@EntityListeners(EntityListener.class)
public class AuditBusinessObjectEnhanced extends AuditBusinessObject {

    protected Boolean actif = false;
    protected String hl7;
    protected Long ordre ;

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public String getHl7() {
        return hl7;
    }

    public void setHl7(String hl7) {
        this.hl7 = hl7;
    }

    public Long getOrdre() {
        return ordre;
    }

    public void setOrdre(Long ordre) {
        this.ordre = ordre;
    }

}
