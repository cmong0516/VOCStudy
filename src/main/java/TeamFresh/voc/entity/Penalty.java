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
    @OneToOne(mappedBy = "penalty",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonBackReference
    private VOC voc;
    private boolean deliveryPenaltyCheck;

    public void setVOC(VOC voc) {
        this.voc = voc;
    }

    public Penalty(boolean deliveryPenaltyCheck) {
        this.deliveryPenaltyCheck = deliveryPenaltyCheck;
    }


}
