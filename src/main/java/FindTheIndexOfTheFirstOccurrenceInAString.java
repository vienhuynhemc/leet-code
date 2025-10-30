/* vienhuynhemc */
public class FindTheIndexOfTheFirstOccurrenceInAString {

  public int strStr(String haystack, String needle) {
    return haystack.indexOf(needle);
  }

  static void main() {
    FindTheIndexOfTheFirstOccurrenceInAString findTheIndexOfTheFirstOccurrenceInAString =
      new FindTheIndexOfTheFirstOccurrenceInAString();
    System.out.println(findTheIndexOfTheFirstOccurrenceInAString.strStr("sadbutsad", "sad"));
    System.out.println(findTheIndexOfTheFirstOccurrenceInAString.strStr("leetcode", "leeto"));
  }
}
