package trabalho.server.strategies;

import trabalho.server.repositories.Repository;

import java.util.List;

public interface CrudStrategy<T> {
    public String execute(List<T> objects, String... args);
}