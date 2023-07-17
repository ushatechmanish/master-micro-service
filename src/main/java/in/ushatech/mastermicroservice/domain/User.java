package in.ushatech.mastermicroservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity(name ="user_details")
@NoArgsConstructor
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer userId;

    @JsonProperty("user_name")
    @Size(min = 2, message = "The user name should be minimum 2 character length")
    private  String name;
    @JsonProperty("user_dob")
    @Past(message = "Birth Date should be in the past")
    private  LocalDate birthDate;

}
