import java.util.*;
import java.util.stream.IntStream;

public class DicePlay {
    public static void main(String[] args) {
        DiceGame diceGame = new DiceGame();
        diceGame.setTotalPlayers(Integer.parseInt(args[0]));
        diceGame.setMinimumPoints(Integer.parseInt(args[1]));
        List <PlayerDTO> playerList = new ArrayList<>();
        for(int i=1;i<=diceGame.getTotalPlayers();i++) {
            PlayerDTO dto = new PlayerDTO("Player-"+i,0);
            playerList.add(dto);
        }
        diceGame.setPlayersList(playerList);

        //The order in which the users roll the dice is decided randomly at the start of the game
        int round =0;
        int finalRank = 0;
        Collections.shuffle(diceGame.getPlayersList());
        DiceRoll roll = new DiceRoll();
        while(diceGame.getPlayersList().stream().anyMatch(e->e.getScoreAchieved()<diceGame.getMinimumPoints())) {
            round++;
            for(int i=0;i<diceGame.getPlayersList().size();i++) {
                int finalI = i;
                PlayerDTO dto=diceGame.getPlayersList().stream().filter(playerDTO -> playerDTO.getName().equals(diceGame.getPlayersList().get(finalI).getName())).findAny().orElse(null);
                if(dto.getScoreAchieved()<diceGame.getMinimumPoints() && !dto.isSkipNextMove()) {
                    roll.initiateTrial(dto,diceGame,round,finalRank);
                }
                else if(dto.isSkipNextMove()) {
                    dto.setSkipNextMove(false);
                }
                else if(dto.getScoreAchieved()>=diceGame.getMinimumPoints()) {
                    finalRank++;
                    System.out.println(dto.getName()+": game over :total score:"+dto.getScoreAchieved()+": rank: "+finalRank);
                }
            }



            System.out.println("\nCurrent Rank Status:");
            int[] rankAndScore = diceGame.getPlayersList().stream().mapToInt(PlayerDTO::getScoreAchieved).sorted().toArray();
            System.out.println("rank\tscore");
            IntStream.rangeClosed(1, rankAndScore.length)
                    .forEachOrdered(r->System.out.println(r+"\t\t\t\t"+rankAndScore[rankAndScore.length-r]));

        }

    }
}
