package trabalho.server.commands;

import trabalho.server.models.Person;
import trabalho.server.repositories.Repository;
import trabalho.server.services.ServiceLocator;

public class UpdatePersonCommand implements CrudCommand<Person> {
    @Override
    public String execute(String... args) throws Exception {
        if (args.length != 3) {
            throw new Exception("Invalid number of arguments. Expected: cpf, newNome, newEndereco");
        }
        String cpf = args[0];
        String newNome = args[1];
        String newEndereco = args[2];
        if (cpf.isEmpty() || newNome.isEmpty() || newEndereco.isEmpty()) {
            throw new Exception("Invalid arguments. All fields must be non-empty.");
        }
        Repository<Person> repository = ServiceLocator.getRepository(Person.class);
        Person person = repository.read(cpf);
        if (person == null) {
            throw new Exception("Person with CPF " + cpf + " not found.");
        }
        person.setNome(newNome);
        person.setEndereco(newEndereco);
        repository.update(person);
        return "Person updated successfully.";
    }
}
