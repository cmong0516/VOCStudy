package TeamFresh.voc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@Getter
public class Penalty extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(mappedBy = "penalty")
    private VOC voc;
    private boolean deliveryCheck;

    public void changeDeliveryCheck(boolean deliveryCheck) {
        this.deliveryCheck = deliveryCheck;
    }

}
