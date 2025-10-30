/* vienhuynhemc */
public class DeleteCharactersToMakeFancyString {

  public String makeFancyString(String s) {
    final StringBuilder builder = new StringBuilder();

    final char[] chars = s.toCharArray();

    int count = 1;
    char currentChar = chars[0];
    builder.append(currentChar);

    for (int i = 1; i < chars.length; i++) {
      if (currentChar == chars[i]) {
        count++;
      } else {
        count = 1;
        currentChar = chars[i];
      }

      if (count < 3) {
        builder.append(currentChar);
      }
    }

    return builder.toString();
  }
}
