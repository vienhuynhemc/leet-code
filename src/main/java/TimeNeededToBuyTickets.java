
public class TimeNeededToBuyTickets {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int tickedToBy = tickets[k];

        int time = 0;
        for (int i = 0; i < n; i++) {
            if (i > k) {
                int ticket = tickets[i];
                time += ticket >= tickedToBy ? tickedToBy - 1 : ticket;
            } else {
                time += Math.min(tickets[i], tickedToBy);
            }
        }

        return time;
    }

}
