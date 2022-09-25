package TeamFresh.voc.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class PenaltyRequest {
    private Long id;
    @NotNull
    private int price;
}
