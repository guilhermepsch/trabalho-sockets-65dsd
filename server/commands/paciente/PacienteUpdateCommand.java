package trabalho.server.commands.paciente;

import trabalho.server.commands.CrudCommand;
import trabalho.server.models.Paciente;
import trabalho.server.repositories.Repository;
import trabalho.server.services.ServiceLocator;

public class PacienteUpdateCommand implements CrudCommand<Paciente> {
    @Override
    public String execute(String... args) throws Exception {
        if (args.length != 4) {
            throw new Exception("Número inválido de argumentos. Esperado: cpf, nome, endereco, historicoMedico");
        }
        String cpf = args[0];
        String newNome = args[1];
        String newEndereco = args[2];
        String newHistoricoMedico = args[3];
        if (cpf.isEmpty() || newNome.isEmpty() || newEndereco.isEmpty() || newHistoricoMedico.isEmpty()) {
            throw new Exception("Argumentos inválidos. Todos os campos não podem ser vazios.");
        }
        Repository<Paciente> repository = ServiceLocator.getRepository(Paciente.class);
        Paciente paciente = repository.read(cpf);
        if (paciente == null) {
            throw new Exception("Uma pessoa com o mesmo cpf já existe.");
        }
        paciente.setNome(newNome);
        paciente.setEndereco(newEndereco);
        paciente.setHistoricoMedico(newHistoricoMedico);
        repository.update(paciente);
        return "Paciente alterado com sucesso.";
    }
}
