package utp.misiontic2022.c2.p41.reto4;

public class Requerimiento_2 {
    private int idProyecto;
    private String proveedor;
    private String pagado;
    private int idMaterialConstruccion;
    private String materialConstruccion;

    public Requerimiento_2() {

    }

    public Requerimiento_2(int idProyecto, String proveedor, String pagado, int idMaterialConstruccion,
            String materialConstruccion) {
        this.idProyecto = idProyecto;
        this.proveedor = proveedor;
        this.pagado = pagado;
        this.idMaterialConstruccion = idMaterialConstruccion;
        this.materialConstruccion = materialConstruccion;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getPagado() {
        return pagado;
    }

    public void setPagado(String pagado) {
        this.pagado = pagado;
    }

    public int getIdMaterialConstruccion() {
        return idMaterialConstruccion;
    }

    public void setIdMaterialConstruccion(int idMaterialConstruccion) {
        this.idMaterialConstruccion = idMaterialConstruccion;
    }

    public String getMaterialConstruccion() {
        return materialConstruccion;
    }

    public void setMaterialConstruccion(String materialConstruccion) {
        this.materialConstruccion = materialConstruccion;
    } 
}
