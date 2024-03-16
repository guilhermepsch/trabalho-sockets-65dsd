package trabalho.client.factories;

import trabalho.client.commands.MenuCommand;

public class MainMenuCommandFactory extends MenuCommand {

    public MainMenuCommandFactory(){
        this.menuCommands.put("1", new PersonMenuCommandFactory());
    }

    @Override
    protected void initialMessage() {
        System.out.println("Main Menu - Enter number");
    }

    @Override
    protected void showOperations() {
        System.out.println("1 - Person");
        System.out.println("2 - Teacher");
        System.out.println("3 - Student");
        System.out.println("4 - Classroom");
    }
}
