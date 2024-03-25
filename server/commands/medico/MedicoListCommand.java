package trabalho.server.commands.medico;

import trabalho.server.commands.CrudCommand;
import trabalho.server.models.Medico;
import trabalho.server.repositories.Repository;
import trabalho.server.services.ServiceLocator;

import java.util.List;

public class MedicoListCommand implements CrudCommand<Medico> {
    @Override
    public String execute(String... args) throws Exception {
        Repository<Medico> repository = ServiceLocator.getRepository(Medico.class);
        List<Medico> medicos = repository.listAll();
        if (medicos.isEmpty()) {
            return "Nenhuma pessoa encontrada.";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Medico medico : medicos) {
            stringBuilder.append(medico.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
