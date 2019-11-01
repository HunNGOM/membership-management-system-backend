package org.hunngom.backend.domain;

import lombok.Data;

@Data
public class MembershipType {
    private long id;
    private String name; // for now we do not support multi-lingual UI
}
