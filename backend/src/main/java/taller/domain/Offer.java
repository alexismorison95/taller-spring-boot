package taller.domain;

import jakarta.persistence.*;
import taller.domain.base.AuditableEntity;

import java.util.Date;

@Entity
@Table(name = "Offer")
public class Offer extends AuditableEntity {

    @Column(nullable=false)
    private Float offerPrice;

    @Column(nullable=false)
    private Date startDate;

    @Column(nullable=false)
    private Date endtDate;

    @Column(nullable=false)
    private Boolean active;

    private String bannerText;

    @Column(nullable=false)
    private Integer productId;

    @ManyToOne
    @JoinColumn(name = "productId", insertable=false, updatable=false)
    private Product product;

    public Offer() {
    }

    public Offer(Integer id, Date createdDate, Float offerPrice, Date startDate, Date endtDate, Boolean active, String bannerText, Integer productId, Product product) {
        this.setId(id);
        this.setCreatedDate(createdDate);
        this.offerPrice = offerPrice;
        this.startDate = startDate;
        this.endtDate = endtDate;
        this.active = active;
        this.bannerText = bannerText;
        this.productId = productId;
        this.product = product;
    }

    public Float getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(Float offerPrice) {
        this.offerPrice = offerPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndtDate() {
        return endtDate;
    }

    public void setEndtDate(Date endtDate) {
        this.endtDate = endtDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getBannerText() {
        return bannerText;
    }

    public void setBannerText(String bannerText) {
        this.bannerText = bannerText;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
