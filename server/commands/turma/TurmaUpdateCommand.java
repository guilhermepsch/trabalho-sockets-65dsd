package trabalho.server.commands.turma;

import trabalho.server.commands.CrudCommand;
import trabalho.server.models.Pessoa;
import trabalho.server.models.Turma;
import trabalho.server.repositories.Repository;
import trabalho.server.services.ServiceLocator;

public class TurmaUpdateCommand implements CrudCommand<Turma> {
    @Override
    public String execute(String... args) throws Exception {
        if (args.length != 2) {
            throw new Exception("Número inválido de argumentos. Esperado: materia, pessoas");
        }
        String materia = args[0];
        String[] pessoaCpfs = args[1].split(",");

        Repository<Turma> repository = ServiceLocator.getRepository(Turma.class);
        Turma turma = repository.read(materia);
        if (turma == null) {
            throw new Exception("Turma com a matéria " + materia + " não encontrada.");
        }

        turma.clearPessoas();
        for (String cpf : pessoaCpfs) {
            Pessoa pessoa = ServiceLocator.getRepository(Pessoa.class).read(cpf);
            if (pessoa == null) {
                throw new Exception("Pessoa com CPF " + cpf + " não encontrada.");
            }
            turma.addPessoa(pessoa);
        }

        repository.update(turma);
        return "Turma atualizada com sucesso.";
    }
}
