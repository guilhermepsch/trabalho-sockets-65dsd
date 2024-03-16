package trabalho.client.factories;

import trabalho.client.commands.Command;
import trabalho.client.commands.MenuCommand;
import trabalho.client.commands.person.CreatePersonCommand;

public class PersonMenuCommandFactory extends MenuCommand implements Command {
    public PersonMenuCommandFactory() {
        this.menuCommands.put("1", new CreatePersonCommand());
    }

    @Override
    protected void initialMessage() {
        System.out.println("Person Operations - Enter number");
    }

    @Override
    protected void showOperations() {
        System.out.println("1 - Create Person");
        System.out.println("2 - Read Person");
        System.out.println("3 - Update Person");
        System.out.println("4 - Delete Person");
    }
}