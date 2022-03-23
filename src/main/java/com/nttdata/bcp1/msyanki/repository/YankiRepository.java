package com.nttdata.bcp1.msyanki.repository;

import com.nttdata.bcp1.msyanki.model.Yanki;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface YankiRepository extends ReactiveMongoRepository<Yanki, String> {
    public Mono<Yanki> findByPhoneNumber(String phoneNumber);
}
