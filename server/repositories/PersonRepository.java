package trabalho.server.repositories;

import trabalho.server.models.Person;

import java.util.HashMap;
import java.util.Map;

public class PersonRepository implements Repository<Person>{

    private Map<String, Person> people = new HashMap<>();

    @Override
    public void create(Person person) {
        people.put(person.getCpf(), person);
    }

    @Override
    public Person read(String cpf) {
        return people.get(cpf);
    }

    @Override
    public void update(Person person) {
        people.put(person.getCpf(), person);
    }

    @Override
    public void delete(String cpf) {
        people.remove(cpf);
    }

}
