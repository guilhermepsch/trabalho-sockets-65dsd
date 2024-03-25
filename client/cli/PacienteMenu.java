package trabalho.client.cli;

import trabalho.client.commands.paciente.*;

public class PacienteMenu extends Menu{

    public PacienteMenu (){
        this.addOption("1", "Criar Paciente", new PacienteCreateCommand());
        this.addOption("2", "Atualizar Paciente", new PacienteUpdateCommand());
        this.addOption("3", "Obter Paciente", new PacienteGetCommand());
        this.addOption("4", "Listar Pacientes", new PacienteListCommand());
        this.addOption("5", "Deletar Paciente", new PacienteDeleteCommand());
    }

    @Override
    protected String getTitle() {
        return "Menu de Pacientes";
    }
}
