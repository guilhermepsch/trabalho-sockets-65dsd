package trabalho.server.commands.pessoa;

import trabalho.server.commands.CrudCommand;
import trabalho.server.models.Pessoa;
import trabalho.server.repositories.Repository;
import trabalho.server.services.ServiceLocator;

import java.util.List;

public class PessoaListCommand implements CrudCommand<Pessoa> {
    @Override
    public String execute(String... args) throws Exception {
        Repository<Pessoa> repository = ServiceLocator.getRepository(Pessoa.class);
        List<Pessoa> people = repository.listAll();
        if (people.isEmpty()) {
            return "Nenhuma pessoa encontrada.";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Pessoa person : people) {
            stringBuilder.append(person.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
