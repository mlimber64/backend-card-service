package com.nttdata.bootcamp.backend.card.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nttdata.bootcamp.backend.card.model.cardType;
import com.nttdata.bootcamp.backend.card.repositoy.cardTypeRepository;
import com.nttdata.bootcamp.backend.card.service.cardTypeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class cardTypeServiceImpl implements cardTypeService{
	
	@Autowired
	private cardTypeRepository repositoryType;

	@Override
	public Flux<cardType> findAll() {
		return repositoryType.findAll();
	}

	@Override
	public Mono<cardType> findAllById(String id) {
		return repositoryType.findById(id);
	}

	@Override
	public Mono<cardType> save(cardType ct) {
		return repositoryType.save(ct);
	}

	@Override
	public Mono<cardType> update(String id, cardType ct) {
		return repositoryType.findById(id)
				.flatMap(at -> {
					ct.setId(id);
					return save(ct);
				})
				.switchIfEmpty(Mono.empty());
	}

	@Override
	public Mono<cardType> delete(String id) {
		return repositoryType
				.findById(id)
				.flatMap(c -> repositoryType.deleteById(c.getId()).thenReturn(c));
	}
	

}
