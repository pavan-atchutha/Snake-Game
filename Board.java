import java.util.*;
public class Board {
    Dice t=new Dice();
    public void board(List<Player>players){
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
        int n=players.size();
        int c=0;
        for(int i=0;i<10;i++){
            for(int j=1;j<11;j++){ 
                System.out.print("______"+t.us(n)+"");
            }
            System.out.println();
            for(int j=1;j<11;j++){
                c=10*i+j;
                if(Snakes.containsKey(c)){
                    System.out.print("|go->"+Snakes.get(c)+t.sp(n-(Snakes.get(c)/10+1))+"|");
                }
                else if(Ladders.containsKey(c)){
                    System.out.print("|go->"+Ladders.get(c)+t.sp(n-(Ladders.get(c)/10+1))+"|");
                }
                else{
                    System.out.print("|    "+t.sp(n)+"|");
                }
            }
            System.out.println();
            c=0;
            /*for(int j=1;j<11;j++){
                System.out.print("|    "+t.sp(n)+"|");
            }
            System.out.println();*/
            for(int j=1;j<11;j++){
                int u=0;
                c=10*i+j;
                String h="";
                for(Player player: players){
                    if(player.getloc()==c){
                        h+=player.getrpe();
                        u=1;
                    }
                }
                if(c/10==0){
                if(u==0){
                    System.out.print("|    "+t.sp(n-1)+c+"|");
                }
                else{
                    System.out.print("| "+h+t.sp(n-h.length())+"  "+c+"|");
                }}
                else{
                    if(u==0){
                        System.out.print("|    "+t.sp(n-2)+c+"|");
                    }
                    else{
                        System.out.print("|"+h+t.sp(n-h.length())+" "+c+" |");
                    }
                }
            }
            System.out.println();
            for(int j=1;j<11;j++){
                System.out.print("|___"+t.us(n)+"_|");
            }
            System.out.println();
        }
    }
}
