import java.util.Random;
import java.util.Scanner;

public class DiceRoll {
    private int minimum = 1;

    private int maximum = 6;

    private int range = maximum-minimum+1;

    public int rollDice() {
        return new Random().nextInt(range) + 1;
    }

    public void initiateTrial(PlayerDTO dto,DiceGame diceGame,int currentInstance,int finalRank) {
        System.out.println(dto.getName()+" its your turn (press ‘r’ to roll the dice)");
        Scanner turn = new Scanner(System.in);
        char c = turn.next().charAt(0);
        if((c =='r' || c=='R') && dto.getScoreAchieved()<diceGame.getMinimumPoints()) {
            DiceRoll roll = new DiceRoll();
            int trialRoll =roll.rollDice();
            if(trialRoll!=6) {
                dto.setScoreAchieved(dto.getScoreAchieved()+trialRoll);
                System.out.println(dto.getName()+" got "+trialRoll+" points in this"+currentInstance+ "round, total score is:"+dto.getScoreAchieved());
            }
            if(trialRoll==1 && dto.getLastMove()!=null && dto.getLastMove()==1) {
                System.out.println("Skipping"+dto.getName()+"'s chance as you got succcessive 1's in 2 rounds");
                dto.setSkipNextMove(true);
            }
            else if(trialRoll==6) {
                System.out.println("Giving one more change to "+dto.getName()+"'you got a 6");
                dto.setScoreAchieved(dto.getScoreAchieved()+trialRoll);
                initiateTrial(dto,diceGame,currentInstance,finalRank);
            }
            dto.setLastMove(trialRoll);

        }
        else if(dto.getScoreAchieved()<diceGame.getMinimumPoints()) {
            finalRank++;
            System.out.println(dto.getName()+": game over :total score:"+dto.getScoreAchieved()+": rank: "+finalRank);
        }
    }

}
