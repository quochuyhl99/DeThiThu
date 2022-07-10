package org.example.entity;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apartment_id")
    private Integer apartmentId;

    @Column(name = "apartment_code")
    private String apartmentCode;

    @Column(name = "num_bedroom")
    private int numBedroom;

    @Column(name = "door_direction")
    private String doorDirection;

    private int price;

    private String status;

    @ToString.Exclude
    @OneToOne(mappedBy = "apartment", cascade = CascadeType.ALL)
    private Bill bill;

    public Apartment(String apartmentCode, int numBedroom, String doorDirection, int price,
                     String status) {
        this.apartmentCode = apartmentCode;
        this.numBedroom = numBedroom;
        this.doorDirection = doorDirection;
        this.price = price;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Apartment)) {
            return false;
        }
        Apartment apartment = (Apartment) o;
        return Objects.equals(apartmentId, apartment.apartmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apartmentId);
    }
}

