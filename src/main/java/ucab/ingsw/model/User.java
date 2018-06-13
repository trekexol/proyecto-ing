package ucab.ingsw.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@ToString
public class User  implements Serializable {
    @Id
    private long id;
    private String Token;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dateOfBirth;
    private List<Long> albumes = new ArrayList<>();
    private List<Long> socialFriends = new ArrayList<>();

    public void setId(long id) {
        this.id = id;
    }
    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public List<Long> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(List<Long> albumes) {
        this.albumes = albumes;
    }

    public List<Long> getSocialFriends() {
        return socialFriends;
    }

    public void setSocialFriends(List<Long> socialFriends) {
        this.socialFriends = socialFriends;
    }
