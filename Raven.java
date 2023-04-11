
/*
 * Raven class with abilities from Contract.java 
 */
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

    /*
     * Constructor for Raven object 
     * @param: String name
     * @returns: Raven object 
     */
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

    /*
     * Can grab and thus hold object 
     * @param: String item 
     */
    public void grab(String item){
        if (this.holdingWithMyClaws){
            throw new RuntimeException("You are already holding something in your claws. Drop it and then try again.");
        }
        this.holdingWithMyClaws=true;
        this.itemThatIsMINE=item;
        System.out.println("You just picked up "+item+ " in your powerful claws.");
        this.deservedlyResting=false;
    }

    /*
     * Can drop item 
     * @param: String item 
     */
    public String drop(String item){
        if (!this.holdingWithMyClaws){
            throw new RuntimeException("You are not holding anything in your claws. Grab something in order to drop it.");
        }
        if (!this.itemThatIsMINE.equals(item)){
            throw new RuntimeException("You are not holding a "+item+" so you cannot drop it.");
        }
        this.holdingWithMyClaws=false;
        this.busyUsingMyItem=false;
        this.itemThatIsMINE="";
        this.deservedlyResting=false;
        System.out.println("You just dropped "+ item+ " from your powerful claws.");
        return item;
    }

    /*
     * Can examine (look at) item 
     * @param: String item 
     */
    public void examine(String item){
        this.lookingAtWithBeadyEyes=item; 
        this.deservedlyResting=false;
        System.out.println("You are examining "+item);
    }

    /*
     * Can use item if not already using an item, if you're not holding something, and if you're holding the item you're using
     * @param: String item 
     */
    public void use(String item){
        if(this.busyUsingMyItem){
            throw new RuntimeException("You are already using an item. Drop it in order to use a new item.");
        }
        if (!this.holdingWithMyClaws){
            throw new RuntimeException("You are not holding anything in your claws. Grab something in order to use it.");
        }
        if(!item.equals(this.itemThatIsMINE)){
            throw new RuntimeException("You are not holding a "+item+" in your claws, so you cannot use it. Grab it first in order to use it.");
        }
        this.busyUsingMyItem=true;
        this.deservedlyResting=false;
        System.out.println("You are currently using "+item+", as you should.");
        
    }

    /*
     * Can walk 5 miles in four set directions 
     * @param: String direction
     * @returns: boolean
     */
    public boolean walk(String direction){
        if (direction!= "LEFT" &&direction!="RIGHT"&&direction!="FORWARD"&&direction!="BACKWARD"){
            throw new RuntimeException("The only valid directions a raven can walk are 'LEFT','RIGHT','FORWARD', or 'BACKWARD'.");
        }
        this.previousXPosition=this.xPosition;
        this.previousYPosition=this.yPosition;
        if (direction=="LEFT"){
            if (this.xPosition<5){
                throw new RuntimeException("You cannot walk left as you are near the border of your area. Try walking right.");
            }
            this.xPosition -=5;
            this.deservedlyResting=false;
            System.out.println("You are strutting proudly to your new destination: ("+this.xPosition+" miles, "+this.yPosition+" miles).");
            return true; 
        }
        if (direction=="RIGHT"){
            if (this.xPosition>95){
                throw new RuntimeException("You cannot walk right as you are near the border of your area. Try walking left.");
            }
            this.xPosition +=5;
            this.deservedlyResting=false;
            System.out.println("You are strutting proudly to your new destination: ("+this.xPosition+" miles, "+this.yPosition+" miles).");
            return true;
        }
        if (direction=="FORWARD"){
            if (this.yPosition>95){
                throw new RuntimeException("You cannot walk forward as you are near the border of your area. Try walking backward.");
            }
            this.yPosition+=5;
            this.deservedlyResting=false;
            System.out.println("You are strutting proudly to your new destination: ("+this.xPosition+" miles, "+this.yPosition+" miles).");
            return true;
        }
        if (direction=="BACKWARD"){
            if (this.yPosition<5){
                throw new RuntimeException("You cannot walk backward as you are near the border of your area. Try walking forward.");
            }
            this.yPosition-=5;
            this.deservedlyResting=false;
            System.out.println("You are strutting proudly to your new destination: ("+this.xPosition+" miles, "+this.yPosition+" miles).");
            return true; 
        }
        return false;
    }

    /*
     * 
     */
    public boolean fly(int x, int y){
        if(this.wingsIn){
            throw new RuntimeException("Your wings are in, so you cannot fly. Grow, and then try again.");
        }
        if(x>100||y>100){
            throw new RuntimeException("This location is out of bounds. Choose a new location.");
        }
        this.previousXPosition=this.xPosition;
        this.previousYPosition=this.yPosition;
        this.xPosition=x;
        this.yPosition=y;
        this.deservedlyResting=false;
        System.out.println("You have flown majestically to a new destination: ("+this.xPosition+" miles, "+this.yPosition+" miles).");
        return true;
    }

    /*
     * shrink method so raven folds in its wings
     * @return: integer (just for Contract.java)
     */
    public Number shrink(){
        if(this.wingsIn){
            throw new RuntimeException("Your wings are already folded in.");
        }
        this.wingsIn=true;
        System.out.println("Your beautiful wings are folded in and you're ready to rest.");
        int number = 0;
        return number; 

    }

    /*
     * grow method to unfurl wings 
     * @return: integer(just for Contract.java)
     */
    public Number grow(){
        if(!this.wingsIn){
            throw new RuntimeException("Your wings are already splayed.");
        }
        this.wingsIn=false;
        this.deservedlyResting=false;
        System.out.println("You wings are splayed and you're ready to fly.");
        int number = 0;
        return number; 
    }

    /*
     * rest method (if wings are in)
     */
    public void rest(){
        if (!this.wingsIn){
            throw new RuntimeException("Your wings are splayed. Shrink in order to tuck in your wings in order to rest.");
        }
        this.deservedlyResting=true;
        System.out.println("You are taking a deserved rest.");
    }

    /*
     * undo method to bring raven back to coordinates before walking or flying 
     */
    public void undo(){
        System.out.println("The undo funtion brings you back to where you were before you last walked or flew.");
        this.xPosition=this.previousXPosition;
        this.yPosition=this.previousYPosition;
        this.deservedlyResting=false;
        System.out.println("You are now back at ("+this.xPosition+", "+this.yPosition+").");
    }

    public String getCoordinates(){
        System.out.println("You were most recently at ("+this.previousXPosition+", "+this.previousYPosition+").");
        System.out.println("You are currently at ("+this.xPosition+", "+this.yPosition+").");
        return("You were most recently at ("+this.previousXPosition+", "+this.previousXPosition+"). You are currently at ("+this.xPosition+", "+this.yPosition+").");
    }

    /*
     * toString method that combines all the information 
     */
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

    /*
     * Main method for testing 
     */
    public static void main(String args[]){
        Raven Harold=new Raven("Harold");
        System.out.println(Harold);
        System.out.println("\n");
        //testing grabbing an item 
        Harold.grab("twine");
        System.out.println(Harold);
        System.out.println("\n");
        //testing grabing another item 
        try{
            Harold.grab("nickel");
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println("\n");
        //testing dropping an item 
        Harold.drop("twine");
        System.out.println("\n");
        //testing dropping an item while I am not holding anything 
        try{
            Harold.drop("twine");
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println("\n");
        //testing dropping an item I am not holding 
        Harold.grab("feather");
        try{
            Harold.drop("pencil");
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println("\n");
        //testing examining an item 
        Harold.examine("human");
        System.out.println("\n");
        System.out.println(Harold);
        System.out.println("\n");
        //testing using an item 
        Harold.use("feather");
        System.out.println("\n");
        //testing using an item while I'm already using an item 
        try{
            Harold.use("penny");
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println("\n");
        //testing using an item while I'm not holding anything in my claws 
        Harold.drop("feather");
        System.out.println("\n");
        try{
            Harold.use("penny");
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println("\n");
        //testing using an item I'm not holding that item in my claws
        Harold.grab("feather");
        System.out.println("\n");
        try{
            Harold.use("penny");
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println("\n");
        //testing walking 
        Harold.walk("LEFT");
        Harold.getCoordinates();
        System.out.println("\n");
        Harold.walk("RIGHT");
        Harold.getCoordinates();
        System.out.println("\n");
        Harold.walk("FORWARD");
        Harold.getCoordinates();
        System.out.println("\n");
        Harold.walk("BACKWARD");
        Harold.getCoordinates();
        System.out.println("\n");
        //test undo 
        Harold.undo();
        System.out.println("\n");
        //testing flying 
        Harold.fly(98,98);
        System.out.println("\n");
        //testing flying out of bounds 
        try{
            Harold.fly(150,90);
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println("\n");
        //testing walking out of bounds 
        try{
            Harold.walk("FORWARD");
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println("\n");
        try{
            Harold.walk("RIGHT");
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println("\n");
        Harold.fly(2,2);
        try{
            Harold.walk("BACKWARD");
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println("\n");
        try{
            Harold.walk("LEFT");
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println("\n");
        //testing shrinking 
        Harold.shrink();
        System.out.println("\n");
        //testing shrinking when already shrunk 
        try{
            Harold.shrink();
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println("\n");
        //testing resting 
        Harold.rest();
        System.out.println("\n");
        //testing resting when wings are splayed 
        Harold.grow();
        try{
            Harold.rest();
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println("\n");
        //testing growing when wings are splayed 
        try{
            Harold.grow();
        } catch (Exception e){
            System.out.println(e);
        }


    }
}