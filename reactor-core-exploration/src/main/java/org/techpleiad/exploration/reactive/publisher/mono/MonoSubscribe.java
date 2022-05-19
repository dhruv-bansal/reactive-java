package org.techpleiad.exploration.reactive.publisher.mono;

import reactor.core.publisher.Mono;

import java.util.function.Consumer;

class MonoSubscribe {

    Mono simpleStringMono() {

        Mono<String> mono = Mono.just("testString");
        return mono;
    }

    void monoSubscribe() {
        Mono strMono = simpleStringMono();

        //TODO: What is @see reactor.core.Disposable
        System.out.println(strMono.subscribe());
    }

    void monoSubscribeWithConsumer() {

        Mono strMono = simpleStringMono();

        strMono.subscribe(System.out::println,
                (Consumer<Throwable>) err -> err.printStackTrace(),
                () -> System.out.println("publisher completed")
        );

    }

    public static void main(String[] args) {

        MonoSubscribe monoSubscribe = new MonoSubscribe();
        monoSubscribe.monoSubscribeWithConsumer();
    }
}
