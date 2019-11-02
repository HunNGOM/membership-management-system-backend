package org.hunngom.backend.service;

import lombok.RequiredArgsConstructor;
import org.hunngom.backend.domain.Organisation;
import org.hunngom.backend.repository.OrganisationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrganisationService {

    private final OrganisationRepository repository;

    @Transactional(readOnly = true)
    public List<Organisation> getAll(final int count) {
        return repository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Organisation> findById(final long id) {
        return repository.findById(id);
    }
}
