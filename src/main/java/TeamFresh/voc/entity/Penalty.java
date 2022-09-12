package TeamFresh.voc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Penalty extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "penalty")
    @JsonBackReference
    private VOC voc;

    private boolean deliveryPenaltyCheck;
    private int price;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    @JsonManagedReference
    private Delivery delivery;


    public Penalty(int price) {
        this.price = price;
    }

    public void setVOC(VOC voc) {
        this.voc = voc;
    }

    public void changeDeliveryPenaltyCheck(boolean deliveryPenaltyCheck) {
        this.deliveryPenaltyCheck = deliveryPenaltyCheck;
    }

    public void changeDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
