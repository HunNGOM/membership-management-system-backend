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
 * Hungarian: személy
 */
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_generator")
    @SequenceGenerator(name = "person_generator", sequenceName = "person_seq", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String name;
    // TODO discuss whether this is OK to represent dates or we should use some other object (like LocalDate)
    private int birthDay;
    // TODO clarify whether we need it stored more structured and whether we need to store multiple
    private String address;
    private String email;
    // TODO clarify whether we need it stored more structured and whether we need to store multiple
    private String phone;
}
