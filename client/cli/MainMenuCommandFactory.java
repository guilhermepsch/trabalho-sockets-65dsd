package trabalho.client.cli;

public class MainMenuCommandFactory extends MenuCommand {

    public MainMenuCommandFactory() {
        this.addMenuItem("1", "Person", new PersonMenuCommandFactory());
    }

    @Override
    protected String getMenuTitle() {
        return "Main Menu";
    }
}