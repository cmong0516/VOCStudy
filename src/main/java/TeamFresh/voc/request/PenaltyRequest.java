package TeamFresh.voc.request;

import TeamFresh.voc.entity.Penalty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PenaltyRequest {
    private Long id;
    private Penalty penalty;
}
