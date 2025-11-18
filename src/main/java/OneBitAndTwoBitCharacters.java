/* vienhuynhemc */
public class OneBitAndTwoBitCharacters {

  public boolean isOneBitCharacter(int[] bits) {
    int index = 0;
    while (index < bits.length) {
      if (bits[index] == 1) {
        index += 2;
        continue;
      }

      if (index == bits.length - 1) {
        return true;
      }
      index++;
    }

    return false;
  }
}
