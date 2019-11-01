package org.hunngom.backend.domain;

import lombok.Data;

@Data
public class Membership {
    //TODO Check whether the membership member should stay the same if a member moves between organisations
    private long id;
    private Person member;
    private Organisation organisation;
    private int from;
    private Integer until; // will be null if still active
    private MembershipType type;
}
