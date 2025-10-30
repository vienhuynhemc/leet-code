
public class NumberOfLaserBeamsInABank {

    public int numberOfBeams(String[] bank) {
        int prevDeviceCount = 0;
        int result = 0;

        for (String s : bank) {
            final char[] arr = s.toCharArray();
            int deviceCount = 0;
            for (char c : arr) {
                if (c == '1') {
                    deviceCount++;
                }
            }

            if (deviceCount == 0) {
                continue;
            }

            if (prevDeviceCount != 0) {
                result += deviceCount * prevDeviceCount;
            }

            prevDeviceCount = deviceCount;
        }

        return result;
    }
}
