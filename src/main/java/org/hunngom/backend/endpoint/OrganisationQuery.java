package org.hunngom.backend.endpoint;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.hunngom.backend.domain.Organisation;
import org.hunngom.backend.service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrganisationQuery implements GraphQLQueryResolver {
    @Autowired
    private OrganisationService service;

    public List<Organisation> getOrganisations(final int count) {
        return service.getAll(count);
    }

    public Optional<Organisation> getOrganisation(final long id) {
        return service.findById(id);
    }
}
