package com.crud.deportes.dto;

public class EquipoDto {


    private String nombre;
    private String ciudad;
    private String tecnico;
    private String email;

    public EquipoDto() {
    }

    public EquipoDto(String nombre, String ciudad, String tecnico, String email) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.tecnico = tecnico;
        this.email = email;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
