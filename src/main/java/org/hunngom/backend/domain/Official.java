package org.hunngom.backend.domain;

import lombok.Data;

@Data
/**
 * Hungarian: tisztségviselő
 */
public class Official {
    private long id;
    private Person official;
    private Organisation organisation;
    private int from;
    private Integer until; // will be null if still active
    private Office office;
}
