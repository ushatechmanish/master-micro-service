package in.ushatech.mastermicroservice.domain.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties({"field1","field2"})
public class SomeBean
{
    @JsonIgnore
    private String field1;
    private String field2;
    private String field3;
}
