package org.hunngom.backend.domain;

import lombok.Data;

@Data
/**
 * Hungarian: (alap)szervezet
 */
public class Organisation {
    private long id;
    private String name;
    // TODO do we need it more structured and do we need multiple (official vs. mailing)?
    private String address;
}
