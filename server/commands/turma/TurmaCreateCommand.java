package trabalho.server.commands.turma;

import trabalho.server.commands.CrudCommand;
import trabalho.server.models.Pessoa;
import trabalho.server.models.Turma;
import trabalho.server.repositories.Repository;
import trabalho.server.services.ServiceLocator;

public class TurmaCreateCommand implements CrudCommand<Turma> {
    @Override
    public String execute(String... args) throws Exception {
        if (args.length != 2) {
            throw new Exception("Número inválido de argumentos. Esperado: materia, pessoa1,pessoa2...");
        }
        String materia = args[0];
        String[] pessoaCpfs = args[1].split(",");

        Repository<Turma> repository = ServiceLocator.getRepository(Turma.class);
        if (repository.read(materia) != null) {
            throw new Exception("Uma turma com a mesma matéria já existe.");
        }

        Turma turma = new Turma(materia);
        for (String cpf : pessoaCpfs) {
            Pessoa pessoa = ServiceLocator.getRepository(Pessoa.class).read(cpf);
            if (pessoa == null) {
                throw new Exception("Pessoa com CPF " + cpf + " não encontrada.");
            }
            turma.addPessoa(pessoa);
        }

        repository.create(turma);
        return "Turma criada com sucesso.";
    }
}
