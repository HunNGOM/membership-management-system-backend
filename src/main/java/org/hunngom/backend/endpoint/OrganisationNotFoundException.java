package org.hunngom.backend.endpoint;

public class OrganisationNotFoundException extends RuntimeException {

    OrganisationNotFoundException(Long id) {
        super("Could not find organisation " + id);
    }
}
