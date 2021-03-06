package ru.ifmo.networks.balancer

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import ru.ifmo.networks.common.jsonSuccess
import ru.ifmo.networks.common.withDefaultHeader
import java.util.*
import kotlin.math.max

@Component
class BalancerHandler {

    companion object {
        var urls = listOf<String>()
        private val rnd = Random()
    }

    fun getNodeUrl(serverRequest: ServerRequest): Mono<ServerResponse> =
            ServerResponse.ok()
                    .withDefaultHeader()
                    .jsonSuccess(mapOf("result" to urls.getOrNull(rnd.nextInt(max(1, urls.size)))))
}