
public class NumberOfStudentsUnableToEatLunch {

    public int countStudents(int[] students, int[] sandwiches) {
        int idxSandwiches = 0;
        final int n = sandwiches.length;
        final boolean[] eaten = new boolean[n];
        int eatenCount = 0;

        while (idxSandwiches < n) {

            int curEaten = 0;
            for (int i = 0; i < n; i++) {
                if (eaten[i]) {
                    continue;
                }

                int student = students[i];

                if (student == sandwiches[idxSandwiches]) {
                    idxSandwiches++;
                    curEaten++;
                    eaten[i] = true;
                }
            }
            if (curEaten == 0) {
                break;
            } else {
                eatenCount += curEaten;
            }
        }

        return n - eatenCount;
    }

}
