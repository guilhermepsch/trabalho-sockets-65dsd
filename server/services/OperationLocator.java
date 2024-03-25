package trabalho.server.services;

import trabalho.server.commands.*;
import trabalho.server.commands.pessoa.*;
import trabalho.server.commands.hospital.*;

import java.util.HashMap;
import java.util.Map;

public class OperationLocator {
    private static final Map<String, CrudCommand<?>> routes = new HashMap<>();

    static {
        routes.put("CREATE_PESSOA", new PessoaCreateCommand());
        routes.put("GET_PESSOA", new PessoaGetCommand());
        routes.put("UPDATE_PESSOA", new PessoaUpdateCommand());
        routes.put("UPDATE_PESSOA_NOME", new PessoaUpdateCommand());
        routes.put("DELETE_PESSOA", new PessoaDeleteCommand());
        routes.put("LIST_PESSOA", new PessoaListCommand());

        routes.put("CREATE_HOSPITAL", new HospitalCreateCommand());
        routes.put("GET_HOSPITAL", new HospitalGetCommand());
        routes.put("UPDATE_HOSPITAL", new HospitalUpdateCommand());
        routes.put("DELETE_HOSPITAL", new HospitalDeleteCommand());
        routes.put("LIST_HOSPITAL", new HospitalListCommand());

    }

    private OperationLocator() {
    }

    public static String handleOperation(String operationId, String... args) throws Exception {
        CrudCommand<?> command = routes.get(operationId);
        if (command == null) {
            return "Operation ID not found: " + operationId;
        }
        @SuppressWarnings("unchecked")
        CrudCommand<Object> typedStrategy = (CrudCommand<Object>) command;
        return typedStrategy.execute(args);
    }

}
