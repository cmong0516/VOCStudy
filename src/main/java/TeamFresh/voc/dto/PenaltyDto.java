package TeamFresh.voc.dto;

import TeamFresh.voc.entity.Penalty;
import TeamFresh.voc.entity.VOC;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PenaltyDto {
    // 배송기사 확인여부
    private boolean deliveryCheck;
    // 해당 VOC
    @JsonBackReference
    private VOC voc;
    private int price;

    public PenaltyDto(Penalty penalty) {
        this.deliveryCheck = penalty.isDeliveryPenaltyCheck();
        this.voc = penalty.getVoc();
        this.price = penalty.getPrice();
    }
}
