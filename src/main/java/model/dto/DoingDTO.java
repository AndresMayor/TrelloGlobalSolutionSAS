package model.dto;

public class DoingDTO {


    private int id;
    private String descripccion;
    private String fecha;

    public DoingDTO(int id, String descripccion, String fecha) {
        this.id = id;
        this.descripccion = descripccion;
        this.fecha = fecha;
    }

    public DoingDTO() {
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
