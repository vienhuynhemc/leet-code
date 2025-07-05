package src.main.java;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        FindTheIndexOfTheFirstOccurrenceInAString findTheIndexOfTheFirstOccurrenceInAString = new FindTheIndexOfTheFirstOccurrenceInAString();
        System.out.println(findTheIndexOfTheFirstOccurrenceInAString.strStr("sadbutsad", "sad"));
        System.out.println(findTheIndexOfTheFirstOccurrenceInAString.strStr("leetcode", "leeto"));
    }

}
