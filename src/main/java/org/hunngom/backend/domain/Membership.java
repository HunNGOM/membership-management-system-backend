package org.hunngom.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Membership {
    //TODO Check whether the membership member should stay the same if a member moves between organisations
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "membership_generator")
    @SequenceGenerator(name = "membership_generator", sequenceName = "membership_seq", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person member;
    @ManyToOne
    @JoinColumn(name = "organisation_id", nullable = false)
    private Organisation organisation;
    private int fromDate;
    private Integer untilDate; // will be null if still active
    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private MembershipType type;
}
