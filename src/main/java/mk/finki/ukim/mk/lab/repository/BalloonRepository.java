package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.model.exceptions.BalloonAlreadyExistsException;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BalloonRepository {

    public static List<Balloon> balloonList = new ArrayList<>();
    private final ManufacturerRepository manufacturerRepository;

    public BalloonRepository(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @PostConstruct
    public void init(){
        balloonList.add(new Balloon("Teddy bear", "Brown balloon", manufacturerRepository.findAll().get(0)));
        balloonList.add(new Balloon("Polar bear", "White balloon", manufacturerRepository.findAll().get(1)));
        balloonList.add(new Balloon("Cat", "Orange balloon", manufacturerRepository.findAll().get(2)));
        balloonList.add(new Balloon("Dog", "Black balloon", manufacturerRepository.findAll().get(3)));
        balloonList.add(new Balloon("Hello Kitty", "Pink balloon", manufacturerRepository.findAll().get(4)));
        balloonList.add(new Balloon("Heart", "Red balloon", manufacturerRepository.findAll().get(0)));
        balloonList.add(new Balloon("Giraffe", "Yellow balloon", manufacturerRepository.findAll().get(1)));
        balloonList.add(new Balloon("Unicorn", "Blue balloon", manufacturerRepository.findAll().get(2)));
        balloonList.add(new Balloon("Frog", "Green balloon", manufacturerRepository.findAll().get(3)));
        balloonList.add(new Balloon("Lollipop", "Colorful balloon", manufacturerRepository.findAll().get(4)));
    }

    public List<Balloon> findAllBalloons(){
        return balloonList
                .stream()
                .sorted(Comparator.comparing(Balloon::getName))
                .collect(Collectors.toList());
    }

    public List<Balloon> findAllByNameOrDescription(String text){
        if(text!=null && !text.isEmpty()){
            return balloonList.stream().filter(b -> b.getName().contains(text) || b.getDescription().contains(text)).collect(Collectors.toList());
        }
        return null;
    }

    public Optional<Balloon> saveOrUpdateBalloon(String name, String description, Manufacturer m){
        if(balloonList.stream().filter(b->b.getName().equals(name)).findFirst().isPresent()){
            throw new BalloonAlreadyExistsException();
        }
        else{
            balloonList.removeIf(b->b.getName().equals(name));
            Balloon b = new Balloon(name, description, m);
            balloonList.add(b);
            return Optional.of(b);
        }
    }

    public void deleteById(Long id){
        balloonList.removeIf(b->b.getId().equals(id));
    }

    public Optional<Balloon> findById(Long id){
        return balloonList.stream().filter(b->b.getId().equals(id)).findFirst();
    }
}
