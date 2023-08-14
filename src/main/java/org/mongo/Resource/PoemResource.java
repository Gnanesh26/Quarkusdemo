package org.mongo.Resource;

import io.quarkus.mongodb.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.mongo.Entity.Poem;
import org.mongo.Entity.Poet;
import org.mongo.Repository.PoemRepo;

import java.util.List;
@Path("/")
public class PoemResource {


    @Inject
    PoemRepo poemRepo;

    @GET
    @Path("/poems")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get all poems")
    public List<Poem> getPoems() {
        return Poem.listAll();}

    @GET
    @Path("/page1")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Poem> pageList() {
        PanacheQuery<Poem> poems = Poem.findAll();
        poems.page(Page.ofSize(2));
        return poems.list();}

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
        return Response.ok(poems).build();}





    @GET
    @Path("/{poemName}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Poem findByName(@PathParam("poemName") String poemName) {
        Poem poem = poemRepo.findByName(poemName);
        if (poem == null) {throw new NotFoundException("Poem not found");}
        return poem;}








//    @GET
//    @Path("/poems/{poetId}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Operation(summary = "Get poems by poetId")
//    public Response getPoemsByPoetId(@PathParam("poetId") ObjectId poetId) {
//        Poet poet = Poet.findById(poetId);
//        if (poet == null) {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }
//        List<String> poemIds = poet.getPoems();
//        if (poemIds == null || poemIds.isEmpty()) {
//            return Response.ok(Collections.emptyList()).build();
//        }
//        System.out.println("Poem IDs to fetch: " + poemIds);
//        String query = String.format("{ \"_id\": { $in: [ObjectId(\"64d5d056b62b9feb3b96aeb0\"), ObjectId(\"64d5d0a4b62b9feb3b96aeb2\")]}}");
//        System.out.println("Constructed query: " + query);
//        List<Poem> poems = Poem.find(query).list();
//        return Response.ok(poems).build();
//    }
}