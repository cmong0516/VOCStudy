package TeamFresh.voc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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


    public Penalty(boolean deliveryPenaltyCheck,int price) {
        this.deliveryPenaltyCheck = deliveryPenaltyCheck;
        this.price = price;
    }


    public void setVOC(VOC voc) {
        this.voc = voc;
    }
}
