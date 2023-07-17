package in.ushatech.mastermicroservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Post
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id ;
    private  String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
}
