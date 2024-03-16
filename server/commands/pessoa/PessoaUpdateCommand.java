package trabalho.server.commands.pessoa;

import trabalho.server.commands.CrudCommand;
import trabalho.server.models.Pessoa;
import trabalho.server.repositories.Repository;
import trabalho.server.services.ServiceLocator;

public class PessoaUpdateCommand implements CrudCommand<Pessoa> {
    @Override
    public String execute(String... args) throws Exception {
        if (args.length != 3) {
            throw new Exception("Número inválido de argumentos. Esperado: cpf, nome, endereco");
        }
        String cpf = args[0];
        String newNome = args[1];
        String newEndereco = args[2];
        if (cpf.isEmpty() || newNome.isEmpty() || newEndereco.isEmpty()) {
            throw new Exception("Argumentos inválidos. Todos os campos não podem ser vazios.");
        }
        Repository<Pessoa> repository = ServiceLocator.getRepository(Pessoa.class);
        Pessoa person = repository.read(cpf);
        if (person == null) {
            throw new Exception("Uma pessoa com o mesmo cpf já existe.");
        }
        person.setNome(newNome);
        person.setEndereco(newEndereco);
        repository.update(person);
        return "Pessoa alterada com sucesso.";
    }
}
