package TeamFresh.voc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reparation extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 배상 금액
    private int price;
    // 배상해야할 VOC 정보
    @OneToOne(mappedBy = "reparation")
    @JsonBackReference
    private VOC voc;

    public void setVOC(VOC voc) {
        this.voc = voc;
    }

    public Reparation(int price) {
        this.price = price;
    }
}
