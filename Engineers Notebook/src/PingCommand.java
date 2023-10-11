public class PingCommand implements CommandListener {

    @Override
    public void onCommand(String arg) {
        System.out.println("Sending a ping command to " + arg + "'s system!");
        System.out.println("Ping Command complete");
    }
    @Override
    public String getCommandName() {
        return "Ping Command";
    }


}
