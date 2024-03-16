package trabalho.server.services;

import trabalho.server.commands.*;
import trabalho.server.commands.pessoa.*;
import trabalho.server.commands.turma.*;

import java.util.HashMap;
import java.util.Map;

public class OperationLocator {
    private static final Map<String, CrudCommand<?>> routes = new HashMap<>();

    static {
        routes.put("CREATE_PESSOA", new PessoaCreateCommand());
        routes.put("GET_PESSOA", new PessoaGetCommand());
        routes.put("UPDATE_PESSOA", new PessoaUpdateCommand());
        routes.put("DELETE_PESSOA", new PessoaDeleteCommand());
        routes.put("LIST_PESSOA", new PessoaListCommand());

        routes.put("CREATE_TURMA", new TurmaCreateCommand());
        routes.put("GET_TURMA", new TurmaGetCommand());
        routes.put("UPDATE_TURMA", new TurmaUpdateCommand());
        routes.put("DELETE_TURMA", new TurmaDeleteCommand());
        routes.put("LIST_TURMA", new TurmaListCommand());
    }

    private OperationLocator() {
    }

    public static String handleOperation(String operationId, String... args) throws Exception {
        CrudCommand<?> strategy = routes.get(operationId);
        if (strategy == null) {
            return "Operation ID not found: " + operationId;
        }
        @SuppressWarnings("unchecked")
        CrudCommand<Object> typedStrategy = (CrudCommand<Object>) strategy;
        return typedStrategy.execute(args);
    }

}
