package trabalho.server.commands.hospital;

import trabalho.server.commands.CrudCommand;
import trabalho.server.models.Pessoa;
import trabalho.server.models.Hospital;
import trabalho.server.repositories.Repository;
import trabalho.server.services.ServiceLocator;

public class HospitalUpdateCommand implements CrudCommand<Hospital> {
    @Override
    public String execute(String... args) throws Exception {
        if (args.length != 3) {
            throw new Exception("Número inválido de argumentos. Esperado: nome, endereco, pessoa1,pessoa2...");
        }
        String nome = args[0];
        String[] pessoaCpfs = args[2].split(",");

        Repository<Hospital> repository = ServiceLocator.getRepository(Hospital.class);
        Hospital hospital = repository.read(nome);
        if (hospital == null) {
            throw new Exception("Hospital com o nome " + nome + " não encontrado.");
        }

        hospital.clearPessoas();
        for (String cpf : pessoaCpfs) {
            Pessoa pessoa = ServiceLocator.getRepository(Pessoa.class).read(cpf);
            if (pessoa == null) {
                throw new Exception("Pessoa com CPF " + cpf + " não encontrada.");
            }
            hospital.addPessoa(pessoa);
        }

        repository.update(hospital);
        return "Hospital atualizado com sucesso.";
    }
}
