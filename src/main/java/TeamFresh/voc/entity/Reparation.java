package TeamFresh.voc.entity;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reparation extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private int price;
    @OneToOne(mappedBy = "reparation")
    private VOC voc;

}
