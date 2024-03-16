package trabalho.server.services;

import trabalho.server.models.Pessoa;
import trabalho.server.models.Turma;
import trabalho.server.repositories.PessoaRepository;
import trabalho.server.repositories.Repository;
import trabalho.server.repositories.TurmaRepository;

import java.util.HashMap;
import java.util.Map;

public class ServiceLocator {
    private static final Map<Class<?>, Repository<?>> repositories = new HashMap<>();

    private ServiceLocator(){}

    static {
        repositories.put(Pessoa.class, new PessoaRepository());
        repositories.put(Turma.class, new TurmaRepository());
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