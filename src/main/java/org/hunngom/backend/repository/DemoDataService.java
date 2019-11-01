package org.hunngom.backend.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hunngom.backend.domain.MembershipType;
import org.hunngom.backend.domain.Office;
import org.hunngom.backend.domain.Organisation;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@AllArgsConstructor
@Slf4j
public class DemoDataService {

    private MembershipTypeRepository membershipTypeRepository;
    private OfficeRepository officeRepository;
    private OrganisationRepository organisationRepository;

    @PostConstruct
    public void init() {
        membershipTypeRepository.save(new MembershipType(null, "normál"));
        membershipTypeRepository.save(new MembershipType(null, "diák"));
        membershipTypeRepository.save(new MembershipType(null, "nyugdíjas"));
        log.info("Finding membership type with id 2");
        membershipTypeRepository.findById(2L).ifPresent(v -> log.info("Found {}", v));
        log.info("All membership types:");
        for (MembershipType membershipType : membershipTypeRepository.findAll()) {
            log.info("{}", membershipType);
        }

        officeRepository.save(new Office(null, "elnök", 1));
        officeRepository.save(new Office(null, "alelnök", 2));
        for (Office office : officeRepository.findAll()) {
            log.info("{}", office);
        }

        organisationRepository.save(new Organisation(null, "központ", true, "adr1"));
        organisationRepository.save(new Organisation(null, "Zugló", false, "adr2"));
        organisationRepository.save(new Organisation(null, "Kisújszállás", false, "adr3"));
        for (Organisation organisation : organisationRepository.findAll()) {
            log.info("{}", organisation);
        }

    }

}
