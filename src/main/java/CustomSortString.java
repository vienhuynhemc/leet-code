/* vienhuynhemc */
public class CustomSortString {

  public String customSortString(String order, String s) {
    int[] priorities = new int[26];
    char[] orderChars = order.toCharArray();
    for (int i = 0; i < orderChars.length; i++) {
      priorities[orderChars[i] - 97] = i;
    }

    char[] inputChars = s.toCharArray();
    quickSort(inputChars, 0, s.length() - 1, priorities);

    return String.valueOf(inputChars);
  }

  private void quickSort(char[] arr, int low, int high, int[] priorities) {
    if (low < high) {
      int pi = partition(arr, low, high, priorities);

      quickSort(arr, low, pi - 1, priorities);
      quickSort(arr, pi + 1, high, priorities);
    }
  }

  private int partition(char[] arr, int low, int high, int[] priorities) {
    int pivot = priorities[arr[high] - 97];

    int i = (low - 1);

    for (int j = low; j <= high - 1; j++) {
      if (priorities[arr[j] - 97] < pivot) {
        i++;
        swap(arr, i, j);
      }
    }
    swap(arr, i + 1, high);
    return (i + 1);
  }

  private void swap(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
