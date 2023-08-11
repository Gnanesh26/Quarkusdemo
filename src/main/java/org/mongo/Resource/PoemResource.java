package org.mongo.Resource;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
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
    public List<Poem> getPoems() {
        return Poem.listAll();
    }

    @GET
    @Path("/poets")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get all poets")
    public List<Poet> getPoets() {
        return Poet.listAll();
    }


    @GET
    @Path("/poems/{poetId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get poems by poetId")
    public Response getPoemsByPoetId(@PathParam("poetId") ObjectId poetId) {
        List<Poem> poems = Poem.find("poems", poetId).list();
        return Response.ok(poems).build();
    }
}