package in.ushatech.mastermicroservice.controller.filtering;

import in.ushatech.mastermicroservice.domain.filtering.SomeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController
{
    @GetMapping("/filter")
    public SomeBean filtering()
    {
        return new SomeBean("value1","value2","value3");
    }
    @GetMapping("/filter/list")
    public List<SomeBean> filteringList()
    {
        return Arrays.asList(
                new SomeBean("value1","value2","value3"),
                new SomeBean("value4","value5","value6"),
                new SomeBean("value7","value8","value9")
        );
    }
}
