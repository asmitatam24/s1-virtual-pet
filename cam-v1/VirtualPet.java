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
    private boolean missbus = false;
    
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
        if ((hunger >= 10) || (mood <= 10)){
            face.setImage("skeleton");
        }
    }

    public void wakeUp(){
        mood = 10;
        int value = (int)(Math.random()*5);
        if (value != 0){
            face.setMessage("Good Morning World");
            face.setImage("joyful");
        } else {
            face.setMessage("ahhhhhh shucks");
            face.setImage("surpirsed");
            mood = mood - 1;
        }
        death();
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
        death();
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
                missbus = true;
            }
        }
    }

    public void popquiz(){
        face.setImage("popquiz");
        face.setMessage("another physics pop quiz???");
        stop(3000);
        int quiz = (int)(Math.random()*1);
        if (quiz != 0){
            face.setImage("ecstatic");
            face.setMessage("I passed!");
        }

        else{
            face.setImage("failquiz"); 
            if (missbus = true){
                mood = mood - 1;
            }
          
        }
    }

    public void bully(){
        String ans3 = response("Should I drop off my books in my locker?");
        if (ans3.equals("Yes")){
            face.setImage("joyful");
            face.setMessage("Yay! I dont have to carry heavy books");
            stop(3000);
            face.setImage("locker");
            stop(3000);
            mood = mood +1;
            int trip = (int)(Math.random()*9);
            if (trip != 0){
                face.setImage("trip");
                face.setImage("Ouch");
                stop(3000);
                face.setImage("bully");
                face.setMessage("Oh no....");
                stop(3000);
                mood = mood - 3;
            }
        } else {
            face.setMessage("I want a joice box");
            stop(3000);
            face.setImage("juice");
            mood = mood + 1;
        }
    }
}
 // end Virtual Pet
