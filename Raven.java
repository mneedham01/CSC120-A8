

public class Raven //implements Contract.java{
{

    String lookingAtWithBeadyEyes;
    boolean holdingWithMyClaws;
    String itemThatIsMINE="";
    boolean strutting; 
    boolean soaring;
    boolean supervising;

    public Raven(String name){
        this.lookingAtWithBeadyEyes="Sky";
        this.holdingWithMyClaws=false;
        this.strutting= false;
        this.soaring= false;
        this.supervising=false; 

    }

    public void grab(String item){
        if (this.holdingWithMyClaws){
            throw new RuntimeException("You are already holding something in your claws. Drop it and then try again.");
        }
        this.holdingWithMyClaws=true;
        this.itemThatIsMINE=item;
        System.out.println("You just picked up "+item+ " in your powerful claws.");

    }

    public String drop(String item){
        if (!this.holdingWithMyClaws){
            throw new RuntimeException("You are not holidng anything in your claws. Grab something in order to drop it.");
        }
        this.holdingWithMyClaws=false;
        this.itemThatIsMINE="";
        System.out.println("You just dropped "+ item+ " from your powerful claws.");
        return item;
    }

    public void examine(String item){

    }

    public void use(String item){

    }

    public boolean walk(String direction){

    }

    public boolean fly(int x, int y){

    }

    public Number shrink(){

    }

    public void rest(){

    }

    public void undo(){

    }
}