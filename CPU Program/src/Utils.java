/*
 * Ishaan Sayal
 * Period 1
 * 4/18/2024
 */
public class Utils 
{
    public static void loadingAnimation(String during, String end, double duration) 
    {
        //get our duration for the animations loop
        int amount = (int) (duration / 0.5);
        for (int i = 0; i < amount; i++) 
        {
            StringBuilder text = new StringBuilder(during);
            //Add a "." depending on the state
            for (int j = 0; j < i % 4; j++) 
            {
                text.append(".");
            }
            //Input whitespace to be able to override previous
            text.append("   ");
            //try/catch sleep
            try 
            {
                Thread.sleep(500);
            } catch (InterruptedException e) 
            {
                System.out.println("Error: Sleeping thread has been interupted. Canceling animation.\n");
                return;
            }
            System.out.print(text + "\r");
        }
        StringBuilder text = new StringBuilder(end);
        //Whitespace based on the during string
        for (int i = 0; i < during.length() + 4; i++) 
        {
            text.append(" ");
        }
        System.out.println("\r" + text);
    }
}
