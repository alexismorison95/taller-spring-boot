package taller.domain;

import jakarta.persistence.*;
import taller.domain.base.AuditableEntity;

import java.util.Date;

@Entity
@Table(name = "Payment")
public class Payment extends AuditableEntity {

    @Column(nullable=false)
    private Integer sourceId;

    @Column(nullable=false)
    private Date approvedDate;

    @Column(nullable=false)
    private String paymentMethodId;

    @Column(nullable=false)
    private String paymentTypeId;

    @Column(nullable=false)
    private String status;

    @OneToOne
    private Order order;

    public Payment() {
    }

    public Payment(Integer id, Date createdDate, Integer sourceId, Date approvedDate, String paymentMethodId, String paymentTypeId, String status) {
        this.setId(id);
        this.setCreatedDate(createdDate);
        this.sourceId = sourceId;
        this.approvedDate = approvedDate;
        this.paymentMethodId = paymentMethodId;
        this.paymentTypeId = paymentTypeId;
        this.status = status;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(String paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
