package design_patterns.structural.filter;

import java.util.List;

@FunctionalInterface
public interface Criteria {

    List<PersonEntity> meetCriteria(List<PersonEntity> persons);
}
