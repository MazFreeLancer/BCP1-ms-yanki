package com.nttdata.bcp1.msyanki.controller;

import com.nttdata.bcp1.msyanki.model.Yanki;
import com.nttdata.bcp1.msyanki.service.YankiService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/yanki")
public class YankiController {
    private final YankiService service;

    @PostMapping
    public Mono<Yanki> save(@RequestBody Yanki yanki) {
        return  service.save(yanki);
    }

    @GetMapping()
    public Flux<Yanki> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Yanki> findById(@PathVariable("key") String key) {
        return service.findById(key);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")String id) {
        service.delete(id);
    }

    @PostMapping("sendTo/{phoneNumberTo}/{amount}")
    public Mono<Yanki> sendPayments(@PathVariable("phoneNumberTo") String phoneNumberTo,
                                @RequestBody Yanki yanki,
                                @PathVariable("amount") Double amount){
        return service.sendPayments(yanki, phoneNumberTo, amount);
    }
}
