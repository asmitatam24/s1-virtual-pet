import javax.swing.*;

public class Runner{
    public Runner(){
        VirtualPet p = new VirtualPet();
        p.wakeUp();
        stop(3000);
        p.death();
        stop(2000);
        String ans = response("How was your day");
        System.out.println(ans);
    }

    public String response(String q){
        String s = (String)JOptionPane.showInputDialog(
            new JFrame(),
            q,
            "Get a response",
            JOptionPane.PLAIN_MESSAGE
        );
        return s;
    }

    public void stop(int milliseconds){
        try{
            Thread.sleep(milliseconds);
        } catch(Exception e){

        }
    }
    public static void main(String[] args){
        new Runner();
    }
}