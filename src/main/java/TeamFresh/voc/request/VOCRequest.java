package TeamFresh.voc.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VOCRequest {

    @JsonProperty("negligence")
    @NotNull
    private String negligence;
    @NotNull
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("deliveryId")
    @NotNull
    private Long deliveryId;
    @JsonProperty("clientId")
    @NotNull
    private Long clientId;
    private int price;

}
