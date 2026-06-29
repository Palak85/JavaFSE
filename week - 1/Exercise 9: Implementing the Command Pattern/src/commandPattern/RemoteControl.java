package commandPattern;

public class RemoteControl {
    private Command command;

    // Set or dynamically swap command
    public void setCommand(Command command) {
        this.command = command;
    }

    // Invoke the execute method of the set command
    public void pressButton() {
        if (command == null) {
            System.out.println("Remote Control: No command is assigned to this slot.");
            return;
        }
        command.execute();
    }
}
