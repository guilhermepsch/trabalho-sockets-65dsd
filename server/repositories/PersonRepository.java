package trabalho.server.repositories;

import trabalho.server.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements Repository<Person> {

    private final List<Person> people = new ArrayList<>();

    @Override
    public void create(Person person) {
        people.add(person);
    }

    @Override
    public Person read(String cpf) {
        for (Person person : people) {
            if (person.getCpf().equals(cpf)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public void update(Person person) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getCpf().equals(person.getCpf())) {
                people.set(i, person);
                break;
            }
        }
    }

    @Override
    public void delete(String cpf) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getCpf().equals(cpf)) {
                people.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Person> listAll() {
        return new ArrayList<>(people);
    }
}
