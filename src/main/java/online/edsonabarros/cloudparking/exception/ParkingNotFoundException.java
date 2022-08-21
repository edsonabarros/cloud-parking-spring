package online.edsonabarros.cloudparking.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ParkingNotFoundException extends RuntimeException {
    //pesquisar runtime exception

    public ParkingNotFoundException(String id){
        super("Parking not found wuth id: "+ id);
    }

}
