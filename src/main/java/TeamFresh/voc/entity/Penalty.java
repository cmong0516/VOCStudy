package TeamFresh.voc.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Penalty extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(mappedBy = "penalty",fetch = FetchType.LAZY)
    private VOC voc;
    private boolean deliveryPenaltyCheck;

    public void setVOC(VOC voc) {
        this.voc = voc;
    }
}
