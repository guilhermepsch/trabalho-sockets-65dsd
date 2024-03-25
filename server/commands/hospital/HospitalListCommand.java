package trabalho.server.commands.hospital;

import trabalho.server.commands.CrudCommand;
import trabalho.server.models.Hospital;
import trabalho.server.repositories.Repository;
import trabalho.server.services.ServiceLocator;

import java.util.List;

public class HospitalListCommand implements CrudCommand<Hospital> {
    @Override
    public String execute(String... args) throws Exception {
        Repository<Hospital> repository = ServiceLocator.getRepository(Hospital.class);
        List<Hospital> hospitais = repository.listAll();
        if (hospitais.isEmpty()) {
            return "Nenhum hospital encontrado.";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Hospital hospital : hospitais) {
            stringBuilder.append(hospital.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
