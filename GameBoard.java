import java.util.*;
class GameBoard { 
 public static void main(String[] args) {
        Board b=new Board();
        List<Player>players=new ArrayList<>();
        System.out.println("Alert!!if no.of players less than 7 then GameBoard will be print.");
        System.out.println("Enter the count of players :");
        Scanner iny =new Scanner(System.in);
        int n=iny.nextInt();
        iny.nextLine();
        List<String> pr = new ArrayList<>();//its help for unique player representaions 
        System.out.println("Enter the name  of player line by line :");
        for(int i=0;i<n;i++){
            System.out.println("Enter the name  of player "+(i+1)+" :");
            String Playernames=iny.nextLine();
            while(true){
            System.out.println("Enter the represent_sign(must be 'length one' eg: @ or #) of player "+(i+1)+" :");
            String Playerrpe=iny.nextLine();
            if(!pr.contains(Playerrpe)&&Playerrpe.length()>0){
                pr.add(Playerrpe);
                players.add(new Player(Playernames,(Playerrpe.charAt(0)+"")));
                break;
            }
            else{
                System.out.println("this represent_sign already exist,Try again!");
            }
            }
        }
        List<String>winners=new ArrayList<>();
        List<String>lossers=new ArrayList<>();
        if(n==1){
            System.out.println("if you wants to play,must have 2 members.");
        }
        List<Player> p=new ArrayList<>();
        System.out.println();
        System.out.println("'Game Starts Now'");
        while(n!=1){
            for(Player player:players){
                if(!p.contains(player)){
                if((players.size())<7) b.board(players);
                System.out.println();
                System.out.println("Now "+player.getnam()+"("+player.getrpe()+")"+" player turn:");
                System.out.println("if roll dice press enter key else you left from game:");
                String f=iny.nextLine();
                if(f.equals("")){
                    player.rollDice();
                    System.out.println("Now "+player.getnam()+" loction on board "+player.getloc());
                }
                else{
                    lossers.add(player.getrpe()+" "+player.getnam());
                    System.out.println("you are left from game.");
                    p.add((player));
                   // System.out.println(players.size());
                    n-=1;
                }
                if(player.getloc()==100){
                    System.out.println("yours is game_over and weight for result.");
                    winners.add(player.getrpe()+" "+player.getnam());
                    System.out.println("ranks is "+winners.size());
                    p.add((player));
                    n-=1;
                }
                if(players.size()-1==p.size()){
                    break;
                }
            }}
        }
        for(Player player:players){
            if(!lossers.contains(player.getrpe()+" "+player.getnam()) && !winners.contains(player.getrpe()+" "+player.getnam())) 
             winners.add(player.getrpe()+" "+player.getnam());
        }
        System.out.println("learder_board for player:");
       // Collections.sort(players);
       System.out.println("R : Rank of that player");
       System.out.println("r : Player represents_sign");
        System.out.println("R"+" "+"r"+" "+"Player_Name");
        for(int i=0;i<winners.size();i++){
            System.out.println((i+1)+" "+winners.get(i));
        }
        System.out.println("Players who are left from game :");
        System.out.println("r : Player represents_sign");
        System.out.println("r"+" "+"Player_Name");
        for(int i=0;i<lossers.size();i++){
            System.out.println(lossers.get(i));
        }
        System.out.println("Game Over......");



        iny.close ();   
    }
        
    
}