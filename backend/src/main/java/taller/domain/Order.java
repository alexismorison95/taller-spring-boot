package taller.domain;

import jakarta.persistence.*;
import taller.domain.base.AuditableEntity;

import java.util.Date;

@Entity
@Table(name = "Order")
public class Order extends AuditableEntity {

    @Column(nullable=false)
    private Integer quantity;

    @Column(nullable=false)
    private Float unitPrice;

    @Column(nullable=false)
    private Float totalPrice;

    private Float discount;

    @Column(nullable=false)
    private Integer orderStateId;

    @Column(nullable=false)
    private Integer productId;

    @Column(nullable=false)
    private Integer customerId;

    @Column(nullable=false)
    private Integer ratingScaleId;

    @Column(nullable=false)
    private Integer paymentId;

    @ManyToOne
    @JoinColumn(name = "orderStateId", insertable=false, updatable=false)
    private OrderState orderState;

    @ManyToOne
    @JoinColumn(name = "productId", insertable=false, updatable=false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customerId", insertable=false, updatable=false)
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "paymentId", insertable=false, updatable=false)
    private Payment payment;

    public Order() {
    }

    public Order(Integer id, Date createdDate, Integer quantity, Float unitPrice, Float totalPrice, Float discount, Integer orderStateId, Integer productId, Integer customerId, Integer ratingScaleId, Integer paymentId) {
        this.setId(id);
        this.setCreatedDate(createdDate);
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.orderStateId = orderStateId;
        this.productId = productId;
        this.customerId = customerId;
        this.ratingScaleId = ratingScaleId;
        this.paymentId = paymentId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Integer getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(Integer orderStateId) {
        this.orderStateId = orderStateId;
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

    public Integer getRatingScaleId() {
        return ratingScaleId;
    }

    public void setRatingScaleId(Integer ratingScaleId) {
        this.ratingScaleId = ratingScaleId;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
