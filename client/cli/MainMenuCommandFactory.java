package trabalho.client.cli;

public class MainMenuCommandFactory extends MenuCommand {

    public MainMenuCommandFactory() {
        this.addMenuItem("1", "Pessoa", new PessoaMenuCommandFactory());
        this.addMenuItem("2", "Turma", new TurmaMenuCommandFactory());
    }

    @Override
    protected String getMenuTitle() {
        return "Menu Principal";
    }
}