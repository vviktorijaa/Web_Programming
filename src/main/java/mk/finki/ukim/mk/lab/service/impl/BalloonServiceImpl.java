package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.model.exceptions.ManufacturerNotFoundException;
import mk.finki.ukim.mk.lab.repository.jpa.BalloonJpaRepository;
import mk.finki.ukim.mk.lab.repository.ManufacturerRepository;
import mk.finki.ukim.mk.lab.repository.jpa.ManufacturerJpaRepository;
import mk.finki.ukim.mk.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {

    private final BalloonJpaRepository balloonRepository;
    private final ManufacturerJpaRepository manufacturerRepository;

    public BalloonServiceImpl(BalloonJpaRepository balloonRepository, ManufacturerJpaRepository manufacturerRepository) {
        this.balloonRepository = balloonRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAll();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findAllByNameLike(text);
    }

    @Override
    @Transactional
    public Balloon save(String name, String description, Long id) {
        Manufacturer m = this.manufacturerRepository.findById(id)
                .orElseThrow(() -> new ManufacturerNotFoundException());
        this.balloonRepository.deleteByName(name);
        Balloon b = new Balloon(name, description, m);
        return this.balloonRepository.save(b);
    }

    public void deleteById(Long id){
        balloonRepository.deleteById(id);
    }

    @Override
    public Optional<Balloon> findByid(Long id) {
        return this.balloonRepository.findById(id);
    }
}
