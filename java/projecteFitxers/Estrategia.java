import java.io.Serializable;

public class Estrategia implements Serializable {
    private static final long serialVersionUID = 1L;
    String nomEstrategia;
    String descr;

    
    public Estrategia() {

    }
    
    public Estrategia(String nomEstrategia, String descr) {
        this.nomEstrategia = nomEstrategia;
        this.descr = descr;
    }

    public String getNomEstrategia() {
        return nomEstrategia;
    }

    public void setNomEstrategia(String nomEstrategia) {
        this.nomEstrategia = nomEstrategia;
    }

    public String getDescr() {
        return descr;
    }
    
    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public String toString(){
        return " Nom de Estrategia: " + nomEstrategia + "\n Descripción de la estrategia: " + descr;
    }

}
