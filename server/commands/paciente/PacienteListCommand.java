package trabalho.server.commands.paciente;

import trabalho.server.commands.CrudCommand;
import trabalho.server.models.Paciente;
import trabalho.server.repositories.Repository;
import trabalho.server.services.ServiceLocator;

import java.util.List;

public class PacienteListCommand implements CrudCommand<Paciente> {
    @Override
    public String execute(String... args) throws Exception {
        Repository<Paciente> repository = ServiceLocator.getRepository(Paciente.class);
        List<Paciente> pacientes = repository.listAll();
        if (pacientes.isEmpty()) {
            return "Nenhuma pessoa encontrada.";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Paciente paciente : pacientes) {
            stringBuilder.append(paciente.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
