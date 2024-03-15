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

    public static void handleOperation(String operationId, String... args) {
        CrudStrategy<?> strategy = routes.get(operationId);
        if (strategy != null) {
            @SuppressWarnings("unchecked")
            CrudStrategy<Object> typedStrategy = (CrudStrategy<Object>) strategy;
            typedStrategy.execute(null, args);
        } else {
            System.err.println("Operation ID not found: " + operationId);
        }
    }

}
