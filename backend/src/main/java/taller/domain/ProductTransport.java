package taller.domain;

import jakarta.persistence.*;
import taller.domain.base.AuditableEntity;

import java.util.Date;

@Entity
@Table(name = "ProductTransport")
public class ProductTransport extends AuditableEntity {

    @Column(nullable=false)
    private Integer order;

    private String information;

    @Column(nullable=false)
    private Integer productId;

    @Column(nullable=false)
    private Integer transportId;

    @ManyToOne
    @JoinColumn(name = "productId", insertable=false, updatable=false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "transportId", insertable=false, updatable=false)
    private Transport transport;

    public ProductTransport() {
    }

    public ProductTransport(Integer id, Date createdDate, Integer order, String information, Integer productId, Integer transportId) {
        this.setId(id);
        this.setCreatedDate(createdDate);
        this.order = order;
        this.information = information;
        this.productId = productId;
        this.transportId = transportId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getTransportId() {
        return transportId;
    }

    public void setTransportId(Integer transportId) {
        this.transportId = transportId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }
}
