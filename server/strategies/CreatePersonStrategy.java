package trabalho.server.strategies;

import trabalho.server.models.Person;
import trabalho.server.repositories.Repository;
import trabalho.server.services.ServiceLocator;

import java.util.List;

public class CreatePersonStrategy implements CrudStrategy<Person> {
    @Override
    public String execute(String... args) throws Exception {
        if (args.length != 3) {
            throw new Exception("Invalid number of arguments. Expected: cpf, nome, endereco");
        }
        String cpf = args[0];
        String nome = args[1];
        String endereco = args[2];
        if (cpf.isEmpty() || nome.isEmpty() || endereco.isEmpty()) {
            throw new Exception("Invalid arguments. All fields must be non-empty.");
        }
        Repository<Person> repository = ServiceLocator.getRepository(Person.class);
        if (repository.read(cpf) != null) {
            throw new Exception("A person with the same CPF already exists.");
        }
        Person person = new Person(cpf, nome, endereco);
        repository.create(person);
        return "Person created successfully.";
    }

}
