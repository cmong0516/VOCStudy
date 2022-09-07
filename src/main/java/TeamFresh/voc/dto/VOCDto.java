package TeamFresh.voc.dto;


import TeamFresh.voc.entity.VOC;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class VOCDto {
    @NotNull
    private Negligence negligence;
    @NotNull
    private String reason;
    private PenaltyDto penaltyDto;
    private boolean deliverCheck;
    private boolean objection;
    private ReparationDto reparationDto;

    public VOCDto(VOC voc) {

    }
}
