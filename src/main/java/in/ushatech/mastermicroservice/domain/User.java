package in.ushatech.mastermicroservice.domain;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class User
{

    private  Integer userId;
    @Size(min = 2, message = "The user name should be minimum 2 character length")
    private  String name;
    @Past(message = "Birth Date should be in the past")
    private  LocalDate birthDate;
}
