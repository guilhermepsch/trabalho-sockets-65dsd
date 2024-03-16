package trabalho.server.commands;

public interface CrudCommand<T> {
    public String execute(String... args) throws Exception;
}