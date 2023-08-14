package org.mongo.Repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.mongo.Entity.Poem;

@ApplicationScoped
public class PoemRepo implements PanacheMongoRepository<Poem> {

    public Poem findByName(String poemName) {
        return find("poemName", poemName).firstResult();
    }
}
