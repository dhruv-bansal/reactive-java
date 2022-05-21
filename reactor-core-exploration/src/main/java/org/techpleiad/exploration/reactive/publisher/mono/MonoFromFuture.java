package org.techpleiad.exploration.reactive.publisher.mono;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class MonoFromFuture {


    Mono<String> getStrMono() {
        // use Just in case data is already been prepared
        // other just will already call getName()
        //Mono<String> strMono = Mono.just(getName());

        //correct way to do it
        // use fromSupplier
        // now getName will not be called unless somebody subscribes to this publisher mono
        Mono<String> strMono = Mono.fromFuture(
                () -> getName()
        );

        return strMono;
    }


    CompletableFuture<String> getName() {
        String fakeName = Faker.instance().name().firstName();
        CompletableFuture<String> stringCompletableFuture =
                CompletableFuture.supplyAsync(() -> fakeName);
        System.out.println("Fake number has been generated");
        return stringCompletableFuture;
    }

}
