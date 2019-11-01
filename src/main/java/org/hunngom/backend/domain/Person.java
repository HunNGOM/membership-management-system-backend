package org.hunngom.backend.domain;

import lombok.Data;

@Data
/**
 * Hungarian: személy
 */
public class Person {
    private long id;
    private String name;
    // TODO discuss whether this is OK to represent dates or we should use some other object (like LocalDate)
    private int birthDay;
    // TODO clarify whether we need it stored more structured and whether we need to store multiple
    private String address;
    private String email;
    // TODO clarify whether we need it stored more structured and whether we need to store multiple
    private String phone;
}
