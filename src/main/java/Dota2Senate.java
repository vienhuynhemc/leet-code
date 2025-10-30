/* vienhuynhemc */
public class Dota2Senate {

  public String predictPartyVictory(String senate) {
    if (senate.contains("R") && !senate.contains("D")) {
      return "Radiant";
    }
    if (!senate.contains("R") && senate.contains("D")) {
      return "Dire";
    }
    int i = 0;
    while (i < senate.length()) {
      int index = -1;
      if (senate.charAt(i) == 'D') {
        index = senate.indexOf('R', i + 1);
        if (index == -1) {
          index = senate.indexOf('R');
        }
      } else if (senate.charAt(i) == 'R') {
        index = senate.indexOf('D', i + 1);
        if (index == -1) {
          index = senate.indexOf('D');
        }
      }
      if (index != -1) {
        senate = senate.substring(0, index).concat(senate.substring(index + 1));
        if (index > i) {
          i++;
        }
      } else {
        break;
      }
    }
    return predictPartyVictory(senate);
  }

  public static void main(String[] args) {
    Dota2Senate dota2Senate = new Dota2Senate();
    System.out.println(dota2Senate.predictPartyVictory("RD"));
    System.out.println(dota2Senate.predictPartyVictory("RDD"));
    System.out.println(dota2Senate.predictPartyVictory("DDRRR"));
    System.out.println(dota2Senate.predictPartyVictory("DRRDRDRDRDDRDRDR"));
  }
}
