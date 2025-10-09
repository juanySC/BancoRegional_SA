/*El sistema debe ser capaz de almacenar la información individual de cada cliente del
banco, incluyendo sus datos de identificación únicos y su nombre completo.*/

package org.example.cliente;

public class Cliente {
    //atributos
    private final String identificacion;
    private String nombre;

    //constructor
    public Cliente(String identificacion, String nombre){

        //pongo una condicion para que la identificacion no venga vacia
        //1.- Trim: Crea una nueva cadena de texto a partir de la original, pero eliminando
        //todos los espacios en blanco que pueda tener al principio y al final.
        //2.-  isEmpty: Esto  comprueba si la cadena de texto está vacía después de que se eliminaron los espacios
        // devuelve un true
        if (identificacion == null || identificacion.trim().isEmpty()){
            throw  new IllegalArgumentException("La identificacion del cliente no puede estar vacio");
        }

        this.identificacion = identificacion.trim();

        if (nombre == null || nombre.trim().isEmpty()){
            throw  new IllegalArgumentException("El nombre del cliente no puede estar vacío");
        }

        this.nombre = nombre.trim();
    }

    //metodos
    //

    //getters and setters


    public String getIdentificacion() {
        return identificacion;
    }

    //no obtengo el set de identificacion porque no quiero que se modifique

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //mostrando toda la informacion

    @Override
    public String toString() {
        return "Cliente{" +
                "identificacion='" + identificacion + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}



