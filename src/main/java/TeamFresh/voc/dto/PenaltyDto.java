package TeamFresh.voc.dto;

import TeamFresh.voc.entity.Penalty;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PenaltyDto {
    // 배송기사 확인여부
    private boolean deliveryCheck;
    // 해당 VOC
    private VOCDto vocDto;
    private int price;

    public PenaltyDto(Penalty penalty) {
        this.deliveryCheck = penalty.isDeliveryPenaltyCheck();
        this.vocDto = new VOCDto(penalty.getVoc());
        this.price = penalty.getPrice();
    }
}
