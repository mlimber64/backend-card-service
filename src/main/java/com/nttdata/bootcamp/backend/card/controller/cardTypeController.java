package com.nttdata.bootcamp.backend.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nttdata.bootcamp.backend.card.model.cardType;
import com.nttdata.bootcamp.backend.card.service.cardTypeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/cardType")
public class cardTypeController {
	
	@Autowired
	private cardTypeService serviceType;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	private Flux<cardType> findAll(){
		return serviceType.findAll();
	}
	
	@GetMapping("/card/{id}")
	private Mono<cardType> findById(@PathVariable("id") String id){
		return serviceType.findAllById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private Mono<cardType> save(@RequestBody cardType type){
		return serviceType.save(type);
	}
	
	@PutMapping("/type/{id}")
	private Mono<ResponseEntity<cardType>> update(@PathVariable("id") String id , @RequestBody cardType type){
		return serviceType.update(id, type)
				.flatMap(types -> Mono.just(ResponseEntity.ok(types)))
				.switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
	}
	
	@DeleteMapping("/type/{id}")
	private Mono<ResponseEntity<cardType>> delete(@PathVariable("id") String id){
		return serviceType.delete(id)
				.flatMap(types -> Mono.just(ResponseEntity.ok(types)))
				.switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
	}

}
