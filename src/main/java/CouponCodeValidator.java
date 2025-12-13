/* vienhuynhemc */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CouponCodeValidator {

  private record Pair(String coupon, String businessLine) {}

  final Map<String, Integer> validBusinessLines = Map.of(
    "electronics",
    1,
    "grocery",
    2,
    "pharmacy",
    3,
    "restaurant",
    4
  );
  final Set<String> invalidCoupons = new HashSet<>();

  public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
    final List<Pair> validCoupons = new ArrayList<>();

    for (int i = 0; i < code.length; i++) {
      if (isValidCoupon(code[i], businessLine[i], isActive[i])) {
        validCoupons.add(new Pair(code[i], businessLine[i]));
      }
    }

    sortCoupons(validCoupons);

    return mapToCoupons(validCoupons);
  }

  private List<String> mapToCoupons(List<Pair> validCoupons) {
    final List<String> result = new ArrayList<>();
    validCoupons.forEach(pair -> result.add(pair.coupon));

    return result;
  }

  private void sortCoupons(List<Pair> coupons) {
    final Comparator<Pair> couponCodeComparator = (o1, o2) -> {
      final int point1 = validBusinessLines.get(o1.businessLine());
      final int point2 = validBusinessLines.get(o2.businessLine());

      if (point1 == point2) {
        return o1.coupon().compareTo(o2.coupon());
      }

      return point1 - point2;
    };

    coupons.sort(couponCodeComparator);
  }

  private boolean isValidCoupon(String coupon, String businessLine, boolean isActive) {
    if (coupon.isEmpty()) {
      return false;
    }

    if (!isActive) {
      return false;
    }

    if (!validBusinessLines.containsKey(businessLine)) {
      return false;
    }

    final char[] chars = coupon.toCharArray();
    for (char aChar : chars) {
      if (aChar < 48 || (aChar > 57 && aChar < 65) || (aChar > 90 && aChar < 97 && aChar != 95) || aChar > 122) {
        invalidCoupons.add(coupon);
        return false;
      }
    }

    return true;
  }
}
