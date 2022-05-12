package com.nttdata.bootcamp.backend.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nttdata.bootcamp.backend.card.model.card;
import com.nttdata.bootcamp.backend.card.service.cardService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/card")
public class cardController {
	
	@Autowired
	private cardService serviceCard;
	
	@GetMapping
	private Flux<card> findAll(){
		return serviceCard.findAll();
	}
	
	@GetMapping("/card/{id}")
	private Mono<card> findById(@PathVariable("id") String id){
		return serviceCard.findAllById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private Mono<card> save(@RequestBody card c){
		return serviceCard.save(c);
	}
	
	@PutMapping("/card/{id}")
	private Mono<ResponseEntity<card>> update(@PathVariable("id") String id,@RequestBody card c){
		return serviceCard.update(id, c)
				.flatMap(cards -> Mono.just(ResponseEntity.ok(cards)))
				.switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
	}
	
	@DeleteMapping("/card/{id}")
	private Mono<ResponseEntity<card>> delete(@PathVariable("id") String id){
		return serviceCard.delete(id)
				.flatMap(cards -> Mono.just(ResponseEntity.ok(cards)))
				.switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
	}

}
