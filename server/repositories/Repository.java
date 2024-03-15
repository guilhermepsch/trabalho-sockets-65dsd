package trabalho.server.repositories;

public interface Repository<T> {
    void create(T obj);
    T read(String id);
    void update(T obj);
    void delete(String id);
}