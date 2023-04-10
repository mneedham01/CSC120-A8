

public class Raven //implements Contract.java{
{

    String lookingAtWithBeadyEyes;
    boolean holdingWithMyClaws;
    String itemThatIsMINE="";
    boolean deservedlyResting;
    int xPosition; 
    int yPosition;

    public Raven(String name){
        this.lookingAtWithBeadyEyes="Sky";
        this.holdingWithMyClaws=false;
        this.deservedlyResting=false; 
        this.xPosition=50;
        this.yPosition=50;

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
        if (direction!= "LEFT" ||direction!="RIGHT"||direction!="FORWARD"||direction!="BACKWARD"){
            throw new RuntimeException("The only valid directions a raven can walk are 'LEFT','RIGHT','FORWARD', or 'BACKWARD'.");
        }
        if (direction=="LEFT"){
            this.xPosition -=5;
            System.out.println("You are strutting proudly to your new destination: ("+this.xPosition+", "+this.yPosition+").");
            return true; 
        }
        if (direction=="RIGHT"){
            this.xPosition +=5;
            System.out.println("You are strutting proudly to your new destination: ("+this.xPosition+", "+this.yPosition+").");
            return true;
        }
        if (direction=="FORWARD"){
            this.yPosition+=5;
            System.out.println("You are strutting proudly to your new destination: ("+this.xPosition+", "+this.yPosition+").");
            return true;
        }
        if (direction=="BACKWARD"){
            this.yPosition-=5;
            System.out.println("You are strutting proudly to your new destination: ("+this.xPosition+", "+this.yPosition+").");
            return true; 
        }
        return false;
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