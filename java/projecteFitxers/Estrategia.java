public class Estrategia {
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
        return "Nom de Estrategia: " + nomEstrategia + "\nDescripción de la estrategia: " + descr;
    }

}
