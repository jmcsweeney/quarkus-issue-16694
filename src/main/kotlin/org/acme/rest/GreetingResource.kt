package org.acme.rest

import io.quarkus.security.identity.SecurityIdentity
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType


@Path("/greeting")
class GreetingResource {

    @Inject
    lateinit var identity: SecurityIdentity

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): String? {
        return String.format("Hello, %s", identity.principal.name)
    }
}