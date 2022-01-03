package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BalloonJpaRepository extends JpaRepository<Balloon, Long> {

    List<Balloon> findAllByNameLike(String text);

    @Override
    List<Balloon> findAll();

    //Balloon save(Balloon b);
}
