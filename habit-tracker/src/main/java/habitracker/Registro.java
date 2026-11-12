package habitracker;

import java.time.LocalDate;

public class Registro {
    String idHabito;
    LocalDate fecha;

    public  Registro(String idHabito, LocalDate fecha){
        this.idHabito=idHabito;
        this.fecha=fecha;
    }

    public String getIdHabito() {
        return idHabito;
    }
    public LocalDate getFecha() {
        return fecha;
    }

    public void setIdHabito(String idHabito) {
        this.idHabito = idHabito;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
