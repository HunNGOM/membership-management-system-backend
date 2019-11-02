package org.hunngom.backend.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hunngom.backend.domain.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class DemoDataLoader {

    private final MembershipTypeRepository membershipTypeRepository;
    private final OfficeRepository officeRepository;
    private final OrganisationRepository organisationRepository;
    private final PersonRepository personRepository;
    private final MembershipRepository membershipRepository;

    @Bean
    public CommandLineRunner initDemoData() {
        return args -> {
            MembershipType normalType = membershipTypeRepository.save(new MembershipType(null, "normál"));
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
            Organisation zuglo = organisationRepository.save(new Organisation(null, "Zugló", false, "adr2"));
            organisationRepository.save(new Organisation(null, "Kisújszállás", false, "adr3"));
            for (Organisation organisation : organisationRepository.findAll()) {
                log.info("{}", organisation);
            }

            Person gipszJakab = personRepository.save(new Person(null, "Gipsz Jakab", 19750101, "1234 Budapest, Varjú u. 3", "g.jakab@gmail.com", "+36701234567"));
            personRepository.save(new Person(null, "Nagy Ede", 19771202, "1224 Budapest, Sas u. 123", "ne@gmail.com", "+36201111111"));
            for (Person person : personRepository.findAll()) {
                log.info("{}", person);
            }

            membershipRepository.save(new Membership(null, gipszJakab, zuglo, 20191010, null, normalType));
            for (Membership membership : membershipRepository.findAll()) {
                log.info("{}", membership);
            }

        };
    }

}
