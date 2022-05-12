package com.nttdata.bootcamp.backend.card.repositoy;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcamp.backend.card.model.cardType;

public interface cardTypeRepository extends ReactiveMongoRepository<cardType, String>{

}
