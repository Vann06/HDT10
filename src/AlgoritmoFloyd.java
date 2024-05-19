import java.util.*;

public class AlgoritmoFloyd {

    private Vector<String> Ubicacion;
    private Vector<String> camino;
    private int[][] distancia;
    private int[][] ruta;


    public AlgoritmoFloyd(){
        // Instances
        Ubicacion= new  Vector<String>();
        camino = new Vector<String>();
        distancia= new int [35][35];
        ruta= new int [35][35];

        for (int i =0; i<35; i++){
            for (int j =0; j<35; j++){
                ruta [i][j]=100;
                if (i==j){
                    distancia[i][j]=0;
                }else{
                    distancia [i][j]=100;
                }
            }
        }
    }

    public void agregar(String s, String a, String d){
        int kms;
        int kma;
        if (!Ubicacion.contains(s) || !Ubicacion.contains(a)){
            Ubicacion.add(s);
            Ubicacion.add(a);
        }
        kms=Ubicacion.indexOf(s);
        kma=Ubicacion.indexOf(a);
        distancia[kms][kma]= Integer.parseInt(d);
        if (d=="100"){
            ruta[kms][kma]=100;
        }else{
            ruta[kms][kma]= kma;
        }
    }


    public boolean existe(String s,String a){
        boolean esta= false;
        if(Ubicacion.contains(s) && Ubicacion.contains(a)){
            esta=true;
        }return esta;
    }


    public void Shorter_rute(){
        for (int i=0; i<Ubicacion.size();i++){
            for (int j = 0; j<Ubicacion.size(); j++){
                for (int k = 0; k<Ubicacion.size(); k++){
                    // contional that evaluates if the distance continues to be a infinite
                    if (distancia[j][i]==100 || distancia[i][k]==100)
                        continue; // label that skips the remaining statements in the loop and proceeds to the next
                    if (distancia[j][i] + distancia[i][k]<distancia[j][k]){
                        // changes the distance and rute
                        distancia[j][k]=distancia[j][i] + distancia[i][k];
                        ruta[j][k]= ruta [j][i];
                    }
                }
            }
        }
    }

    /**
     * Method to find the center of the graph
     */
    public void center(){
        int max=0;
        int j ;
        int min=0;
        Vector<Integer> centro = new  Vector<Integer>(); // vector to save the data of the center

        for(int i =0;i<Ubicacion.size();i++){
            for(max=distancia[i][0], j =0; j< Ubicacion.size(); j++){
                // verify if the matrix is greater than 0
                if(distancia[i][j]>max)
                    max = distancia[i][j]; // assing the greater number in the variable
            }
            if(i==0||max>min){
                min = max;
            }
            centro.add(max); // add to the matrix the greater number
        }

        int o = Collections.min(centro); // gets the minimum number in the vector
        int ub= centro.indexOf(o); // gets the index of the minimum number
        String ub2= Ubicacion.get(ub); // gets the name of the city
        //Pints to show the data
        System.out.println("\n-La excentridad minima es de: "+ o );
        System.out.println("El centro del grafo es: " + ub2);
    }

    /**
     * Metod to check what cities were used
     * @param s city number 1
     * @param a city nimber 2
     */
    public void cerca(String s, String a){
        int u1= Ubicacion.indexOf(s); // gets the index of the first city entered by the user
        int u2= Ubicacion.indexOf(a); // gets the index of the second city entered by the user
        //Shows the cities
        print(u1, u2);
        printt(u1,u2);
    }

    /**
     *  Method to get the distance traveled
     * @param
     * @param a city nimber 2
     * @return the km of the distance traveled
     */
    public int recorrido(String s, String a){
        // int to saved the distance traveld acording to the cities entered by the user
        int recorrio= distancia[Ubicacion.indexOf(s)][Ubicacion.indexOf(a)];
        return recorrio;
    }
    /**
     * Method to print certain data of  matrix
     * @param k city one
     * @param m city two
     */
    public void printt(int k, int m){
        int tamano = camino.size(); // int that saves the size of the vector
        // cycle that prints the vector information as long as it is less than the amount of data that is stored
        for(int i = 0; i < tamano - 1; i++)
            // prints the data of the vector
            System.out.print(camino.get(i) + " \n - ");
        System.out.print(camino.get(tamano - 1) + "\n");
    }

    /**
     * Method to print certain data of  matrix
     * @param k
     * @param m
     */
    public void print (int k, int m){

        camino.add("\n--"+Ubicacion.get(k)); // add to the vector the first city
        //conditional that checks if it is possible to travel from one city to anotherone
        if (distancia[k][m] == 100 || distancia[k][m] == 0){
            // checks if the distance eaquals a infinite and shows a message
            System.out.println("\n****No existe una conección entre ciudades****\n");
        }else{
            // if the distance is not infinite saves the data
            while (k!= m){
                k = ruta[k][m];
                camino.add(Ubicacion.get(k));
            }
        }
    }
}