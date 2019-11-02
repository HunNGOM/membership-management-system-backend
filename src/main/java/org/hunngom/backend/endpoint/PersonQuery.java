package org.hunngom.backend.endpoint;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.hunngom.backend.domain.Person;
import org.hunngom.backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonQuery implements GraphQLQueryResolver {
    @Autowired
    private PersonService service;

    public List<Person> getPersons(final int count) {
        return service.getAll(count);
    }

    public Optional<Person> getPerson(final long id) {
        return service.findById(id);
    }
}
