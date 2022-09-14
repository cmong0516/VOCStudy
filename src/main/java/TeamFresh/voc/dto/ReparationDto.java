package TeamFresh.voc.dto;

import TeamFresh.voc.entity.Reparation;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
public class ReparationDto {
    // 배상 금액
    private int price;
    // 해당 VOC
    private VOCDto vocDto;

    public ReparationDto(Reparation reparation) {
        this.price = reparation.getPrice();
        this.vocDto = new VOCDto(reparation.getVoc());
    }
}
