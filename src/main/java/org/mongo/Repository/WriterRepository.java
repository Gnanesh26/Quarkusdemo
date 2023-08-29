package org.mongo.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.mongo.Entity.Writer;
@ApplicationScoped
public class WriterRepository implements PanacheRepository<Writer> {
}
