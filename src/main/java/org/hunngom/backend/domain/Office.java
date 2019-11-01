package org.hunngom.backend.domain;

import lombok.Data;

@Data
/**
 * Hungarian: tisztség
 */
public class Office {
    private long id;
    private String name; // for now we do not support multi-lingual UI
    private int allowedNumber; // how many individuals can have this office in an organisation
}
