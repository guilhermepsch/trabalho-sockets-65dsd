package trabalho.server.commands.paciente;

import trabalho.server.commands.CrudCommand;
import trabalho.server.models.Paciente;
import trabalho.server.repositories.Repository;
import trabalho.server.services.ServiceLocator;

public class PacienteCreateCommand implements CrudCommand<Paciente> {
    @Override
    public String execute(String... args) throws Exception {
        if (args.length != 4) {
            throw new Exception("Número inválido de argumentos. Esperado: cpf, nome, endereco, historicoMedico");
        }
        String cpf = args[0];
        String nome = args[1];
        String endereco = args[2];
        String historicoMedico = args[3];
        if (cpf.isEmpty() || nome.isEmpty() || endereco.isEmpty() || historicoMedico.isEmpty()) {
            throw new Exception("Argumentos inválidos. Todos os campos não podem ser vazios.");
        }
        Repository<Paciente> repository = ServiceLocator.getRepository(Paciente.class);
        if (repository.read(cpf) != null) {
            throw new Exception("Uma pessoa com o mesmo cpf já existe.");
        }
        Paciente medico = new Paciente(cpf, nome, endereco, historicoMedico);
        repository.create(medico);
        return "Paciente criado com sucesso.";
    }
}
