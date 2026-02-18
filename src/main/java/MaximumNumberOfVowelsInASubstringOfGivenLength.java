/* vienhuynhemc */
import helper.LoadString;
import helper.LogTimeExecute;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {

  public int maxVowels(String s, int k) {
    int max = 0;
    char[] array = s.toCharArray();
    for (int i = 0; i < k; i++) {
      if (isVowel(array[i])) {
        max++;
      }
    }
    int before = max;
    for (int i = k; i < array.length; i++) {
      if (isVowel(array[i])) {
        before++;
      }
      if (isVowel(array[i - k])) {
        before--;
      }
      if (before > max) {
        max = before;
      }
    }
    return max;
  }

  private boolean isVowel(char character) {
    return character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u';
  }

  public static void main(String[] args) {
    MaximumNumberOfVowelsInASubstringOfGivenLength maximumNumberOfVowelsInASubstringOfGivenLength =
      new MaximumNumberOfVowelsInASubstringOfGivenLength();
    System.out.println(maximumNumberOfVowelsInASubstringOfGivenLength.maxVowels("abciiidef", 3));
    System.out.println(maximumNumberOfVowelsInASubstringOfGivenLength.maxVowels("aeiou", 2));
    System.out.println(maximumNumberOfVowelsInASubstringOfGivenLength.maxVowels("leetcode", 3));
    System.out.println(maximumNumberOfVowelsInASubstringOfGivenLength.maxVowels("weallloveyou", 7));
    String largeString = LoadString.getInstance()
      .loadStringFromFile("src/main/resources/test-data/maximum-number-of-vowels-in-a-substring-of-given-length.txt");
    LogTimeExecute.getInstance()
      .log(unused -> maximumNumberOfVowelsInASubstringOfGivenLength.maxVowels(largeString, 50436));
  }
}
