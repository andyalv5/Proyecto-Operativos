
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
import proyecto_operativos.Proyecto_operativos;

/**
 *
 * @author Hallo
 */
public class JSONReaderWriter{
    
    
    public static int dia_en_segundos;
    public static int dias_entre_despachos;
    
//    Drive
    
    public static int parte_intro_max;
    public static boolean Capacidad_infinita_intro;
    
    public static int parte_creditos_max;
    public static boolean Capacidad_infinita_creditos;
    
    public static int parte_inicio_max;
    public static boolean Capacidad_infinita_inicio;
    
    public static int parte_cierre_max;
    public static boolean Capacidad_infinita_cierre;
    
    public static int parte_plot_twist_max;
    public static boolean Capacidad_infinita_plot_twist;
    
//    Cantidad_Productores_Rodaje_jose_inicial
    
    public static int Productor_Intros_jose;
    public static int Productor_Creditos_jose;
    public static int Productor_Inicio_jose;
    public static int Productor_cierre_jose;
    public static int Productor_Plot_Twist_jose;
    
//    Cantidad_Productores_Rodaje_andy_inicial
    
    public static int Productor_Intros_andy;
    public static int Productor_Creditos_andy;
    public static int Productor_Inicio_andy;
    public static int Productor_cierre_andy;
    public static int Productor_Plot_Twist_andy;
    
//    Ensambladores
    
    public static int Ensamblador_Rodaje_jose;
    public static int Ensamblador_Rodaje_andy; 
    
//    Ingresos
    public static int Ingresos_Rodaje_jose;    
    public static int Ingresos_Rodaje_andy;
    
//    Costos
    public static int Costos_Rodaje_jose;    
    public static int Costos_Rodaje_andy;
    
    
    int i = 0;
//    creamos una LISTA DE STRINGS que será devuelta cuandos se corra este metodo
     String[] lista = new String[28];
     
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
    public void Reader() throws FileNotFoundException{
        
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
            
               
//    Ingresos
            String Ingresos_Rodaje_jose = String.valueOf(jo.get("Ingresos_Rodaje_jose"));
            lista[i] = Ingresos_Rodaje_jose;    
            i++;
            
            String Ingresos_Rodaje_andy = String.valueOf(jo.get("Ingresos_Rodaje_andy"));
            lista[i] = Ingresos_Rodaje_andy;
            i++;

//    Costos
            String Costos_Rodaje_jose = String.valueOf(jo.get("Costos_Rodaje_jose"));
            lista[i] = Costos_Rodaje_jose;    
            i++;
            
            String Costos_Rodaje_andy = String.valueOf(jo.get("Costos_Rodaje_andy"));
            lista[i] = Costos_Rodaje_andy;
            i++;
            
//            for (String lista1 : lista) {
//                System.out.println(lista1);
//            }
//            Ponemos en variables publicas para las demás clases los valores correspondientes

            
            JSONReaderWriter.dia_en_segundos = this.Toint(lista[0]);
            JSONReaderWriter.dias_entre_despachos = this.Toint(lista[1]);
            JSONReaderWriter.parte_intro_max = this.Toint(lista[2]);
            JSONReaderWriter.Capacidad_infinita_intro = this.Tobool(lista[3]);
            
            JSONReaderWriter.parte_creditos_max = this.Toint(lista[4]);
            JSONReaderWriter.Capacidad_infinita_creditos = this.Tobool(lista[5]);
            
            JSONReaderWriter.parte_inicio_max = this.Toint(lista[6]);
            JSONReaderWriter.Capacidad_infinita_inicio = this.Tobool(lista[7]);
            
            JSONReaderWriter.parte_cierre_max = this.Toint(lista[9]);
            JSONReaderWriter.Capacidad_infinita_cierre = this.Tobool(lista[8]);
            
            JSONReaderWriter.parte_plot_twist_max = this.Toint(lista[11]);
            JSONReaderWriter.Capacidad_infinita_plot_twist = this.Tobool(lista[10]);
            
//    Cantidad_Productores_Rodaje_jose_inicial
    
            JSONReaderWriter.Productor_Intros_jose = this.Toint(lista[12]);
            JSONReaderWriter.Productor_Creditos_jose = this.Toint(lista[13]);
            JSONReaderWriter.Productor_Inicio_jose = this.Toint(lista[14]);
            JSONReaderWriter.Productor_cierre_jose = this.Toint(lista[15]);
            JSONReaderWriter.Productor_Plot_Twist_jose = this.Toint(lista[16]);
                
////    Cantidad_Productores_Rodaje_andy_inicial
            
            JSONReaderWriter.Productor_Intros_andy = this.Toint(lista[17]);
            JSONReaderWriter.Productor_Creditos_andy = this.Toint(lista[18]);
            JSONReaderWriter.Productor_Inicio_andy = this.Toint(lista[19]);
            JSONReaderWriter.Productor_cierre_andy = this.Toint(lista[20]);
            JSONReaderWriter.Productor_Plot_Twist_andy = this.Toint(lista[21]);
    
//    Ensambladores
    
            JSONReaderWriter.Ensamblador_Rodaje_jose = this.Toint(lista[22]);
            JSONReaderWriter.Ensamblador_Rodaje_andy = this.Toint(lista[23]);
            
//            Ingresos
            JSONReaderWriter.Ingresos_Rodaje_jose = this.Toint(lista[24]);
            JSONReaderWriter.Ingresos_Rodaje_andy = this.Toint(lista[25]);
            
//            Costos
            JSONReaderWriter.Costos_Rodaje_jose = this.Toint(lista[26]);
            JSONReaderWriter.Costos_Rodaje_andy = this.Toint(lista[27]);
            
                        
//            Ahora le ponemos el valor a dia_en_ms de la clase "Proyectos_operativos"
            Proyecto_operativos.dia_en_ms = JSONReaderWriter.dia_en_segundos * 1000;
                   
//            Ahora ponemos el valor a contador_dias_restantes de la clase "Proyectos_operativos"   
            int variable_para_contador_dias_restantes = JSONReaderWriter.dias_entre_despachos;
            
            Proyecto_operativos.contador_dias_restantes_andy = variable_para_contador_dias_restantes;
            Proyecto_operativos.contador_dias_restantes_jose = variable_para_contador_dias_restantes;
            
            if(!this.Validador_del_JSONfile()){
                
                System.out.println("Arreglando JSON al por defecto");
                
//                this.Writer("1", "30", "30", "false", "25", "false", "50", "false", "55", "false", "40", "false", "15", "1", "1", "1", "1", "14", "1", "1", "1", "1", "1", "1","0","0","0","0");
                this.ArreglarJSONporDefecto();
                
                Proyecto_operativos.keep = false;
                
            }
            
            
        }catch(Exception e){
            System.out.println(e);
            
            System.out.println("Arreglando JSON al por defecto");
//            this.Writer("1", "30", "30", "false", "25", "false", "50", "false", "55", "false", "40", "false", "15", "1", "1", "1", "1", "14", "1", "1", "1", "1", "1", "1","0","0","0","0");
            this.ArreglarJSONporDefecto();
            Proyecto_operativos.keep = false;
        }
        
        
    }
    /**
     * Arregla el JSON a datos predeterminados para que no haya errores
     * @throws FileNotFoundException 
     */
    public void ArreglarJSONporDefecto() throws FileNotFoundException{
        this.Writer("1", "30", "30", "false", "25", "false", "50", "false", "55", "false", "40", "false", "15", "1", "1", "1", "1", "14", "1", "1", "1", "1", "1", "1","0","0","0","0");
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
     * Valida los datos que se pusieron en el JSON
     * @return true SI TODOS los datos son válidos, false SI ALGUNO ES MALO
     */
    private boolean Validador_del_JSONfile(){
        
//        Agregamos Try-catch para asegurar que no halla datos "raros" en el JSON
        try{
    //        Verificamos que el dia_en_segundos no sea negativo
            if(JSONReaderWriter.dia_en_segundos < 0){
                System.out.println("No tiene sentido que un dia sean " + JSONReaderWriter.dia_en_segundos + " milisegundos");
                return false;
            }        

    //        Verificamos que el dia entre despachos no sea mayor que cero
            if(JSONReaderWriter.dias_entre_despachos <= 0){
                System.out.println("No es conveniente que el valor de dias entre despachos sea " + JSONReaderWriter.dias_entre_despachos);
                return false;
            }

    //        Se verifica que la capacidad máxima de almacenaje en el Drive de ninguna de las partes sea <= 0
            if(JSONReaderWriter.parte_intro_max <= 0 || JSONReaderWriter.parte_creditos_max <= 0 || JSONReaderWriter.parte_inicio_max <= 0 || JSONReaderWriter.parte_cierre_max <= 0 || JSONReaderWriter.parte_plot_twist_max <= 0){
                System.out.println("No es conveniente que el valor maximo de capacidad de una de las partes de los capitulos en el drive sea <= 0");
                return false;
            }

    //        Verificamos que la cantidad de productores y ensambladores tanto de jose como de andy no sea negativa
            if(JSONReaderWriter.Productor_Intros_andy < 0 || JSONReaderWriter.Productor_Creditos_andy < 0 || JSONReaderWriter.Productor_Inicio_andy < 0 || JSONReaderWriter.Productor_cierre_andy < 0 || JSONReaderWriter.Productor_Plot_Twist_andy < 0 || JSONReaderWriter.Productor_Intros_jose < 0 || JSONReaderWriter.Productor_Creditos_jose < 0 || JSONReaderWriter.Productor_Inicio_jose  < 0 || JSONReaderWriter.Productor_cierre_jose < 0 || JSONReaderWriter.Productor_Plot_Twist_jose < 0 || JSONReaderWriter.Ensamblador_Rodaje_andy < 0 || JSONReaderWriter.Ensamblador_Rodaje_jose < 0){
                System.out.println("No tiene sentido tener un nro de productores y/o ensambladores en negativo");
                return false;
            }

    //        Verificamos que la cantidad de productores de jose no sobrepase el límite impuesto por la cédula de jose
            if (JSONReaderWriter.Productor_Intros_jose + JSONReaderWriter.Productor_Creditos_jose + JSONReaderWriter.Productor_Inicio_jose  + JSONReaderWriter.Productor_cierre_jose + JSONReaderWriter.Productor_Plot_Twist_jose > Proyecto_operativos.ci_jose + 10){
                System.out.println("Cantidad erronea de productores de jose escritos en el JSON");
                return false; 
            }

    //        Verificamos que la cantidad de productores de andy no sobrepase el límite impuesto por la cedula de andy
            if(JSONReaderWriter.Productor_Intros_andy + JSONReaderWriter.Productor_Creditos_andy + JSONReaderWriter.Productor_Inicio_andy  + JSONReaderWriter.Productor_cierre_andy + JSONReaderWriter.Productor_Plot_Twist_andy > Proyecto_operativos.ci_Andy + 10){

                int variable = JSONReaderWriter.Productor_Intros_andy + JSONReaderWriter.Productor_Creditos_andy + JSONReaderWriter.Productor_Inicio_andy  + JSONReaderWriter.Productor_cierre_andy + JSONReaderWriter.Productor_Plot_Twist_andy;
                int var2 = Proyecto_operativos.ci_Andy + 10;
                System.out.println("Cantidad erronea de productores de andy ( " + variable + " > " + var2 + "). ");
                return false;
            }

    //        Verificamos que la cantidad de ingresos  y costos del rodaje no estén escritos en negativo
            if(JSONReaderWriter.Ingresos_Rodaje_andy < 0 || JSONReaderWriter.Ingresos_Rodaje_jose < 0 || JSONReaderWriter.Costos_Rodaje_andy < 0 || JSONReaderWriter.Costos_Rodaje_jose < 0){
                System.out.println("No tiene sentido ni queremos los ingresos y costos con valores < 0");
                return false;
            }

            return true;
            
        }catch(Exception e){
            
            return false;
            
        }
    }
    
    /**
     * Evalua si es entero o no
     * @param string
     * @return true SI ES ENTERO y MAYOR QUE CERO. false SI NO ES ENTERO.
     */
    public static boolean isPositiveNumeric(String string){
        try{
            
            int var = Integer.parseInt(string);

            return var > 0;
            
        }catch(NumberFormatException e){            
            return false;            
        }
    }
    /**
     * Evalua si es un booleano o no
     * @param string
     * @return true SI ES BOOLEANO, false SI NO ES BOOLEANO
     */
    public static boolean isBoolean(String string){
        try{
            
            Boolean.valueOf(string);
            
            return true;
            
        }catch(Exception e){
            
            return false;
            
        }
    }
    
    /**
     * Evalua si se llenó o no la casilla
     * @param string
     * @return true SI ESTÁ VACIO, false SI NO ESTÁ VACIO
     */
    public static boolean isEmpty(String string){
        
        return string.equalsIgnoreCase("");
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
     * @param Ingresos_Rodaje_jose
     * @param Ingresos_Rodaje_andy
     * @param Costos_Rodaje_jose
     * @param Costos_Rodaje_andy
     * @throws FileNotFoundException 
     */
    public void Writer(String dia_en_segundos, String dias_entre_despachos, String parte_intro_max, String Capacidad_infinita1, String parte_creditos_max, String Capacidad_infinita2, String parte_inicio_max, String Capacidad_infinita3, String parte_cierre_max, String Capacidad_infinita4, String parte_plot_twist_max, String Capacidad_infinita5, String Productor_Intros_jose, String Productor_Creditos_jose, String Productor_Inicio_jose, String Productor_cierre_jose, String Productor_Plot_Twist_jose, String Productor_Intros_andy, String Productor_Creditos_andy, String Productor_Inicio_andy, String Productor_cierre_andy, String Productor_Plot_Twist_andy, String Ensamblador_Rodaje_jose, String Ensamblador_Rodaje_andy, String Ingresos_Rodaje_jose, String Ingresos_Rodaje_andy, String Costos_Rodaje_jose, String Costos_Rodaje_andy) throws FileNotFoundException{
        
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
        
//        Ingresos
        
        int Ingresos_Rodaje_jose_int = Integer.parseInt(Ingresos_Rodaje_jose);        
        jo.put("Ingresos_Rodaje_jose", Ingresos_Rodaje_jose_int);
        
        int Ingresos_Rodaje_andy_int = Integer.parseInt(Ingresos_Rodaje_andy);        
        jo.put("Ingresos_Rodaje_andy", Ingresos_Rodaje_andy_int);
        
//        Costos
        int Costos_Rodaje_jose_int = Integer.parseInt(Costos_Rodaje_jose);
        jo.put("Costos_Rodaje_jose", Costos_Rodaje_jose_int);
                 
        int Costos_Rodaje_andy_int = Integer.parseInt(Costos_Rodaje_andy);
        jo.put("Costos_Rodaje_andy", Costos_Rodaje_andy_int);
        
        
        
        try (//        writing JSON to file:"jsonfile.json" in cwd
                PrintWriter pw = new PrintWriter("src\\Archivos\\jsonfile.json")) {
            pw.write(jo.toJSONString());
            
            pw.flush();
        }

    }
         
}
