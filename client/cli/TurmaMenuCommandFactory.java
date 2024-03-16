package trabalho.client.cli;

import trabalho.client.commands.Command;
import trabalho.client.commands.turma.*;

public class TurmaMenuCommandFactory extends MenuCommand implements Command {
    public TurmaMenuCommandFactory() {
        this.addMenuItem("1", "Criar Turma", new TurmaCreateCommand());
        this.addMenuItem("2", "Alterar Turma", new TurmaUpdateCommand());
        this.addMenuItem("3", "Ler Turma", new TurmaGetCommand());
        this.addMenuItem("4", "Deletar Turma", new TurmaDeleteCommand());
        this.addMenuItem("5", "Listar Turma", new TurmaListCommand());
    }

    @Override
    protected String getMenuTitle() {
        return "Menu de Turmas";
    }
}