package org.hunngom.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MembershipType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "membership_type_generator")
    @SequenceGenerator(name = "membership_type_generator", sequenceName = "membership_type_seq", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String name; // for now we do not support multi-lingual UI
}
