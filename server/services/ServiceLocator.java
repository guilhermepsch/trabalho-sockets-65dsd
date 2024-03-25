package trabalho.server.services;

import trabalho.server.models.Medico;
import trabalho.server.models.Paciente;
import trabalho.server.models.Pessoa;
import trabalho.server.models.Hospital;
import trabalho.server.repositories.*;

import java.util.HashMap;
import java.util.Map;

public class ServiceLocator {
    private static final Map<Class<?>, Repository<?>> repositories = new HashMap<>();

    private ServiceLocator(){}

    static {
        repositories.put(Pessoa.class, new PessoaRepository());
        repositories.put(Hospital.class, new HospitalRepository());
        repositories.put(Medico.class, new MedicoRepository());
        repositories.put(Paciente.class, new PacienteRepository());
    }

    public static <T> Repository<T> getRepository(Class<T> clazz) {
        @SuppressWarnings("unchecked")
        Repository<T> repository = (Repository<T>) repositories.get(clazz);
        if (repository == null) {
            throw new IllegalArgumentException("Repository not found for class: " + clazz.getSimpleName());
        }
        return repository;
    }
}