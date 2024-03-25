package trabalho.client.cli;

public class MainMenu extends Menu {

    public MainMenu() {
        this.addOption("1", "Pessoa", new PessoaMenu());
        this.addOption("2", "Hospital", new HospitalMenu());

    }

    @Override
    protected String getTitle() {
        return "Main Menu";
    }
}
