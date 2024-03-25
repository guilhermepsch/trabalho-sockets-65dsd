package trabalho.server.commands.medico;

import trabalho.server.commands.CrudCommand;
import trabalho.server.models.Medico;
import trabalho.server.repositories.Repository;
import trabalho.server.services.ServiceLocator;

public class MedicoUpdateCommand implements CrudCommand<Medico> {
    @Override
    public String execute(String... args) throws Exception {
        if (args.length != 4) {
            throw new Exception("Número inválido de argumentos. Esperado: cpf, nome, endereco, especialização");
        }
        String cpf = args[0];
        String newNome = args[1];
        String newEndereco = args[2];
        String newEspecializacao = args[3];
        if (cpf.isEmpty() || newNome.isEmpty() || newEndereco.isEmpty() || newEspecializacao.isEmpty()) {
            throw new Exception("Argumentos inválidos. Todos os campos não podem ser vazios.");
        }
        Repository<Medico> repository = ServiceLocator.getRepository(Medico.class);
        Medico medico = repository.read(cpf);
        if (medico == null) {
            throw new Exception("Uma pessoa com o mesmo cpf já existe.");
        }
        medico.setNome(newNome);
        medico.setEndereco(newEndereco);
        medico.setEspecializacao(newEspecializacao);
        repository.update(medico);
        return "Médico alterado com sucesso.";
    }
}
