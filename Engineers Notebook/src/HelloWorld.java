public class HelloWorld {
    public static void main(String[] args) throws Exception {
        CommandListener[] commands = new CommandListener[3];
        commands[0] = new PingCommand();
        commands[1] = new ShutdownCommand();
        commands[2] = new FireCommand();
        for (CommandListener command : commands) {
            System.out.println("Command Name: " + command.getCommandName());
            command.onCommand("Ishaan");
            System.out.println();
        }

    }
}
