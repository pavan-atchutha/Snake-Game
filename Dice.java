import java.util.*;
public class Dice {
    public String us(int f){
        String s="";
        for(int i=0;i<f;i++){
            s+="_";
        }
        return s;
    }
    public String sp(int f){
        String s="";
        for(int i=0;i<f;i++){
            s+=" ";
        }
        return s;
    }
    public int chance(){
        Random r = new Random();
        int t=r.nextInt(6)+1;
        System.out.println("-------");
        for(int x=0;x<3;x++){
            if(x==1){
            System.out.println("|  "+t+"  |");
            
        }
        else System.out.println("|     |");
        
    }
    
    System.out.println("-------");
        return t;
    }
}
