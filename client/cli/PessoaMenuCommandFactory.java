package trabalho.client.cli;

import trabalho.client.commands.Command;
import trabalho.client.commands.pessoa.*;

public class PessoaMenuCommandFactory extends MenuCommand implements Command {
    public PessoaMenuCommandFactory() {
        this.addMenuItem("1", "Criar Pessoa", new PessoaCreateCommand());
        this.addMenuItem("2", "Alterar Pessoa", new PessoaUpdateCommand());
        this.addMenuItem("3", "Ler Pessoa", new PessoaGetCommand());
        this.addMenuItem("4", "Deletar Pessoa", new PessoaDeleteCommand());
        this.addMenuItem("5", "Listar Pessoa", new PessoaListCommand());
    }

    @Override
    protected String getMenuTitle() {
        return "Menu de Pessoas";
    }
}