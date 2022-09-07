package TeamFresh.voc.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Deliveryc {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "deliveryc")
    private List<Delivery> deliveryList = new ArrayList<>();

    @OneToMany(mappedBy = "deliveryc")
    private List<VOC> vocs = new ArrayList<>();

}
