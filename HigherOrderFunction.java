
public class HigherOrderFunction {

    public static class Employee { 
        private int id;
        public Employee(int id) {/*...*/} 

        public void setId(int id) { this.id = id; };
        public int getId() { return this.id; }
    }

    public static class Bracket {};

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            //meh
        }
    }

    public static void reallySlowTaxCalc(Employee emp, Bracket bracket) {
        System.out.println("Calculating tax for Employee: " + emp.getId());
        sleep(2000); //pretend we calculated something
        System.out.println("Calculation finished");
        return;
    }

    public static Runnable deferTaxCalc(Employee emp) {
        System.out.println("Determining tax bracket for Employee: " + emp.getId());
        Bracket bracket = new Bracket();
        System.out.println("Returning deferred tax calculation ");
        //Look!  A closure!
        return () -> {reallySlowTaxCalc(new Employee(1234), bracket);};
    }
            

    public static void main(String[] args) {
        Runnable taxCalc = deferTaxCalc(new Employee(1234));

        //taxCalc.run();
    }

}
