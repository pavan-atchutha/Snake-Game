import java.util.*;
//import Play.Player;
class Player implements Comparable<Player>{
    private int loc=0;
    private String nam;
    private String rpe;
    public void setnam(String nam){
        this.nam=nam;
    }
    public void setrpe(String rpe){
        this.rpe=rpe;
    }
    public String getnam(){
        return nam;
    }
    public String getrpe(){
        return rpe;
    }
    Player(String nam,String rpe){
        setnam(nam);
        setrpe(rpe);
    }
    public int getloc(){
        return loc;
    }
    
    public void rollDice(){
        Dice e=new Dice();
        int d=e.chance();
       
       System.out.println("dice value :"+d);
        if((loc+d)<=100){
            loc=loc+d;
        }
        else{
            System.out.println("limt is exceed.");
         }

        HashMap<Integer,Integer>Snakes=new HashMap<>();
        Snakes.put(17,7);
        Snakes.put(54,34);
        Snakes.put(62,19);
        Snakes.put(64,60);
        Snakes.put(87,24);
        Snakes.put(92,73);
        Snakes.put(95,75);
        Snakes.put(99,78);
        HashMap<Integer,Integer>Ladders=new HashMap<>();
        Ladders.put(4,14);
        Ladders.put(9,31);
        Ladders.put(20,38);
        Ladders.put(28,84);
        Ladders.put(40,59);
        Ladders.put(51,67);
        Ladders.put(63,81);
        Ladders.put(71,91);
        if(Snakes.containsKey(loc)){
            System.out.println("At position "+loc+" you affected by snake");
            loc=Snakes.get(loc);
        }
        else if(Ladders.containsKey(loc)){
            System.out.println("At position "+loc+" you get ladder");
            loc=Ladders.get(loc);
        }
        
    }
    public int compareTo(Player st){    
        if(loc==st.loc)    
        return 0;    
        else if(loc<st.loc)    
        return 1;    
        else    
        return -1;    
        }    
}