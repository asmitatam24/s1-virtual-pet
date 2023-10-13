/* Virtual Pet, version 1
 * 
 * @author Cam
 * @author ?
 */

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VirtualPet {
    
    VirtualPetFace face;
    private int hunger = 0;   // how hungry the pet is.
    private int tiredness = 0;
    private int mood = 10;
    
    // constructor
    public VirtualPet() {
        face = new VirtualPetFace();
        face.setImage("normal");
        face.setMessage("Hello.");
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
    public void feed() {
        if (hunger > 10) {
            hunger = hunger - 10;
        } else {
            hunger = 0;
        }
        face.setMessage("Yum, thanks");
        face.setImage("normal");
    }
    
    public void exercise() {
        hunger = hunger + 3;
        face.setMessage("1, 2, 3, jump.  Whew.");
        face.setImage("tired");
        if (tiredness < 4){
            face.setMessage("That was great");
            face.setImage("ecstatic");
        }
    }
    
    public void sleep() {
        hunger = hunger + 1;
        face.setImage("asleep");
    }

    public void death(){
        if (hunger >= 10){
            face.setImage("skeleton");
        }
    }

    public void wakeUp(){
        int value = (int)(Math.random()*5);
        if (value != 0){
            face.setMessage("Good Morning World");
            face.setImage("joyful");
        } else {
            face.setMessage("ahhhhhh shucks");
            face.setImage("surpirsed");
            mood = mood - 1;
        }
    }

    public void breakFast(){
        String ans1 = response("What should I eat? Bacon and Eggs? or Bread?");
        if (ans1.equals("Bacon and Eggs")){
            face.setImage("bacon");
            mood = mood + 1;
        } else{
            face.setImage("bread");
            mood = mood - 1;
        }
    }

    public void toSchool(){
        int bus = (int)(Math.random()*3);
        String ans2 = response("Should I walk or take bus");
        if (ans2.equals("walk")){
            face.setImage("normal");
            face.setMessage("I love walking!");
        }
        if (ans2.equals("bus")){
            if (bus != 0){
                face.setImage("bus");;
                face.setMessage("I love taking the bus!");
            }

            else{
                face.setMessage("Noooooo! I missed the bus :(");
                face.setImage("very sad");
                mood = mood - 1;
            }
        }

    public void popquiz(){
        face.setImage("popquiz");
        face.setMessage("another physics pop quiz???");
        int quiz = (int)(Math.random()*1);
        if (quiz != 0){
            face.setImage("ecstatic"); //popquiz pixel art
            face.setMessage("I passed!");
        }

        else{
            face.setImage("fail") //fail pixel art
            // if missed bus, decrease mood
        }
    }

    }
} // end Virtual Pet
