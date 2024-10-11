package com.example.cashCard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/cashcards")
class CashCardController {
    private final CashCardRepository cashCardRepository;
    private CashCardController(CashCardRepository cashCardRepository){
        this.cashCardRepository = cashCardRepository;
    }


    //GetMapping marks a method as a handler to
    // GET Requests that match " cashcard/{requestId}
    @GetMapping("/{requestedId}")
    private ResponseEntity<CashCard> findById(@PathVariable Long requestedId){
        Optional<CashCard> cashCardOptinal = cashCardRepository.findById(requestedId);
        if(cashCardOptinal.isPresent()){
            return ResponseEntity.ok(cashCardOptinal.get());
        }else {
            return  ResponseEntity.notFound().build();
        }

    }
}