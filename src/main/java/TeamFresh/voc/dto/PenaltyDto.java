package TeamFresh.voc.dto;

import TeamFresh.voc.entity.Penalty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PenaltyDto {

    private boolean deliveryCheck;

    public PenaltyDto(Penalty penalty) {
        deliveryCheck = penalty.isDeliveryPenaltyCheck();
    }
}
