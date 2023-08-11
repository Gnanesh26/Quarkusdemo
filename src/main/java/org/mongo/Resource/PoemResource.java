package org.mongo.Resource;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.mongo.Entity.Poem;
import org.mongo.Entity.Poet;

import java.util.List;
@Path("/")
public class PoemResource {


    @GET
    @Path("/poems")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get all poems")
    public List<Poem> getPoems() {return Poem.listAll();}

    @GET
    @Path("/poets")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get all poets")
    public List<Poet> getPoets() {return Poet.listAll();}}
