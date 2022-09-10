package TeamFresh.voc.dto;

import TeamFresh.voc.entity.Reparation;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReparationDto {

    private int price;

    public ReparationDto(Reparation reparation) {
        price = reparation.getPrice();
    }
}
