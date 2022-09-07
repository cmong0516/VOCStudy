package TeamFresh.voc.entity;

import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
public class Reparation extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private int price;
    @OneToOne(mappedBy = "reparation")
    private VOC voc;

    public Reparation() {
    }
}
