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
import org.mongo.Entity.Post;
import org.mongo.Entity.User;

import java.util.List;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {




    @GET
    @Path("/users")
    @Operation(summary = "Get all users")

    public List<User> getBooks() {
        return User.listAll();
    }


    @GET
    @Path("/posts")
    @Operation(summary = "Get all posts")
    public  List<Post> getPosts(){
        return Post.listAll();
    }

    @GET
    @Path("/users/{userId}")
    public Response getPostsByUserId(@PathParam("userId") ObjectId userId){
        List<Post>posts= Post.find("author",userId).list();
        return Response.ok(posts).build();
    }
}
