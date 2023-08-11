package org.mongo.Resource;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.mongo.Entity.Book;


import java.util.List;

@Path("/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @GET
    @Operation(summary = "Get a list of books")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks() {
        return Book.listAll();
    }


    @POST
    @Operation(summary = "Create a new book")
    public Response createBook(Book book) {
        book.persist();
        return Response.status(Response.Status.CREATED).entity(book).build();
    }


    @GET
    @Path("/{id}")
    @Operation(summary = "Get a book by ID")
    public Book getBookById(@PathParam("id") String id) {
        return Book.findById(new ObjectId(id));
    }


    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete a book by id")
    public Response deleteBook(@PathParam("id") ObjectId id) {
        Book.deleteById(id);
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Path("/updateBook")
    @Operation(summary = "Update book pages and rating by title")
    public Response updateBookPagesAndRatingByTitle(Book updatedBook) {
        String title = updatedBook.getTitle();
        int newPages = updatedBook.getPages();

        // Find the existing book by title in MongoDB
        Book existingBook = Book.find("title", title).firstResult();

        if (existingBook == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Book not found").build();
        }

        // Update the properties of the existing book
        existingBook.setPages(newPages);

        // Save the changes to the db
        existingBook.update();

        return Response.ok(existingBook).build();
    }
}











