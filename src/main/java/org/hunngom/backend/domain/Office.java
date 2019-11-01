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
 * Hungarian: tisztség
 */
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "office_generator")
    @SequenceGenerator(name = "office_generator", sequenceName = "office_seq", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String name; // for now we do not support multi-lingual UI
    private int allowedNumber; // how many individuals can have this office in an organisation
}
