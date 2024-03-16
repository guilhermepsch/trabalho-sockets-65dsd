package trabalho.server.repositories;

import java.util.List;

public interface Repository<T> {
    void create(T obj);
    T read(String id);
    void update(T obj);
    void delete(String id);

    List<T> listAll();
}