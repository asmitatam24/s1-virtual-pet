import javax.swing.*;

public class Runner{
    public Runner(){
        VirtualPet p = new VirtualPet();
        p.wakeUp();
        p.stop(3000);
        p.breakFast();
        p.stop(5000);
        p.toSchool();
    }
    public static void main(String[] args){
        new Runner();
    }
}