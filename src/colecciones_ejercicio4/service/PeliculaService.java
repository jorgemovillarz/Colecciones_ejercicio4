/*
Un cine necesita implementar un sistema en el que se puedan cargar peliculas. Para esto, 
tendremos una clase Pelicula con el título, director y duración de la película (en horas). 
Implemente las clases y métodos necesarios para esta situación, teniendo en cuenta lo 
que se pide a continuación:
En el servicio deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario 
todos sus datos y guardándolos en el objeto Pelicula.
Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si quiere 
crear otra Pelicula o no.
Después de ese bucle realizaremos las siguientes acciones: 

 */
package colecciones_ejercicio4.service;

import colecciones_ejercicio4.entidades.Pelicula;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jorge
 */
public class PeliculaService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    List<Pelicula> peliculas = new ArrayList();
    boolean salir;

    public void cargarPelicula() {

        String opcion;

        do {
            Pelicula peli = new Pelicula();
            System.out.println("Ingrese el titulo de la pelicula");
            peli.setTitulo(sc.next());
            System.out.println("Ingrese el director de la pelicula");
            peli.setDirector(sc.next());
            System.out.println("Ingrese la duracion de la pelicula en minutos");
            peli.setDuracion(sc.nextInt());

            peliculas.add(peli);

        } while (agregarOtra());
        /*do {
            System.out.println("Desea agregar otra pelicula? S/N");
                opcion = sc.next();
                if (!"N".equalsIgnoreCase(opcion) && !"S".equalsIgnoreCase(opcion)) {
                    System.out.println("Ingrese una opción Correcta");
                }
            } while (!"N".equalsIgnoreCase(opcion) && !"S".equalsIgnoreCase(opcion));
        } while (opcion.equalsIgnoreCase("S"));*/

    }

    public boolean agregarOtra() {
        String opcion;
        System.out.println("desea agregar otra peli s/n?");
        do {
            opcion = sc.next().toLowerCase();
            if (opcion.equals("s")) {
                return true;
            } else if (opcion.equals("n")) {
                return false;
            } else {
                System.out.println("opcion incorrecta");
            }
            return opcion.equals("s") ? true : false;
        } while (true);
    }

    public void menu() {
        int opcion;
        do {
            System.out.println("Ingrese una opción");
            System.out.println("1.Cargar Película.");
            System.out.println("2.Mostrar peliculas.");
            System.out.println("3.Mostrar Películas de más de una hora.");
            System.out.println("4.Mostrar Películas por duración ascendente.");
            System.out.println("5.Mostrar Películas por duración descendente.");
            System.out.println("6.Mostrar Películas por director alfabéticamente ascendente.");
            System.out.println("7.Mostrar Películas por titulo alfabéticamente ascendente.");
            System.out.println("8.Salir.");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    cargarPelicula();
                    break;
                case 2:
                    mostrarPeli();
                    break;
                case 3:
                    mayor1H();
                    break;
                case 4:
                    ordenAscendentedeDuracion();
                    break;
                case 5:
                    ordenDescendentedeDuracion();
                    break;
                case 6:
                    ordenAscendentedeDirector();
                    break;
                case 7:
                    ordenAscendentedeTitulo();
                    break;

                case 8:
                    salir = true;
                    break;
                default:
                    System.out.println("SELECCIONE OPCION VALIDA!!");
            }
        } while (!salir);

    }

    public void mostrarPeli() {
        if (peliculas.size() == 0) {
            System.out.println("INGRESA PELICULA ANTES DE QUERER CARGAR");
        } else {
            for (Pelicula pelicula : peliculas) {
                System.out.println(pelicula);
            }

        }
    }

    public void mayor1H() {

        for (Pelicula mayor1 : peliculas) {
            if (mayor1.getDuracion() > 60) {
                System.out.println(mayor1);
            }
        }
    }
    public static Comparator<Pelicula> ordenarDuracionAscendente = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula p1, Pelicula p2) {
            return p1.getDuracion().compareTo(p2.getDuracion());

        }
    };

    public void ordenAscendentedeDuracion() {
        peliculas.sort(ordenarDuracionAscendente);
        mostrarPeli();
    }

    public void ordenDescendentedeDuracion() {
        peliculas.sort(ordenarDuracionAscendente.reversed());
        mostrarPeli();
    }

    public static Comparator<Pelicula> ordenarDirectorAscendente = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula p1, Pelicula p2) {
            return p1.getDirector().compareTo(p2.getDirector());

        }
    };

    public void ordenAscendentedeDirector() {
        peliculas.sort(ordenarDirectorAscendente);
        mostrarPeli();

    }
    public static Comparator<Pelicula> ordenarTituloAscendente = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula p1, Pelicula p2) {
            return p1.getTitulo().compareTo(p2.getTitulo());

        }
    };

    public void ordenAscendentedeTitulo() {
        peliculas.sort(ordenarTituloAscendente);
        mostrarPeli();

    }
}
