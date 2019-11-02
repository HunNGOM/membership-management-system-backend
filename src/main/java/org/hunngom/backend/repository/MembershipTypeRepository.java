package org.hunngom.backend.repository;

import org.hunngom.backend.domain.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipTypeRepository extends JpaRepository<MembershipType, Long> {

}
