/* vienhuynhemc */
public class NumberOfStudentsUnableToEatLunch {

  public int countStudents(int[] students, int[] sandwiches) {
    final boolean[] eaten = new boolean[sandwiches.length];
    int idxSandwiches = 0;
    int eatenCount = 0;

    while (idxSandwiches < sandwiches.length) {
      int curEaten = 0;

      for (int i = 0; i < sandwiches.length; i++) {
        if (eaten[i]) continue;

        int student = students[i];

        if (student == sandwiches[idxSandwiches]) {
          idxSandwiches++;
          curEaten++;
          eaten[i] = true;
        }
      }

      if (curEaten == 0) break;
      else eatenCount += curEaten;
    }

    return sandwiches.length - eatenCount;
  }
}
