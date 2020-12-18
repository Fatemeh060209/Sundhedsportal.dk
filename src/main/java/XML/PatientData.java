package XML;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


    @XmlRootElement(name = "borger")
    @XmlType(propOrder = {
            "cpr",
            "forNavn",
            "efterNavn",
            "email"
    })
    public class PatientData{

        private String cpr;
        private String forNavn;
        private String efterNavn;
        private String email;
        @XmlElement(name = "Cpr")

        public String getCpr() {
            return cpr;
        }

        public void setCpr(String cpr) {
            this.cpr = cpr;
        }

        public String getForNavn() {
            return forNavn;
        }

        public void setForNavn(String forNavn) {
            this.forNavn = forNavn;
        }

        public String getEfterNavn() {
            return efterNavn;
        }

        public void setEfterNavn(String efterNavn) {
            this.efterNavn = efterNavn;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }



