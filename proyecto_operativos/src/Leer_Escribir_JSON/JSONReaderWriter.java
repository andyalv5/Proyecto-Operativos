/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Leer_Escribir_JSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
  
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

/**
 *
 * @author Hallo
 */
public class JSONReaderWriter{
    int i = 0;
//    creamos una LISTA DE STRINGS que será devuelta cuandos se corra este metodo
     String[] lista = new String[24];
     
    /**
     * 
     * @param itr es el iterador que halla " Iterador itr = 'Nombre del JSONArray'.iterador() "
     */
    public void map(Iterator itr){
        
            Iterator<Map.Entry> itr_2 = null;
            
//            Se busca dentro del while lo que está en el drive
            while(itr.hasNext()){                
                itr_2 = ((Map) itr.next()).entrySet().iterator();
                while (itr_2.hasNext()) {
                    Map.Entry pair = itr_2.next();
                    
//                    System.out.println(pair.getKey() + " : " + pair.getValue());
//                    Añadimos a la lista los valores
                    lista[i] = String.valueOf(pair.getValue());
                    i++;                                        
                }
            }
    }
    
    /**
     * Lee el archivo JSON
     */
    public void Reader(){
        
        try{
            
            // parsing file "JSONExample.json"
            
            Object obj = new JSONParser().parse(new FileReader("src\\Archivos\\jsonfile.json"));
            

            // typecasting obj to JSONObject
            JSONObject jo = (JSONObject) obj;
                        
            // obteniendo datos del JSON
            
//            creamos una LISTA DE STRINGS que será devuelta cuandos se corra este metodo
//            String[] lista = new String[24];
//            Esta queria "i" será la posición de la lista
            i = 0;
            
//            dia_en_segundos
            String dia_en_segundos = jo.get("dia_en_segundos").toString();
            lista[i] = dia_en_segundos;            
            i++;
            
            
//            dia_entre_despachos            
            String dias_entre_despachos = String.valueOf(jo.get("dias_entre_despachos"));
            
            lista[i] = dias_entre_despachos;
            i++;
            
//            Arreglo de JSON de Drive
            JSONArray Drive = (JSONArray) jo.get("Drive");
            
            Iterator Drive_itr = Drive.iterator();            
//            Iterator<Map.Entry> Drive_itr_2 = null;
            
            this.map(Drive_itr);
                        
//            Arreglo de JSON de Cantidad_Productores_Rodaje_jose_inicial
            JSONArray Cantidad_Productores_Rodaje_jose_inicial = (JSONArray) jo.get("Cantidad_Productores_Rodaje_jose_inicial");
            Iterator Cantidad_Productores_Rodaje_jose_inicial_itr = Cantidad_Productores_Rodaje_jose_inicial.iterator();
            
            this.map(Cantidad_Productores_Rodaje_jose_inicial_itr);
            
//            Arreglo de JSON de Cantidad_Productores_Rodaje_andy_inicial
            JSONArray Cantidad_Productores_Rodaje_andy_inicial = (JSONArray) jo.get("Cantidad_Productores_Rodaje_andy_inicial");
            Iterator Cantidad_Productores_Rodaje_andy_inicial_itr = Cantidad_Productores_Rodaje_andy_inicial.iterator();
            
            this.map(Cantidad_Productores_Rodaje_andy_inicial_itr);
            
//            Ensamblador_Rodaje_jose
            String Ensamblador_Rodaje_jose = String.valueOf(jo.get("Ensamblador_Rodaje_jose"));
            lista[i] = Ensamblador_Rodaje_jose;
            i++;
            
//            Ensamblador_Rodaje_andy
            String Ensamblador_Rodaje_andy = String.valueOf(jo.get("Ensamblador_Rodaje_andy"));
            lista[i] = Ensamblador_Rodaje_andy;
            i++;
            
            
            for (String lista1 : lista) {
                System.out.println(lista1);
            }
            
            
        }catch(IOException | ParseException e){
            System.out.println(e);
        }
        
        
    }
    
    /**
     * Devuelve un JSONArray con Map m = 1 de la cantidad de productores en el rodaje inicial
     * @param Productor_Intros
     * @param Productor_Creditos
     * @param Productor_Inicio
     * @param Productor_cierre
     * @param Productor_Plot_Twist
     * @return 
     */
    private JSONArray Cantidad_Productores_Rodaje_inicial(String Productor_Intros, String Productor_Creditos, String Productor_Inicio, String Productor_cierre, String Productor_Plot_Twist){
        JSONArray ja = new JSONArray();
        
        Map m = new LinkedHashMap(1);
        int Pasarlo_a_int = Integer.parseInt(Productor_Intros);
        m.put("Productor_Intros", Pasarlo_a_int);
        
        ja.add(m);
        
        m = new LinkedHashMap(1);
        Pasarlo_a_int = Integer.parseInt(Productor_Creditos);
        m.put("Productor_Creditos", Pasarlo_a_int);
        
        ja.add(m);
        
        m = new LinkedHashMap(1);
        Pasarlo_a_int = Integer.parseInt(Productor_Inicio);
        m.put("Productor_Inicio", Pasarlo_a_int);
        
        ja.add(m);
        
        m = new LinkedHashMap(1);
        Pasarlo_a_int = Integer.parseInt(Productor_cierre);
        m.put("Productor_cierre", Pasarlo_a_int);
        
        ja.add(m);
        
        m = new LinkedHashMap(1);
        Pasarlo_a_int = Integer.parseInt(Productor_Plot_Twist);
        m.put("Productor_Plot_Twist", Pasarlo_a_int);
        
        ja.add(m);
        
        return ja;
    }
    
    /**
     * Convierte Strings a enteros
     * @param string
     * @return 
     */
    private int Toint(String string){
        int integer = Integer.parseInt(string);
        return integer;
    }
    
    /**
     * Convierte Strings a booleanos
     * @param string
     * @return 
     */
    private boolean Tobool(String string){
        boolean booler = Boolean.parseBoolean(string);
        return booler;
    }
    
    /**
     * Escribe en el JSON TODOS LOS DATOS QUE SE LE PASEN
     * @param dia_en_segundos
     * @param dias_entre_despachos
     * @param parte_intro_max
     * @param Capacidad_infinita1
     * @param parte_creditos_max
     * @param Capacidad_infinita2
     * @param parte_inicio_max
     * @param Capacidad_infinita3
     * @param parte_cierre_max
     * @param Capacidad_infinita4
     * @param parte_plot_twist_max
     * @param Capacidad_infinita5
     * @param Productor_Intros_jose
     * @param Productor_Creditos_jose
     * @param Productor_Inicio_jose
     * @param Productor_cierre_jose
     * @param Productor_Plot_Twist_jose
     * @param Productor_Intros_andy
     * @param Productor_Creditos_andy
     * @param Productor_Inicio_andy
     * @param Productor_cierre_andy
     * @param Productor_Plot_Twist_andy
     * @param Ensamblador_Rodaje_jose
     * @param Ensamblador_Rodaje_andy
     * @throws FileNotFoundException 
     */
    public void Writer(String dia_en_segundos, String dias_entre_despachos, String parte_intro_max, String Capacidad_infinita1, String parte_creditos_max, String Capacidad_infinita2, String parte_inicio_max, String Capacidad_infinita3, String parte_cierre_max, String Capacidad_infinita4, String parte_plot_twist_max, String Capacidad_infinita5, String Productor_Intros_jose, String Productor_Creditos_jose, String Productor_Inicio_jose, String Productor_cierre_jose, String Productor_Plot_Twist_jose, String Productor_Intros_andy, String Productor_Creditos_andy, String Productor_Inicio_andy, String Productor_cierre_andy, String Productor_Plot_Twist_andy, String Ensamblador_Rodaje_jose, String Ensamblador_Rodaje_andy) throws FileNotFoundException{
        
        // creating JSONObject
        JSONObject jo = new JSONObject();
        
//        putting data to JSONObject
        int dia_en_segundos_int = Integer.parseInt(dia_en_segundos);
        int dias_entre_despachos_int = Integer.parseInt(dias_entre_despachos);
        
        jo.put("dia_en_segundos", dia_en_segundos_int);
        jo.put("dias_entre_despachos", dias_entre_despachos_int);
        
        // for Drive data, first create LinkedHashMap
        JSONArray ja = new JSONArray();
        
        Map m = new LinkedHashMap(2);
        
        
        m.put("parte_intro_max", this.Toint(parte_intro_max));
        m.put("Capacidad_infinita", this.Tobool(Capacidad_infinita1));
        
        ja.add(m);
        
        m = new LinkedHashMap(2);
        
        m.put("parte_creditos_max", this.Toint(parte_creditos_max));
        m.put("Capacidad_infinita", this.Tobool(Capacidad_infinita2));
        
        ja.add(m);
        
        m = new LinkedHashMap(2);
        
        m.put("parte_inicio_max", this.Toint(parte_inicio_max));
        m.put("Capacidad_infinita", this.Tobool(Capacidad_infinita3));
        
        ja.add(m);
        
        m = new LinkedHashMap(2);
       
        m.put("parte_cierre_max", this.Toint(parte_cierre_max));
        m.put("Capacidad_infinita", this.Tobool(Capacidad_infinita4));
        
        ja.add(m);
        
        m = new LinkedHashMap(2);
        
        m.put("parte_plot_twist_max", this.Toint(parte_plot_twist_max));
        m.put("Capacidad_infinita", this.Tobool(parte_plot_twist_max));
        
        ja.add(m);
        
        jo.put("Drive", ja);
        
//        Ahora para la cantidad de productores para José
        ja = this.Cantidad_Productores_Rodaje_inicial(Productor_Intros_jose, Productor_Creditos_jose, Productor_Inicio_jose, Productor_cierre_jose, Productor_Plot_Twist_jose);
        
        jo.put("Cantidad_Productores_Rodaje_jose_inicial", ja);
        
//        Ahora para la cantidad de productores para Andy;
        ja = this.Cantidad_Productores_Rodaje_inicial(Productor_Intros_andy, Productor_Creditos_andy, Productor_Inicio_andy, Productor_cierre_andy, Productor_Plot_Twist_andy);
        
        jo.put("Cantidad_Productores_Rodaje_andy_inicial", ja);
        
//        Ahora ponemos los datos de Ensambladores

        int Ensamblador_Rodaje_jose_int = Integer.parseInt(Ensamblador_Rodaje_jose);
//        ---------------------
        jo.put("Ensamblador_Rodaje_jose", Ensamblador_Rodaje_jose_int);
//        ----------------------
        int Ensamblador_Rodaje_andy_int = Integer.parseInt(Ensamblador_Rodaje_andy);
//        -----------------------------------
        jo.put("Ensamblador_Rodaje_andy", Ensamblador_Rodaje_andy_int);
//        ----------------------------
        try (//        writing JSON to file:"JSONExample.json" in cwd
                PrintWriter pw = new PrintWriter("src\\Archivos\\jsonfile.json")) {
            pw.write(jo.toJSONString());
            
            pw.flush();
        }

    }
         
}
