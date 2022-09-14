package TeamFresh.voc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Penalty extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 패널티가 발급된 VOC
    @OneToOne(mappedBy = "penalty",cascade = CascadeType.ALL)
    @JsonBackReference
    private VOC voc;
    // 운송기사의 패널티 확인 여부
    private boolean deliveryPenaltyCheck;
    // 패널티 금액
    private int price;
    // 패널티를 발급받은 배송기사
    @ManyToOne(fetch = FetchType.LAZY)
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
