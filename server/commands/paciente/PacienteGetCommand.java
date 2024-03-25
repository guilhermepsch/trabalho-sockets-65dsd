package trabalho.server.commands.paciente;

import trabalho.server.commands.CrudCommand;
import trabalho.server.models.Paciente;
import trabalho.server.repositories.Repository;
import trabalho.server.services.ServiceLocator;

public class PacienteGetCommand implements CrudCommand<Paciente> {
    @Override
    public String execute(String... args) throws Exception {
        if (args.length != 1) {
            throw new Exception("Número inválido de argumentos. Esperado: cpf");
        }
        String cpf = args[0];
        Repository<Paciente> repository = ServiceLocator.getRepository(Paciente.class);
        Paciente paciente = repository.read(cpf);
        if (paciente == null) {
            throw new Exception("Médico com o CPF " + cpf + " não encontrado.");
        }
        return paciente.toString();
    }
}
