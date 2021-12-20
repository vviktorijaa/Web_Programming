package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ManufacturerRepository {

    public static List<Manufacturer> manufacturers=new ArrayList<>();

    @PostConstruct
    public void init(){
        Manufacturer m1 = new Manufacturer("Manufacturer1", "USA", "NY");
        Manufacturer m2 = new Manufacturer("Manufacturer2", "UK", "London");
        Manufacturer m3 = new Manufacturer("Manufacturer3", "France", "Paris");
        Manufacturer m4 = new Manufacturer("Manufacturer4", "Italy", "Milano");
        Manufacturer m5 = new Manufacturer("Manufacturer5", "USA", "LA");
        manufacturers.add(m1);
        manufacturers.add(m2);
        manufacturers.add(m3);
        manufacturers.add(m4);
        manufacturers.add(m5);
    }

    public List<Manufacturer> findAll(){
        return manufacturers;
    }

    public Optional<Manufacturer> findById(Long id){
        return manufacturers.stream().filter(m->m.getId().equals(id)).findFirst();
    }
}
