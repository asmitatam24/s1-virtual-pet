/* Virtual Pet, version 1
 * 
 * @author Cam
 * @author ?
 */
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
} // end Virtual Pet
