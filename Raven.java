

public class Raven implements Contract.java
{

    String name;
    String lookingAtWithBeadyEyes;
    boolean holdingWithMyClaws;
    String itemThatIsMINE="";
    boolean busyUsingMyItem;
    boolean deservedlyResting;
    boolean wingsIn;
    int previousXPosition;
    int previousYPosition;
    int xPosition; 
    int yPosition;

    public Raven(String name){
        this.name=name;
        this.lookingAtWithBeadyEyes="Sky";
        this.holdingWithMyClaws=false;
        this.busyUsingMyItem=false;
        this.deservedlyResting=false; 
        this.previousXPosition=50;
        this.previousYPosition=50;
        this.xPosition=50;
        this.yPosition=50;
        this.wingsIn=false;

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
        this.busyUsingMyItem=false;
        this.itemThatIsMINE="";
        System.out.println("You just dropped "+ item+ " from your powerful claws.");
        return item;
    }

    public void examine(String item){
        this.lookingAtWithBeadyEyes=item; 
        System.out.println("You are examining "+item);
    }

    public void use(String item){
        if(this.busyUsingMyItem){
            throw new RuntimeException("You are already using an item. Drop it in order to use a new item.");
        }
        if (!this.holdingWithMyClaws){
            throw new RuntimeException("You are not holding anything in your claws. Grab something in order to use it.");
        }
        if(!item.equals(this.itemThatIsMINE)){
            throw new RuntimeException("You are not holding "+item+" in your claws, so you cannot use it. Grab it first in order to use it.");
        }
        this.busyUsingMyItem=true;
        System.out.println("You are currently using "+item+", as you should. Undo in order to stop using it.");
        
    }

    public boolean walk(String direction){
        if (direction!= "LEFT" ||direction!="RIGHT"||direction!="FORWARD"||direction!="BACKWARD"){
            throw new RuntimeException("The only valid directions a raven can walk are 'LEFT','RIGHT','FORWARD', or 'BACKWARD'.");
        }
        if (direction=="LEFT"){
            this.previousXPosition=this.xPosition;
            this.xPosition -=5;
            System.out.println("You are strutting proudly to your new destination: ("+this.xPosition+" miles, "+this.yPosition+" miles).");
            return true; 
        }
        if (direction=="RIGHT"){
            this.previousXPosition=this.xPosition;
            this.xPosition +=5;
            System.out.println("You are strutting proudly to your new destination: "+this.xPosition+" miles, "+this.yPosition+" miles).");
            return true;
        }
        if (direction=="FORWARD"){
            this.previousYPosition=this.yPosition;
            this.yPosition+=5;
            System.out.println("You are strutting proudly to your new destination: ("+this.xPosition+" miles, "+this.yPosition+" miles).");
            return true;
        }
        if (direction=="BACKWARD"){
            this.previousYPosition=this.yPosition;
            this.yPosition-=5;
            System.out.println("You are strutting proudly to your new destination: ("+this.xPosition+" miles, "+this.yPosition+" miles).");
            return true; 
        }
        return false;
    }

    public boolean fly(int x, int y){
        if(this.wingsIn){
            throw new RuntimeException("Your wings are in, so you cannot fly. Grow, and then try again.");
        }
        this.previousXPosition=this.xPosition;
        this.previousYPosition=this.yPosition;
        this.xPosition=x;
        this.yPosition=y;
        System.out.println("You have flown majestically to a new destination: ("+this.xPosition+", "+this.yPosition+").");
        return true;
    }

    public Number shrink(){
        this.wingsIn=true;
        System.out.println("Your beautiful wings are folded in and you're ready to rest.");
        int number = 4;
        return number; 

    }

    public void grow(){
        this.wingsIn=false;
        System.out.println("You wings are splayed and you're ready to fly.");
    }

    public void rest(){
        if (!this.wingsIn){
            throw new RuntimeException("Your wings are splayed. Shrink in order to tuck in your wings in order to rest.");
        }
        this.deservedlyResting=true;
    }

    public void undo(){
        System.out.println("The undo funtion brings you back to where you were before you last walked or flew.");
        this.xPosition=this.previousXPosition;
        this.yPosition=this.previousYPosition;
        System.out.println("You are now back at ("+this.xPosition+", "+this.yPosition+").");
    }

    public String toString(){
        String toReturn="You are a raven. Your name is "+this.name;
        toReturn+=". You are looking at the "+this.lookingAtWithBeadyEyes+" with beady eyes.";
        if (holdingWithMyClaws){
            toReturn+=" You are holding "+itemThatIsMINE+" in your claws.";
        }
        if (!holdingWithMyClaws){
            toReturn+=" You are not holding anything in your claws.";
        }
        if(busyUsingMyItem){
            toReturn+=" You are using a "+itemThatIsMINE+".";
        }
        if(!busyUsingMyItem){
            toReturn+=" You are not using any items right now.";
        }
        if (wingsIn){
            toReturn+=" Your wings are in.";
        }
        if(!wingsIn){
            toReturn+=" Your wings are out and you are ready to fly.";
        }
        if(deservedlyResting){
            toReturn+=" You are deservedly resting.";
        }
        if(!deservedlyResting){
            toReturn+= " You are not resting. You are up and about!";
        }
        toReturn+=" You are living in a beautiful area of temperate rainforest near Sitka, Alaska that's 100 miles by 100 miles. You are currently at ("+this.xPosition+" miles, "+this.yPosition+" miles).";
        return toReturn;
    }

    public static void main(String args[]){
        Raven Harold=new Raven("Harold");
        System.out.println(Harold);

    }
}