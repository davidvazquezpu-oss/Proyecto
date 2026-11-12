package habitracker;

import java.time.LocalDate;
import java.util.List;

public class GestorHabitos {
    List<Habito> listaHabitos;
    List<Registro> listaRegistros;

    public void añadirHabito(Habito h){
        if(h == null){
            throw new IllegalArgumentException("El nuevo habito no puede ser nulo");
        }
        listaHabitos.add(h);
    }
    public void marcarCumplido(String idHabito, LocalDate fecha){
        
    }
}
