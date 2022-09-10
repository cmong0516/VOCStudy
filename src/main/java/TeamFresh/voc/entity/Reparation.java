package TeamFresh.voc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
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
    private int price;
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
