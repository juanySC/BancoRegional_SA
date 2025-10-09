/*El sistema debe ser capaz de almacenar la información individual de cada cliente del
banco, incluyendo sus datos de identificación únicos y su nombre completo.*/

package org.example.cliente;

public class Cliente {
    //atributos
    private final String identificacion;
    private String nombreCompleto;

    //constructor
    public Cliente(String identificacion, String nombreCompleto){

        //pongo una condicion para que la identificacion no venga vacia
        //1.- Trim: Crea una nueva cadena de texto a partir de la original, pero eliminando
        //todos los espacios en blanco que pueda tener al principio y al final.
        //2.-  isEmpty: Esto  comprueba si la cadena de texto está vacía después de que se eliminaron los espacios
        // devuelve un true
        if (identificacion == null || identificacion.trim().isEmpty()){
            throw  new IllegalArgumentException("La identificacion del cliente no puede estar vacio");
        }

        if (nombreCompleto == null || nombreCompleto.trim().isEmpty()){
            throw  new IllegalArgumentException("El nombre del cliente no puede estar vacío");
        }

        this.identificacion = identificacion.trim();
        this.nombreCompleto = nombreCompleto.trim();
    }

    //metodos
    //

    //getters and setters


    public String getIdentificacion() {
        return identificacion;
    }

    //no obtengo el set de identificacion porque no quiero que se modifique

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    //por si se desea cambiar el nombre
    public void setNombreCompleto(String nuevoNombre) {
        if(nuevoNombre != null && !nuevoNombre.trim().isEmpty() ){
            //se le asigna el nuevo valor
            this.nombreCompleto = nuevoNombre.trim();
        } else {
            throw new IllegalArgumentException("Error: El nombre no ha sido modificado");
        }
    }

    //mostrando toda la informacion

    @Override
    public String toString() {
        return "Cliente{" +
                "identificacion='" + identificacion + '\'' +
                ", nombre='" + nombreCompleto + '\'' +
                '}';
    }
}



