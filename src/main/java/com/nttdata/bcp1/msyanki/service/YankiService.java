package com.nttdata.bcp1.msyanki.service;

import com.nttdata.bcp1.msyanki.model.MessageDTO;
import com.nttdata.bcp1.msyanki.model.Yanki;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface YankiService {
    Mono<Yanki> save(Yanki yanki);
    Flux<Yanki> findAll();
    Mono<Yanki> findById(String id);
    void delete(String id);

    Mono<Yanki> findByPhoneNumber(String phoneNumber);
    void recibePayments(MessageDTO message);
    Mono<Yanki> sendPayments(Yanki yanki, String phoneNumberTo, Double amount);

}
