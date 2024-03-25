package trabalho.client.cli;

public class MainMenu extends Menu {

    public MainMenu() {
        this.addOption("1", "Pessoa", new PessoaMenu());
        this.addOption("2", "Hospital", new HospitalMenu());
        this.addOption("3", "Paciente", new PacienteMenu());
        this.addOption("4", "Médico", new MedicoMenu());

    }

    @Override
    protected String getTitle() {
        return "Main Menu";
    }
}
