package pe.upc.learningcenterplatform.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record PersonName (String FirstName, String LastName){
    public PersonName(){
        this(null, null);
    }
    public PersonName {
        if (FirstName == null || FirstName.isBlank()) {
            throw new IllegalArgumentException("First name must not be empty");
        }
        if (LastName == null || LastName.isBlank()) {
            throw new IllegalArgumentException("Last name must not be empty");
        }
    }
    public String getFullName() {
        return String.format("%s %s", FirstName, LastName);
    }
}
