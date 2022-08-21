package online.edsonabarros.cloudparking.controller;


import io.swagger.annotations.ApiOperation;
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
    * ResponseEntety encapsula a lista e você retorna um body  passando ok(200) e
    * por ser ok, ele vai exibir o conteúdo = boa pratica
    *
    * */
    @GetMapping
    @ApiOperation("Find all parkings")
    public ResponseEntity <List<ParkingDTO>> findAll(){
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
        return ResponseEntity.ok(result);
    }


    /*
    *  por se tratar da busca de um objeto, retiramos a lista do ResponseEntity
    * e deixamos apenas o ParkingDTO, que vai buscar um objtot.
    * */

    // ============ FIND BY ID ============

    @GetMapping("/{id}")
    public ResponseEntity <ParkingDTO> findById(@PathVariable String id){
        Parking parking = parkingService.findById(id);
       /* if(parking == null){
            return ResponseEntity.notFound().build();
        }
        Tratamento de erro possível, mas a forma correta é no service
        */
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.ok(result);
    }

    /*
    * Dá para usar tanto a classe na definição ou o var
    * */

    // ============ CREATE ============
    @PostMapping
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto){
        //transformar dto na entidade
        Parking parkingCreate = parkingMapper.toParkingCreate(dto);
        Parking parking = parkingService.create(parkingCreate);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
        // não posso voltar 200 por ser um post, então vou retornar o stutas de criado com o resulty no body
    }


    // ============ UPDATE ============

    @PutMapping("/{id}")
    public ResponseEntity<ParkingDTO> update(@PathVariable String id, @RequestBody ParkingCreateDTO dto){
        //transformar dto na entidade
        var parkingCreate = parkingMapper.toParkingCreate(dto);
        var parking = parkingService.update(id, parkingCreate);
        var result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.status(HttpStatus.OK).body(result);
        // não posso voltar 200 por ser um post, então vou retornar o stutas de criado com o resulty no body
    }


    // ============ DELETE ============
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
       parkingService.delete(id);
       return ResponseEntity.noContent().build();
    }

//    @PostMapping("/{id}")
//    public ResponseEntity<ParkingDTO> exit(@PathVariable String id){
//        var parking = parkingService.exit(id);
//        return null;
//    }
//







}
