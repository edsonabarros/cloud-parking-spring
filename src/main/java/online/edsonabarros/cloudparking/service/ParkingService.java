package online.edsonabarros.cloudparking.service;

import online.edsonabarros.cloudparking.model.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        var id1 = getUUID();
        Parking parking = new Parking(id, "DMD-1111", "SC", "CELTA", "PPRETO");
        Parking parking1 = new Parking(id1, "FHZ-5233", "SP", "GOL", "VERMELHO");
        parkingMap.put(id, parking);
        parkingMap.put(id1, parking1);
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }

    // 1.5 - metodo findAll (que está sendo chamado na controller pela var service) usando a variavel parking map para puxar os dadps e retornar uma lista
    public List<Parking> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    public Parking findById(String id){
        return parkingMap.get(id);
    }

    public Parking create(Parking parkingCreate) {

        String uuid = getUUID();

        parkingCreate.setId(uuid);
        parkingCreate.setEntryDay(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);


        return parkingCreate;
    }
}
