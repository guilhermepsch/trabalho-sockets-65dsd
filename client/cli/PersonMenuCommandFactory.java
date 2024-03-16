package trabalho.client.cli;

import trabalho.client.commands.Command;
import trabalho.client.commands.person.*;

public class PersonMenuCommandFactory extends MenuCommand implements Command {
    public PersonMenuCommandFactory() {
        this.addMenuItem("1", "Create Person", new CreatePersonCommand());
        this.addMenuItem("2", "Update Person", new UpdatePersonCommand());
        this.addMenuItem("3", "Get Person", new GetPersonCommand());
        this.addMenuItem("4", "Delete Person", new DeletePersonCommand());
        this.addMenuItem("5", "List Person", new ListPersonCommand());
    }

    @Override
    protected String getMenuTitle() {
        return "Person Menu";
    }
}