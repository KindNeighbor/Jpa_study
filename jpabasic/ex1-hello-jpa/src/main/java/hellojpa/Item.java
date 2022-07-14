package hellojpa;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public class Item {

    @Id @GeneratedValue
    private long id;

    private String name;
    private int price;
}
