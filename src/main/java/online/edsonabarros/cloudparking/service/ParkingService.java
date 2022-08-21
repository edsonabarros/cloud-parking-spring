package online.edsonabarros.cloudparking.service;

import online.edsonabarros.cloudparking.controller.dto.ParkingCreateDTO;
import online.edsonabarros.cloudparking.exception.ParkingNotFoundException;
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



    // ============ GENERATE ID ============
    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }


    // 1.5 - metodo findAll (que está sendo chamado na controller pela var service) usando a variavel parking map para puxar os dadps e retornar uma lista
    // ============ FIND ALL ============
    public List<Parking> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    // ============ FIND BY ID ============
    public Parking findById(String id){
        Parking parking =  parkingMap.get(id);
    if (parking == null){
        throw new ParkingNotFoundException(id);
    }
    return parking;
    }
// ============ CREATE ============
    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDay(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);
        return parkingCreate;
    }

    // ============ DELETE ============
    public void delete(String id) {
        findById(id);
        parkingMap.remove(id);

    }

    public Parking update(String id, Parking parkingCreate) {
        Parking parking = findById(id);
        parking.setColor(parkingCreate.getColor());
        parkingMap.replace(id, parking);
        return parking;
    }

//    public void exit(String id) {
//        //recuperar o estaciona
//        // atualizar data de saida
//        // calcular o valor
//        return null;
//    }
}
