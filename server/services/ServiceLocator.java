package trabalho.server.services;

import trabalho.server.models.Person;
import trabalho.server.repositories.PersonRepository;
import trabalho.server.repositories.Repository;

import java.util.HashMap;
import java.util.Map;

public class ServiceLocator {
    private static final Map<Class<?>, Repository<?>> repositories = new HashMap<>();

    private ServiceLocator(){}

    static {
        repositories.put(Person.class, new PersonRepository());
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