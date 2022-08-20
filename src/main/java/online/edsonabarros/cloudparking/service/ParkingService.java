package online.edsonabarros.cloudparking.service;

import online.edsonabarros.cloudparking.model.Parking;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap<>();

    static{
        var id = getUUID();
        Parking parking = new Parking(id, "DMD-1111", "SC", "CELTA", "PPRETO");
        parkingMap.put(id, parking);
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }

    // 1.5 - metodo findAll (que está sendo chamado na controller pela var service) usando a variavel parking map para puxar os dadps e retornar uma lista
    public List<Parking> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }


}
