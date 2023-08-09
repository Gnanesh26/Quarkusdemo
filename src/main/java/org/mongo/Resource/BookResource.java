package org.mongo.Resource;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.mongo.Entity.Book;

import java.util.List;

@Path("/books")
public class BookResource {

    @GET
    @Operation(summary = "Get a list of books")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks() {
        return Book.listAll();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Create a new book")
    public Response createBook(Book book) {
        book.persist();
        return Response.status(Response.Status.CREATED).entity(book).build();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get a book by ID")
    public Book getBookById(@PathParam("id") String id) {
        return Book.findById(new ObjectId(id));
    }


    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Delete a book by id")
    public Response deleteBook(@PathParam("id") ObjectId id) {
        Book.deleteById(id);
        return Response.status(Response.Status.OK).build();
    }
}