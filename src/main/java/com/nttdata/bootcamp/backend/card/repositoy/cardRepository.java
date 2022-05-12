package com.nttdata.bootcamp.backend.card.repositoy;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcamp.backend.card.model.card;

public interface cardRepository extends ReactiveMongoRepository<card, String>{

}
