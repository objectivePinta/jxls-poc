import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import java.io.*;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Employee> employees = Employee.generateSampleEmployeeData();
    Supplier supplier = Supplier.builder().name("aw").number(12244).build();
    ClassLoader classLoader = Main.class.getClassLoader();
    File file = new File(classLoader.getResource("xxxx.xlsx").getFile());

    try (InputStream is = new FileInputStream(file)) {
      try (OutputStream os = new FileOutputStream("object_collection_output.xlsx")) {
        Context context = new Context();
        context.putVar("employees", employees);
        context.putVar("supplier", supplier);
        JxlsHelper.getInstance().processTemplate(is, os, context);
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}
