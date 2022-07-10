package org.example.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Integer billId;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    @Column(name = "price")
    private int soldPrice;

    public Bill(int soldPrice) {
        this.soldPrice = soldPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Bill)) {
            return false;
        }
        Bill bill = (Bill) o;
        return Objects.equals(billId, bill.billId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billId);
    }
}
