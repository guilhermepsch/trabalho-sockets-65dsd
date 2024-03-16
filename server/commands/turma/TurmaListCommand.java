package trabalho.server.commands.turma;

import trabalho.server.commands.CrudCommand;
import trabalho.server.models.Turma;
import trabalho.server.repositories.Repository;
import trabalho.server.services.ServiceLocator;

import java.util.List;

public class TurmaListCommand implements CrudCommand<Turma> {
    @Override
    public String execute(String... args) throws Exception {
        Repository<Turma> repository = ServiceLocator.getRepository(Turma.class);
        List<Turma> turmas = repository.listAll();
        if (turmas.isEmpty()) {
            return "Nenhuma turma encontrada.";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Turma turma : turmas) {
            stringBuilder.append(turma.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
