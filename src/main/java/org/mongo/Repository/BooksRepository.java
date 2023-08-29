package org.mongo.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.mongo.Entity.Books;
@ApplicationScoped
public class BooksRepository implements PanacheRepository<Books> {
}
