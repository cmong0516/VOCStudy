package TeamFresh.voc.dto;

import TeamFresh.voc.entity.Penalty;
import lombok.Data;

@Data
public class PenaltyDtoInVOC {
    private int price;
    private boolean deliveryCheck;

    public PenaltyDtoInVOC(Penalty penalty) {
        this.price = penalty.getPrice();
        this.deliveryCheck = penalty.isDeliveryPenaltyCheck();
    }
}
