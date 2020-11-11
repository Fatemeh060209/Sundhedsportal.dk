//Holding information about our persons.
package Java;

public class Person {
    private String fnavn, enavn, cpr;
    private int tlfnummer;
    private String CPR;

    public Person(String CPR) {
        this.CPR = CPR;
    }

    public String getCPR() {
        return CPR;
    }

    public void setCPR(String CPR) {
        this.CPR = CPR;
    }
}
