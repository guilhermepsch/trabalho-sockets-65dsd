package trabalho.server.services;

import trabalho.server.commands.*;

import java.util.HashMap;
import java.util.Map;

public class OperationLocator {
    private static final Map<String, CrudCommand<?>> routes = new HashMap<>();

    static {
        routes.put("CREATE_PERSON", new CreatePersonCommand());
        routes.put("GET_PERSON", new GetPersonCommand());
        routes.put("UPDATE_PERSON", new UpdatePersonCommand());
        routes.put("DELETE_PERSON", new DeletePersonCommand());
        routes.put("LIST_PERSON", new ListPersonCommand());
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
