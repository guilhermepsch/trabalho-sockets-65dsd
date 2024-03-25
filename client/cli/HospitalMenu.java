package trabalho.client.cli;

import trabalho.client.commands.hospital.*;

public class HospitalMenu extends Menu {
    
    public HospitalMenu () {
        this.addOption("1", "Criar Hospital", new HospitalCreateCommand());
        this.addOption("2", "Atualizar Hospital", new HospitalUpdateCommand());
        this.addOption("3", "Obter Hospital", new HospitalGetCommand());
        this.addOption("4", "Listar Hospitais", new HospitalListCommand());
        this.addOption("5", "Deletar Hospital", new HospitalDeleteCommand());
    }
    @Override
    protected String getTitle() {
        return "Menu de Hospitais";
    }
}
