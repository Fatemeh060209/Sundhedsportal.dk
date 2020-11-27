package Java;

import java.sql.Timestamp;
import java.util.Date;

public class AftalerDTO {
    private String cpr;
    private String Hospital;
    private String Afdeling;
    private Date Dato;
    private Timestamp Tid;

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public String getHospital() {
        return Hospital;
    }

    public void setHospital(String hospital) {
        Hospital = hospital;
    }

    public String getAfdeling() {
        return Afdeling;
    }

    public void setAfdeling(String afdeling) {
        Afdeling = afdeling;
    }

    public Date getDato() {
        return Dato;
    }

    public void setDato(Date dato) {
        Dato = dato;
    }

    public Timestamp getTid() {
        return Tid;
    }

    public void setTid(Timestamp tid) {
        Tid = tid;
    }
}
