package org.hunngom.backend.endpoint;

import lombok.RequiredArgsConstructor;
import org.hunngom.backend.domain.Organisation;
import org.hunngom.backend.repository.OrganisationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequiredArgsConstructor
public class OrganisationController {

    private final OrganisationRepository organisationRepository;

    @GetMapping("/organisations")
    public List<Organisation> all() {
        return StreamSupport.stream(organisationRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping("/organisations/{id}")
    public Organisation one(@PathVariable Long id) {
        return organisationRepository.findById(id).orElseThrow(() -> new OrganisationNotFoundException(id));
    }
}
