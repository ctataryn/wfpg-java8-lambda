import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;

public class Java7Main {

    public static void iGuessThisIsUsefulForSome() {
        Integer SSN = 645_234_827;

        Integer binaryVal = 0b00000101; //5

        System.out.println(SSN);
        System.out.println(binaryVal);
    }
    public static void stringSwitch() {

        //only 15 years overdue...
        String greeting = "Hello";

        switch (greeting) {
            case "Hello" : System.out.println("Hey, how goes it?");
                           break;
            case "Goodbye":System.out.println("See ya!");
                           break;
            default: System.out.println("Que?");
        }
    }

    public static void diamond() {

        Map<String, Map<String, List<String>>> occupations6 = new HashMap<String, Map<String, List<String>>>();

        //now becomes:
        Map<String, Map<String, List<String>>> occupations7 = new HashMap<>();

    }

    public static Properties oldCatchFinally() {
        Properties vlookupProps = new Properties();
        InputStream in = Java7Main.class.getResourceAsStream("/vlookup.properties");

        try {
            vlookupProps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                System.out.println("ERROR: *** Properties file most likely not found ***");
                e.printStackTrace();
            } catch (RuntimeException rte) {
                System.out.println("ERROR: *** Properties file most likely not found ***");
                rte.printStackTrace();
            }
        }
        return vlookupProps;
    }

    public static Properties newMultiCatch() {
        Properties vlookupProps = new Properties();
        InputStream in = Java7Main.class.getResourceAsStream("/vlookup.properties");

        try {
            vlookupProps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException | RuntimeException e) {
                e.printStackTrace();
            }
        }
        return vlookupProps;
    }

    public static Properties newTryWithResource() {
        Properties vlookupProps = new Properties();
        try (InputStream in = Java7Main.class.getResourceAsStream("/vlookup.properties")) {
            vlookupProps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vlookupProps;
    }

  static class FirstException extends Exception { }
  static class SecondException extends Exception { }

    public void rethrowException(String exceptionName) throws Exception {
        try {
            if (exceptionName.equals("First")) {
                throw new FirstException();
            } else {
                throw new SecondException();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void preciseRethrowException(String exceptionName) throws FirstException, SecondException {
        try {
            if (exceptionName.equals("First")) {
                throw new FirstException();
            } else {
                throw new SecondException();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void main(String[] args) {

        iGuessThisIsUsefulForSome();

    }
}
