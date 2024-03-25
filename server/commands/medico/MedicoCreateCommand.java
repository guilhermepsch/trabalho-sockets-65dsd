package trabalho.server.commands.medico;

import trabalho.server.commands.CrudCommand;
import trabalho.server.models.Medico;
import trabalho.server.repositories.Repository;
import trabalho.server.services.ServiceLocator;

public class MedicoCreateCommand implements CrudCommand<Medico> {
    @Override
    public String execute(String... args) throws Exception {
        if (args.length != 4) {
            throw new Exception("Número inválido de argumentos. Esperado: cpf, nome, endereco, especialização");
        }
        String cpf = args[0];
        String nome = args[1];
        String endereco = args[2];
        String especializacao = args[3];
        if (cpf.isEmpty() || nome.isEmpty() || endereco.isEmpty() || especializacao.isEmpty()) {
            throw new Exception("Argumentos inválidos. Todos os campos não podem ser vazios.");
        }
        Repository<Medico> repository = ServiceLocator.getRepository(Medico.class);
        if (repository.read(cpf) != null) {
            throw new Exception("Uma pessoa com o mesmo cpf já existe.");
        }
        Medico medico = new Medico(cpf, nome, endereco, especializacao);
        repository.create(medico);
        return "Médico criado com sucesso.";
    }
}
