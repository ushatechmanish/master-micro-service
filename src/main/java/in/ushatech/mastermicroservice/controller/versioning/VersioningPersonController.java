package in.ushatech.mastermicroservice.controller.versioning;

import in.ushatech.mastermicroservice.domain.Name;
import in.ushatech.mastermicroservice.domain.versioning.PersonV1;
import in.ushatech.mastermicroservice.domain.versioning.PersonV2;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController
{
    // url versioning - twitter
    // Drawbacks - URI Pollution
    // Advantage - Easy caching , documentation , can be executed on browser itself
    @GetMapping("/v1/person")
    private PersonV1 getFirstVersionName()
    {
        return new PersonV1("Manish Chauhan");
    }
    @GetMapping("/v2/person")
    private PersonV2 getSecondVersionName()
    {
        return new PersonV2(new Name("Manish", "Chauhan"));
    }

    // Request Paramter Version - Amazon
    // Drawbacks - URI Pollution
    // Advantage - Easy caching , documentation , can be executed on browser itself
    @GetMapping(path = "/person", params = "version=1")
    private PersonV1 getFirstVersionNameRequestParameter()
    {
        return new PersonV1("Manish Chauhan");
    }

    @GetMapping(path= "/person" , params = "version=2")
    private PersonV2 getSecondVersionNameRequestParameter()
    {
        return new PersonV2(new Name("Manish", "Chauhan"));
    }
    // Custome Headers Versioning - Microsoft
    //  Advantage - No URI Pollution
    // Drawbacks - No Easy caching ,No documentation support by API , can not be executed on browser itself
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    private PersonV1 getFirstVersionNameRequestHeader()
    {
        return new PersonV1("Manish Chauhan");
    }

    @GetMapping(path= "/person/header" , headers = "X-API-VERSION=2")
    private PersonV2 getSecondVersionNameRequestHeader()
    {
        return new PersonV2(new Name("Manish", "Chauhan"));
    }

//    Media Type versioning  a.k.a "Content Negotiation" or "accept Header" - Github
//  Advantage - No URI Pollution
// Drawbacks - No Easy caching ,No documentation support by API , can not be executed on browser itself
@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
private PersonV1 getFirstVersionNameMediaType()
{
    return new PersonV1("Manish Chauhan");
}
    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    private PersonV2 getSecondVersionNameMediaType()
    {
        return new PersonV2(new Name("Manish", "Chauhan"));
    }

}
