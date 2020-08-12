package org.acme.getting.started;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletionStage;

import static java.util.concurrent.CompletableFuture.completedFuture;

@RegisterRestClient(baseUri = "http://localhost:8081/")
public interface HelloClient {
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)

    CompletionStage<String> get();

    default CompletionStage<String> fallback() {
        return completedFuture("Fallback");
    }
}
