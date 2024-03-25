package trabalho.client.cli;

import trabalho.client.commands.medico.*;

public class MedicoMenu extends Menu {

    public MedicoMenu() {
        this.addOption("1", "Criar Medico", new MedicoCreateCommand());
        this.addOption("2", "Atualizar Medico", new MedicoUpdateCommand());
        this.addOption("3", "Obter Medico", new MedicoGetCommand());
        this.addOption("4", "Listar Medicos", new MedicoListCommand());
        this.addOption("5", "Deletar Medico", new MedicoDeleteCommand());
    }

    @Override
    protected String getTitle() {
        return "Menu de Médicos";
    }
}
