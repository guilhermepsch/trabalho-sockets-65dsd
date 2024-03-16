package trabalho.server.commands.turma;

import trabalho.server.commands.CrudCommand;
import trabalho.server.models.Turma;
import trabalho.server.repositories.Repository;
import trabalho.server.services.ServiceLocator;

public class TurmaDeleteCommand implements CrudCommand<Turma> {
    @Override
    public String execute(String... args) throws Exception {
        if (args.length != 1) {
            throw new IllegalArgumentException("Número inválido de argumentos. Esperado: materia");
        }
        String materia = args[0];

        Repository<Turma> repository = ServiceLocator.getRepository(Turma.class);
        Turma turma = repository.read(materia);
        if (turma == null) {
            throw new Exception("Turma não encontrada.");
        }

        repository.delete(materia);
        return "Turma deletada com sucesso.";
    }
}
