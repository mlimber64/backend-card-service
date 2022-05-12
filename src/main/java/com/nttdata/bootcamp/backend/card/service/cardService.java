package com.nttdata.bootcamp.backend.card.service;


import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.backend.card.model.card;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface cardService {
	
	Flux<card> findAll();
	
	Mono<card> findAllById(String id);
	
	Mono<card> save(card c);
	
	Mono<card> update(String id ,card c);
	
	Mono<card> delete(String id);

}
