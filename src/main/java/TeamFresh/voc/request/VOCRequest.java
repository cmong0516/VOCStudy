package TeamFresh.voc.request;

import TeamFresh.voc.dto.Negligence;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VOCRequest {

    @JsonProperty("negligence")
    private String negligence;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("deliveryId")
    private Long deliveryId;
    @JsonProperty("clientId")
    private Long clientId;

}
