package org.techpleiad.exploration.reactive.publisher.mono;

import reactor.core.publisher.Mono;

class MonoOnError {

    void monoSimpleError() {
        Mono<Integer> erroredDataMono = Mono.just("testData")
                .map(String::length)
                .map(len -> len / 0);

        erroredDataMono.subscribe();
    }

    public static void main(String[] args) {

        MonoOnError monoOnError = new MonoOnError();

        monoOnError.monoSimpleError();
    }
}
