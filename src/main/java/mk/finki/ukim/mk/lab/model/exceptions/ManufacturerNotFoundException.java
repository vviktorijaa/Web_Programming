package mk.finki.ukim.mk.lab.model.exceptions;

public class ManufacturerNotFoundException extends RuntimeException {

    public ManufacturerNotFoundException() {
        super("Manufacturer not found");
    }
}
