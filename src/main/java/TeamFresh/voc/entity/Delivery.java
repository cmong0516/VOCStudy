package TeamFresh.voc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Delivery{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deliveryc_id")
    @JsonBackReference
    private Deliveryc deliveryc;

    @OneToMany(mappedBy = "delivery")
    @JsonBackReference
    private List<VOC> vocs = new ArrayList<>();

    public Delivery(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void changeDeliveryc(Deliveryc deliveryc) {
        this.deliveryc = deliveryc;
    }
}
