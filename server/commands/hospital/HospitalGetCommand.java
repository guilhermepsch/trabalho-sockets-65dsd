package trabalho.server.commands.hospital;

import trabalho.server.commands.CrudCommand;
import trabalho.server.models.Hospital;
import trabalho.server.repositories.Repository;
import trabalho.server.services.ServiceLocator;

public class HospitalGetCommand implements CrudCommand<Hospital> {
    @Override
    public String execute(String... args) throws Exception {
        if (args.length != 1) {
            throw new IllegalArgumentException("Número inválido de argumentos. Esperado: nome");
        }
        String nome = args[0];
        Repository<Hospital> repository = ServiceLocator.getRepository(Hospital.class);
        Hospital hospital = repository.read(nome);
        if (hospital == null) {
            throw new Exception("Hospital não encontrado.");
        }
        return hospital.toString();
    }
}
