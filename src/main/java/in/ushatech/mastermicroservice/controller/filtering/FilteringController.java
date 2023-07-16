package in.ushatech.mastermicroservice.controller.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import in.ushatech.mastermicroservice.domain.filtering.SomeBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController
{
    @GetMapping("/filter")
    public MappingJacksonValue filtering()
    {
        SomeBean someBean = new SomeBean("value1","value2","value3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
    @GetMapping("/filter/list")
    public MappingJacksonValue filteringList()
    {
        List<SomeBean> listSomeBeans= Arrays.asList(
                new SomeBean("value1","value2","value3"),
                new SomeBean("value4","value5","value6"),
                new SomeBean("value7","value8","value9")
        );
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(listSomeBeans);
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",simpleBeanPropertyFilter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}
