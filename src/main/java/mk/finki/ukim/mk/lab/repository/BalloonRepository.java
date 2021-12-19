package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Balloon;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BalloonRepository {

    public static List<Balloon> balloonList = new ArrayList<>();

    @PostConstruct
    public void init(){
        balloonList.add(new Balloon("Teddy bear", "Brown balloon"));
        balloonList.add(new Balloon("Polar bear", "White balloon"));
        balloonList.add(new Balloon("Cat", "Orange balloon"));
        balloonList.add(new Balloon("Dog", "Black balloon"));
        balloonList.add(new Balloon("Hello Kitty", "Pink balloon"));
        balloonList.add(new Balloon("Heart", "Red balloon"));
        balloonList.add(new Balloon("Giraffe", "Yellow balloon"));
        balloonList.add(new Balloon("Unicorn", "Blue balloon"));
        balloonList.add(new Balloon("Frog", "Green balloon"));
        balloonList.add(new Balloon("Lollipop", "Colorful balloon"));
    }

    public List<Balloon> findAllBalloons(){
        return balloonList;
    }

    public List<Balloon> findAllByNameOrDescription(String text){
        if(text!=null && !text.isEmpty()){
            return balloonList.stream().filter(b -> b.getName().contains(text) || b.getDescription().contains(text)).collect(Collectors.toList());
        }
        return null;
    }
}
