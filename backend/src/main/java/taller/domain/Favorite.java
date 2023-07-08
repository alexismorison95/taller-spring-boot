package taller.domain;

import jakarta.persistence.*;
import taller.domain.base.BaseEntity;

import java.util.Date;

@Entity
@Table(name = "Favorite")
public class Favorite extends BaseEntity {

    @Column(nullable=false)
    private Date createdDate;

    @Column(nullable=false)
    private Integer productId;

    @Column(nullable=false)
    private Integer customerId;

    @ManyToOne
    @JoinColumn(name = "productId", insertable=false, updatable=false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customerId", insertable=false, updatable=false)
    private Customer customer;

    public Favorite() {
    }

    public Favorite(Integer id, Date createdDate, Integer productId, Integer customerId) {
        this.setId(id);
        this.createdDate = createdDate;
        this.productId = productId;
        this.customerId = customerId;
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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
