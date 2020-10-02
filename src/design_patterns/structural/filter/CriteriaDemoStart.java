package design_patterns.structural.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CriteriaDemoStart {

    public static void main(String[] args) {
        List<PersonEntity> persons = generateEntities();

        /*Enfoque tradicional para filtrar una coleccion, resulta poco
        * practico y con mucho codigo repetitivo. Ejmeplo de filtrado solo
        * por nombre, pero es posible aniadir operaciones OR y AND*/
        List<PersonEntity> filterPersons =
                new CriteriaName("Alvaro").meetCriteria(persons);

        filterPersons.forEach(s -> System.out.println(s.getName()));
        System.out.println("----------------");

        //Filtrado con predicado mediante streams que sustituye al Filter design pattern
        List<PersonEntity> pFiltradas = persons.stream()
                .filter(p -> p.getGender().equals("male"))
                .filter(p -> p.getAge() == 41)
                .collect(Collectors.toList());

        pFiltradas.forEach((p)-> System.out.println(p.getName() + " " + p.getAge()));
    }


    private static List<PersonEntity> generateEntities() {
        return Arrays.asList(new PersonEntity("Alicia", "female", 31),
                new PersonEntity("Jose", "male", 19),
                new PersonEntity("Albert", "male", 29),
                new PersonEntity("Veronica", "female", 41),
                new PersonEntity("David", "male", 41),
                new PersonEntity("Alvaro", "male", 41),
                new PersonEntity("Alvaro", "male", 55));
    }
}
