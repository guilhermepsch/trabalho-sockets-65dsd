package trabalho.server.commands;

import trabalho.server.models.Person;
import trabalho.server.repositories.Repository;
import trabalho.server.services.ServiceLocator;

import java.util.List;

public class ListPersonCommand implements CrudCommand<Person> {
    @Override
    public String execute(String... args) throws Exception {
        Repository<Person> repository = ServiceLocator.getRepository(Person.class);
        List<Person> people = repository.listAll();
        if (people.isEmpty()) {
            return "No people found.";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person : people) {
            stringBuilder.append(person.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
