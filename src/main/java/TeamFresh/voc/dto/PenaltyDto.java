package TeamFresh.voc.dto;

import TeamFresh.voc.entity.Penalty;
import TeamFresh.voc.entity.VOC;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PenaltyDto {

    private boolean deliveryCheck;
    private VOC voc;

    public PenaltyDto(Penalty penalty) {
        this.deliveryCheck = penalty.isDeliveryPenaltyCheck();
        this.voc = penalty.getVoc();
    }
}
