
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

class SmallestInfiniteSet {

    private int start;
    private final SortedSet<Integer> set;

    public SmallestInfiniteSet() {
        this.set = new TreeSet<>();
        this.start = 1;
    }

    public int popSmallest() {
        int result = start;
        Iterator<Integer> iterator = this.set.iterator();
        if (iterator.hasNext()) {
            result = iterator.next();
            this.set.remove(result);
        } else {
            start++;
        }
        return result;
    }

    public void addBack(int num) {
        if (num < start) {
            this.set.add(num);
        }
    }

}