import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@AllArgsConstructor
@Builder
@Getter
public class Employee {
  String name;
  String birthdate;
  BigDecimal payment;
  BigDecimal bonus;

  public static List<Employee> generateSampleEmployeeData() {
    List<Employee> list = new ArrayList<>();
    IntStream.range(0, 10).forEach(i -> {
      list.add(Employee.builder().name("a" + i).birthdate("12.02.2002")
          .payment(new BigDecimal(2.3).setScale(2, BigDecimal.ROUND_HALF_UP))
          .bonus(new BigDecimal(2.3).setScale(2, BigDecimal.ROUND_HALF_UP)).build());
    });
    return list;
  }
}
