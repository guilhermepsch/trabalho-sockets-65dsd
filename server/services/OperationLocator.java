package trabalho.server.services;

import trabalho.server.commands.*;
import trabalho.server.commands.pessoa.*;
import trabalho.server.commands.hospital.*;
import trabalho.server.commands.medico.*;
import trabalho.server.commands.paciente.*;

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

        routes.put("CREATE_MEDICO", new MedicoCreateCommand());
        routes.put("GET_MEDICO", new MedicoGetCommand());
        routes.put("UPDATE_MEDICO", new MedicoUpdateCommand());
        routes.put("DELETE_MEDICO", new MedicoDeleteCommand());
        routes.put("LIST_MEDICO", new MedicoListCommand());

        routes.put("CREATE_PACIENTE", new PacienteCreateCommand());
        routes.put("GET_PACIENTE", new PacienteGetCommand());
        routes.put("UPDATE_PACIENTE", new PacienteUpdateCommand());
        routes.put("DELETE_PACIENTE", new PacienteDeleteCommand());
        routes.put("LIST_PACIENTE", new PacienteListCommand());
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
