package iteso.com.tarea01;

class Alumno {
        String Nombre="";
        String Telefono="";
        String Escolaridad="";
        String Genero="";
        String Libro="";
        String Deporte="";

        public String toString(){
            String cadena;
           if(Libro.equals("")){
            cadena= "Nombre: "+ Nombre +"\n"+
                    "Telefono: "+ Telefono +"\n"+
                    "Escolaridad: "+ Escolaridad +"\n"+
                    "Genero: "+Genero+"\n"+
                    "Practica Deporte: "+Deporte+"\n";}
           else {
               cadena= "Nombre: "+ Nombre +"\n"+
                       "Telefono: "+ Telefono +"\n"+
                       "Escolaridad: "+ Escolaridad +"\n"+
                       "Genero: "+Genero+"\n"+
                       "Libro Favorito: "+Libro+"\n"+
                       "Practica Deporte: "+Deporte+"\n";
           }
                    return cadena;
        }
    }
