package trabalho.server.commands.pessoa;

import trabalho.server.commands.CrudCommand;
import trabalho.server.models.Pessoa;
import trabalho.server.repositories.Repository;
import trabalho.server.services.ServiceLocator;

public class PessoaCreateCommand implements CrudCommand<Pessoa> {
    @Override
    public String execute(String... args) throws Exception {
        if (args.length != 3) {
            throw new Exception("Número inválido de argumentos. Esperado: cpf, nome, endereco");
        }
        String cpf = args[0];
        String nome = args[1];
        String endereco = args[2];
        if (cpf.isEmpty() || nome.isEmpty() || endereco.isEmpty()) {
            throw new Exception("Argumentos inválidos. Todos os campos não podem ser vazios.");
        }
        Repository<Pessoa> repository = ServiceLocator.getRepository(Pessoa.class);
        if (repository.read(cpf) != null) {
            throw new Exception("Uma pessoa com o mesmo cpf já existe.");
        }
        Pessoa person = new Pessoa(cpf, nome, endereco);
        repository.create(person);
        return "Pessoa criada com sucesso.";
    }

}
