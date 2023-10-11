public class FireCommand implements CommandListener {

    @Override
    public void onCommand(String arg) {
        System.out.println(arg + " has been fired.");
    }
    @Override
    public String getCommandName() {
        return "Fire Command";
    }
}
