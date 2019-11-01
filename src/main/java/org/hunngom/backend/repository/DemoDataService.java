package org.hunngom.backend.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hunngom.backend.domain.MembershipType;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@AllArgsConstructor
@Slf4j
public class DemoDataService {

    private MembershipTypeRepository membershipTypeRepository;

    @PostConstruct
    public void init() {
        membershipTypeRepository.save(new MembershipType(1L, "normál"));
        membershipTypeRepository.save(new MembershipType(2L, "diák"));
        membershipTypeRepository.save(new MembershipType(3L, "nyugdíjas"));
        log.info("Finding membership type with id 2");
        membershipTypeRepository.findById(2L).ifPresent(v -> log.info("Found {}", v));
        log.info("All membership types:");
        for (MembershipType membershipType : membershipTypeRepository.findAll()) {
            log.info("{}", membershipType);
        }

    }

}
