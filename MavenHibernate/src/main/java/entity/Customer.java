package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="customers")
@NoArgsConstructor @Getter @Setter @ToString
public class Customer {
    @Id
    @GeneratedValue
    @Column(name="customerNumber")
    private int customerNumber;
    @Column(name="customerName")
    private String customerName;
    @Column(name="contactFirstName")
    private String firstName;
    @Column(name="contactLastName")
    private String lastName;
    @Column(name="phone")
    private String phone;
    @Column(name="addressLine1")
    private String address1;
    @Column(name="addressLine2")
    private String address2;
    @Column(name="city")
    private String city;
    @Column(name="state")
    private String state;
    @Column(name="postalCode")
    private String postalCode;
    @Column(name="country")
    private String country;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salesRepEmployeeNumber", referencedColumnName = "employeeNumber")
    private Employee salesRep;
    @Column(name = "creditLimit")
    private double creditLimit;

    public Customer(int customerNumber, String customerName, String firstName, String lastName, String phone, String address1, String address2, String city, String state, String postalCode, String country, Employee salesRep, double creditLimit) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.salesRep = salesRep;
        this.creditLimit = creditLimit;
    }
}
