package org.techpleiad.exploration.reactive.publisher.mono;

import reactor.core.publisher.Mono;

class MonoBasics {

    Mono simpleIntegerMono() {

        Mono<Integer> mono = Mono.just(1);
        return mono;
    }


}
