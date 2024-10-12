package pe.upc.learningcenterplatform.profiles.domain.model.aggregates;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import pe.upc.learningcenterplatform.profiles.domain.model.valueobjects.EmailAddress;
import pe.upc.learningcenterplatform.profiles.domain.model.valueobjects.PersonName;
import pe.upc.learningcenterplatform.profiles.domain.model.valueobjects.StreetAddress;
import pe.upc.learningcenterplatform.shared.domain.model.entities.AuditableAbstractAggregateRoot;

@Entity
@Getter
@Setter
public class Profile extends AuditableAbstractAggregateRoot<Profile> {
    @Embedded
    private PersonName name;

    @Embedded
    EmailAddress emailAddress;

    @Embedded
    private StreetAddress address;

    public Profile() {

    }

    public Profile(String firstName, String lastName, String email, String street, String number, String city, String postalCode, String country) {
        this.name = new PersonName(firstName, lastName);
        this.emailAddress = new EmailAddress(email);
        this.address = new StreetAddress(street, number, city, postalCode, country);
    }

    public String getFullName() {
        return name.getFullName();
    }

    public String getStreetAddress() {
        return address.getStreetAddress();
    }

    public String getEmailAddress() {
        return emailAddress.address();
    }
}
