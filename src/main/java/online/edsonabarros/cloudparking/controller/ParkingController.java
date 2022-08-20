package online.edsonabarros.cloudparking.controller;


import online.edsonabarros.cloudparking.controller.dto.ParkingCreateDTO;
import online.edsonabarros.cloudparking.controller.dto.ParkingDTO;
import online.edsonabarros.cloudparking.controller.mapper.ParkingMapper;
import online.edsonabarros.cloudparking.model.Parking;
import online.edsonabarros.cloudparking.service.ParkingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /*
    * 1. 5 - passando o findAll via Mapper (adc dependencia maven) para facilitar na conversão e exibição
    *
    * ResponseEntety encapsula a lista e você retorna um body  passando ok(200) e
    * por ser ok, ele vai exibir o conteúdo = boa pratica
    *
    * */
    @GetMapping
    public ResponseEntity <List<ParkingDTO>> findAll(){
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
        return ResponseEntity.ok(result);
    }


    /*
    *
    *  por se tratar da busca de um objeto, retiramos a lista do ResponseEntity
    * e deixamos apenas o ParkingDTO, que vai buscar um objtot.
    *
    *
    * */
    @GetMapping("/{id}")
    public ResponseEntity <ParkingDTO> findById(@PathVariable String id){
        Parking parking = parkingService.findById(id);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.ok(result);
    }

    /*
    *
    * Dá para usar tanto a classe na definição ou o var
    *
    *
    * */

    @PostMapping
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto){
        //transformar dto na entidade
        var parkingCreate = parkingMapper.toParkingCreate(dto);
        var parking = parkingService.create(parkingCreate);
        var result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
        // não posso voltar 200 por ser um post, então vou retornar o stutas de criado com o resulty no body
    }



}
