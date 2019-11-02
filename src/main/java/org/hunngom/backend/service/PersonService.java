package org.hunngom.backend.service;

import lombok.RequiredArgsConstructor;
import org.hunngom.backend.domain.Person;
import org.hunngom.backend.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    @Transactional(readOnly = true)
    public List<Person> getAll(final int count) {
        return repository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Person> findById(final long id) {
        return repository.findById(id);
    }
}
