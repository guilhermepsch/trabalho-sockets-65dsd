package trabalho.server.controllers;

import trabalho.server.strategies.CreatePersonStrategy;
import trabalho.server.strategies.CrudStrategy;

import java.util.HashMap;
import java.util.Map;

public class OperationController {
    private static final Map<String, CrudStrategy<?>> routes = new HashMap<>();
    private static OperationController instance;

    static {
        routes.put("CREATE_PERSON", new CreatePersonStrategy());
    }

    private OperationController() {
    }

    public static String handleOperation(String operationId, String... args) throws Exception {
        CrudStrategy<?> strategy = routes.get(operationId);
        if (strategy == null) {
            return "Operation ID not found: " + operationId;
        }
        @SuppressWarnings("unchecked")
        CrudStrategy<Object> typedStrategy = (CrudStrategy<Object>) strategy;
        return typedStrategy.execute(args);
    }

}
