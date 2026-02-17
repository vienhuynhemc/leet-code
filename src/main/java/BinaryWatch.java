/* vienhuynhemc */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryWatch {

  private final Map<Integer, Integer> bitCounts = new HashMap<>();

  public List<String> readBinaryWatch(int turnedOn) {
    final List<String> result = new ArrayList<>();

    for (int hour = 0; hour <= 11; hour++) {
      final int hourBitCount = bitCounts.getOrDefault(hour, countBit(hour));

      for (int minute = 0; minute <= 59; minute++) {
        final int minuteBitCount = bitCounts.getOrDefault(minute, countBit(minute));
        if (hourBitCount + minuteBitCount == turnedOn) {
          final String hourFormat = String.valueOf(hour);
          final String minuteFormat = String.format("%s%s", minute < 10 ? 0 : "", minute);
          result.add(String.format("%s:%s", hourFormat, minuteFormat));
        }
      }
    }

    return result;
  }

  private int countBit(int number) {
    int bitCount = 0;

    while (number > 0) {
      final int bit = number % 2;
      if (bit == 1) bitCount++;
      number /= 2;
    }
    bitCounts.put(number, bitCount);

    return bitCount;
  }
}
