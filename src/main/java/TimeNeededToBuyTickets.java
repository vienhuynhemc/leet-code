/* vienhuynhemc */
public class TimeNeededToBuyTickets {

  public int timeRequiredToBuy(int[] tickets, int k) {
    int tickedToBy = tickets[k];

    int time = 0;
    for (int i = 0; i < tickets.length; i++) {
      if (i > k) time += tickets[i] >= tickedToBy ? tickedToBy - 1 : tickets[i];
      else time += Math.min(tickets[i], tickedToBy);
    }

    return time;
  }
}
