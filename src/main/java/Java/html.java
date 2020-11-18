package Java;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


    @XmlRootElement(name = "boger")
    @XmlType(propOrder = {
            "cpr",
            "forNavn",
            "efterNavn",
    })
    public class html{

        private String cpr;
        private String forNavn;
        private String efterNavn;
        @XmlElement(name = "borgerInfo")

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


    }



