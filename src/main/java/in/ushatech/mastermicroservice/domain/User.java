package in.ushatech.mastermicroservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity(name ="user_details")
@NoArgsConstructor
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
//    at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:50) ~[spring-boot-devtools-3.1.1.jar:3.1.1]
//    Caused by: org.hibernate.AnnotationException: Collection 'in.ushatech.mastermicroservice.domain.User.posts' is 'mappedBy' a property named 'user_id' which does not exist in the target entity 'in.ushatech.mastermicroservice.domain.Post'

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private final List<Post> posts = new ArrayList<>(); // final instance variables are ignored for AllArgsConstructor
    @JsonProperty("user_name")
    @Size(min = 2, message = "The user name should be minimum 2 character length")
    private  String name;
    @JsonProperty("user_dob")
    @Past(message = "Birth Date should be in the past")
    private  LocalDate birthDate;

}
