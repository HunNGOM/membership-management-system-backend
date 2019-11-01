package org.hunngom.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
/**
 * Hungarian: (alap)szervezet
 */
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organisation_generator")
    @SequenceGenerator(name = "organisation_generator", sequenceName = "organisation_seq", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String name;
    private boolean central;
    // TODO do we need it more structured and do we need multiple (official vs. mailing)?
    private String address;
}
