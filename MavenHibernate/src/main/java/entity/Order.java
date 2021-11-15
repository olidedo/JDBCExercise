package entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "orders", indexes = {
        @Index(name = "customerNumber", columnList = "customerNumber")
})
@Entity
@NoArgsConstructor @Getter @Setter @ToString
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "orderNumber", nullable = false)
    private Integer id;

    @Column(name = "orderDate", nullable = false)
    private Date orderDate;

    @Column(name = "requiredDate", nullable = false)
    private Date requiredDate;

    @Column(name = "shippedDate")
    private Date shippedDate;

    @Column(name = "status", nullable = false, length = 15)
    private String status;

    @Lob
    @Column(name = "comments")
    private String comments;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customerNumber", nullable = false)
    private Customer customerNumber;

    public Order(Integer id, Date orderDate, Date requiredDate, Date shippedDate, String status, String comments, Customer customerNumber) {
        this.id = id;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
        this.customerNumber = customerNumber;
    }
}