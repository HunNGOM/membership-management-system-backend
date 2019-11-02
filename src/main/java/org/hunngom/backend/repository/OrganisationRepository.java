package org.hunngom.backend.repository;

import org.hunngom.backend.domain.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepository extends JpaRepository<Organisation, Long> {

}
