package trabalho.client.cli;

import trabalho.client.commands.pessoa.*;

public class PessoaMenu extends Menu{

    public PessoaMenu (){
        this.addOption("1", "Criar Pessoa", new PessoaCreateCommand());
        this.addOption("2", "Atualizar Pessoa", new PessoaUpdateCommand());
        this.addOption("3", "Obter Pessoa", new PessoaGetCommand());
        this.addOption("4", "Listar Pessoas", new PessoaListCommand());
        this.addOption("5", "Deletar Pessoa", new PessoaDeleteCommand());
    }

    @Override
    protected String getTitle() {
        return "Menu de Pessoas";
    }
}
