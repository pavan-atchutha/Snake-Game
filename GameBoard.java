import java.util.*;
class GameBoard { 
 public static void main(String[] args) {
        Board b=new Board();
        List<Player>players=new ArrayList<>();
        System.out.println("Enter the count of players :");
        Scanner iny =new Scanner(System.in);
        int n=iny.nextInt();
        iny.nextLine();
        System.out.println("Enter the name  of player line by line :");
        for(int i=0;i<n;i++){
            System.out.println("Enter the name  of player "+(i+1)+" :");
            String Playernames=iny.nextLine();
            System.out.println("Enter the represent_sign(must be 'length one' eg: @ or #) of player "+(i+1)+" :");
            String Playerrpe=iny.nextLine();
            players.add(new Player(Playernames,(Playerrpe.charAt(0)+"")));
        }
        List<String>winners=new ArrayList<>();
        List<String>lossers=new ArrayList<>();
        if(n==1){
            System.out.println("if you wants to play,must have 2 members.");
        }
        while(n!=1){
            //
            for(Player player:players){
                b.board(players);
                System.out.println();
                System.out.println("Now "+player.getnam()+"("+player.getrpe()+")"+" player turn:");
                System.out.println("if roll dice press enter key else you left from game:");
                 String f=iny.nextLine();
                if(f.equals("")){
                    player.rollDice();
                    System.out.println("Now "+player.getnam()+" loction on board "+player.getloc());
                }
                else{
                    lossers.add(player.getnam());
                    System.out.println("you are left from game.");
                    players.remove((player));
                   // System.out.println(players.size());
                    n-=1;
                }
                if(player.getloc()==100){
                    System.out.println("yours is game_over and weight for result.");
                    winners.add(player.getnam());
                    System.out.println("ranks is "+winners.size());
                    players.remove((player));
                    n-=1;
                }
                if(players.size()==1){
                    break;
                }
            }
           //
        }
        for(Player player:players){
        winners.add(player.getnam());}
        System.out.println("learder_board for player:");
       // Collections.sort(players);
        for(int i=0;i<winners.size();i++){
            System.out.println((i+1)+" "+winners.get(i));
        }
        System.out.println("learder_board players who are left from game :");
        for(int i=0;i<lossers.size();i++){
            System.out.println(lossers.get(i));
        }
        System.out.println("Game Over......");



        iny.close ();   
    }
        
    
}