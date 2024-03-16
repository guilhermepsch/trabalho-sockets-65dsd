package trabalho.server.commands;

import trabalho.server.models.Person;
import trabalho.server.repositories.Repository;
import trabalho.server.services.ServiceLocator;

public class DeletePersonCommand implements CrudCommand<Person> {
    @Override
    public String execute(String... args) throws Exception {
        if (args.length != 1) {
            throw new Exception("Invalid number of arguments. Expected: cpf");
        }
        String cpf = args[0];
        Repository<Person> repository = ServiceLocator.getRepository(Person.class);
        Person person = repository.read(cpf);
        if (person == null) {
            throw new Exception("Person with CPF " + cpf + " not found.");
        }
        repository.delete(person.getCpf());
        return "Person deleted successfully.";
    }
}
