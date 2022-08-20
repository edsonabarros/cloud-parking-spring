package online.edsonabarros.cloudparking.controller;


import online.edsonabarros.cloudparking.controller.dto.ParkingDTO;
import online.edsonabarros.cloudparking.controller.mapper.ParkingMapper;
import online.edsonabarros.cloudparking.model.Parking;
import online.edsonabarros.cloudparking.service.ParkingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {



    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;


    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }


    // 1. 5 - passando o findAll via Mapper (adc dependencia maven) para facilitar na conversão e exibição
    @GetMapping
    public List<ParkingDTO> findAll(){
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
        return result;
    }

}
