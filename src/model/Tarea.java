/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Tarea {
    private int id;
    private String tarea;
    private String descripcion;
    private String fechaCreacion;
    private String fechaFin;
    private String categoria;
    private int prioridad;
    private int  tiempo;

    public Tarea(String tarea, String descripcion, String fechaCreacion, String fechaFin, String categoria, int prioridad, int tiempo) {
        this.tarea = tarea;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaFin = fechaFin;
        this.categoria = categoria;
        this.prioridad = prioridad;
        this.tiempo = tiempo;
    }

    public int getId() {
        return id;
    }

    public String getTarea() {
        return tarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    

}
