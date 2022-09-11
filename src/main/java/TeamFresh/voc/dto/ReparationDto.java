package TeamFresh.voc.dto;

import TeamFresh.voc.entity.Reparation;
import TeamFresh.voc.entity.VOC;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReparationDto {

    private int price;
    private VOC voc;

    public ReparationDto(Reparation reparation) {
        this.price = reparation.getPrice();
        this.voc = reparation.getVoc();
    }
}
