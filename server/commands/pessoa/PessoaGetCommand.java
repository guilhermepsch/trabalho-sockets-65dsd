package trabalho.server.commands.pessoa;

import trabalho.server.commands.CrudCommand;
import trabalho.server.models.Pessoa;
import trabalho.server.repositories.Repository;
import trabalho.server.services.ServiceLocator;

public class PessoaGetCommand implements CrudCommand<Pessoa> {
    @Override
    public String execute(String... args) throws Exception {
        if (args.length != 1) {
            throw new Exception("Número inválido de argumentos. Esperado: cpf");
        }
        String cpf = args[0];
        Repository<Pessoa> repository = ServiceLocator.getRepository(Pessoa.class);
        Pessoa person = repository.read(cpf);
        if (person == null) {
            throw new Exception("Pessoa com o CPF " + cpf + " não encontrada.");
        }
        return person.toString();
    }
}
