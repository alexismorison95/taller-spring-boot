package taller.domain;

import jakarta.persistence.*;
import taller.domain.base.BaseEntity;

import java.util.Date;

@Entity
@Table(name = "ProductExcursion")
public class ProductExcursion extends BaseEntity {

    @Column(nullable=false)
    private Date createdDate;

    @Column(nullable=false)
    private Integer productId;

    @Column(nullable=false)
    private Integer excursionId;

    @ManyToOne
    @JoinColumn(name = "productId", insertable=false, updatable=false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "excursionId", insertable=false, updatable=false)
    private Excursion excursion;

    public ProductExcursion() {
    }

    public ProductExcursion(Integer id, Date createdDate, Integer productId, Integer excursionId) {
        this.setId(id);
        this.createdDate = createdDate;
        this.productId = productId;
        this.excursionId = excursionId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getExcursionId() {
        return excursionId;
    }

    public void setExcursionId(Integer excursionId) {
        this.excursionId = excursionId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Excursion getExcursion() {
        return excursion;
    }

    public void setExcursion(Excursion excursion) {
        this.excursion = excursion;
    }
}
