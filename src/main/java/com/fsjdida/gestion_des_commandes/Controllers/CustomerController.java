package com.fsjdida.gestion_des_commandes.Controllers;

import com.fsjdida.gestion_des_commandes.Dto.CustomerRequestDto;
import com.fsjdida.gestion_des_commandes.Dto.CustomerResponseDto;
import com.fsjdida.gestion_des_commandes.Services.CustomerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

//    Reponse entity depuis maintenant va rendre que ces reponse avec ces nombre
// find   200
// Delete 204
// update 202
// save 201

    private final CustomerService customerService;

    //constructeur
    public CustomerController(@Qualifier("impl1") CustomerService customerService) {
        this.customerService = customerService;
    }

    // S E L E C T
    // recuprer les clients
    @GetMapping("/recuperer_clients")
    public ResponseEntity<List<CustomerResponseDto>> getCustomers() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }


    // S E L E C T
    @GetMapping("/recuperer_ParNom/{nom}")
    public ResponseEntity<CustomerResponseDto> findByFirstName(@PathVariable("nom") String fisrtName) {
        return ResponseEntity.ok(customerService.fundByFirstName(fisrtName));
    }

    // S E L E C T
    // si le param ==! parametre de fonction on ajoute le nom de param dans pathvariable  ex : id_customer
    @GetMapping("/recuperer_ParId/{id_customer}")
    public ResponseEntity<CustomerResponseDto> findById(@PathVariable("id_customer") Long id) {
        return ResponseEntity.ok(customerService.findById(id));// utilisant new c'est STATIC
    }

    // I N S E R T
    @PostMapping("/store")
    public ResponseEntity<CustomerResponseDto> save(@RequestBody() CustomerRequestDto customerRequestDto) {
        CustomerResponseDto customerResponseDto = customerService.save(customerRequestDto);
        return new ResponseEntity<>(customerResponseDto, HttpStatus.CREATED); // utilisant new c'est denamic
    }

    // U P D A T E
    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerResponseDto> update(@RequestBody() CustomerRequestDto customerRequestDto, @PathVariable("id") long id_customer) {
       CustomerResponseDto customerResponseDto = customerService.update(customerRequestDto, id_customer);
        return ResponseEntity.accepted().body(customerResponseDto);
    }

    // D E L E T E
    @DeleteMapping("/delete/{id_customer}")
    public ResponseEntity<?> deleteById(@PathVariable() Long id_customer) {
        customerService.deleteById(id_customer);
        return  ResponseEntity.noContent().build();
    }

}
