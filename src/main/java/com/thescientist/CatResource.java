package com.thescientist;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.jboss.logging.Logger;

@Path("/kitty")
public class CatResource {

    private static final Logger LOGGER = Logger.getLogger(CatResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return meow();
    }

    @CircuitBreaker(requestVolumeThreshold = 4)
    String meow() {
        if(new Random().nextBoolean()) {
            return "Meow";
        } else {
            LOGGER.error("failed!");
            throw new RuntimeException("Resource failure.");
        }
    }
}