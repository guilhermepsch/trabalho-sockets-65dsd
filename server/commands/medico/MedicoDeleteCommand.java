package trabalho.server.commands.medico;

import trabalho.server.commands.CrudCommand;
import trabalho.server.models.Medico;
import trabalho.server.repositories.Repository;
import trabalho.server.services.ServiceLocator;

public class MedicoDeleteCommand implements CrudCommand<Medico> {
    @Override
    public String execute(String... args) throws Exception {
        if (args.length != 1) {
            throw new Exception("Número inválido de argumentos. Esperado: cpf");
        }
        String cpf = args[0];
        Repository<Medico> repository = ServiceLocator.getRepository(Medico.class);
        Medico medico = repository.read(cpf);
        if (medico == null) {
            throw new Exception("Médico com o CPF " + cpf + " não encontrado.");
        }
        repository.delete(medico.getCpf());
        return "Médico deletado com sucesso.";
    }
}
