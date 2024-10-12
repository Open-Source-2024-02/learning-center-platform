package pe.upc.learningcenterplatform.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record EmailAddress (String address){
    public EmailAddress(){
        this(null);
    }
    public EmailAddress {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Email address must not be empty");
        }
        if (!address.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new IllegalArgumentException("Email address is invalid");
        }
    }
}
