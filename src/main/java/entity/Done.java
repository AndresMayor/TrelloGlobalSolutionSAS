package entity;

public class Done {

    private int id;
    private String descripccion;
    private long fecha;


    public Done(int id, String descripccion, long fecha) {
        this.id = id;
        this.descripccion = descripccion;
        this.fecha = fecha;
    }

    public Done() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripccion() {
        return descripccion;
    }

    public void setDescripccion(String descripccion) {
        this.descripccion = descripccion;
    }

    public long getFecha() {
        return fecha;
    }

    public void setFecha(long fecha) {
        this.fecha = fecha;
    }
}
