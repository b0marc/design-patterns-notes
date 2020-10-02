package design_patterns.structural.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaName implements Criteria {

    private String filterName;

    public CriteriaName(String name) {
        this.filterName = name;
    }

    @Override
    public List<PersonEntity> meetCriteria(List<PersonEntity> persons) {
        List<PersonEntity> personsFilter = new ArrayList<>();

        for (PersonEntity person : persons) {
            if (person.getName().equals(this.filterName)) {
                personsFilter.add(person);
            }
        }
        return personsFilter;
    }
}
