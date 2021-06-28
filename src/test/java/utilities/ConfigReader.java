package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //Config reader tek gorev testimdan cardimda gidip deerleri alip getirir, araklass, tercumen

    //1. bi tane Properties objesi olusturalim

    static private Properties properties;  //Obje olusturduk  , bu obje configuration.properties clasini okuyacak
    //properties i static yapip clas ismi ile carmak
    //Bu objenin projenin heryerinden clas ismiyle carmak icin static yapth
    // bu obj e class disindan mudale olmamasi ici private yapiyoruz

    static{  //static blok hersyden once calisir, mainden bile once. icersinde dosya okutucam , dosya okumak icin javadan FileInputStream
        String path="src/configuration.properties";
        try {
            FileInputStream fileInputStream= new FileInputStream(path); //patini yazmaliyim, neyi okucaksa
            properties=new Properties();

            // Yapilan tek islem bu; Bu class calistinda static blok calisacak ve 1 tek islem yapacak
            //File inpstream objesi  calisacak ve okudugi  Bilgileri propertise objesine  yukleyecek
            //path olarak configuration.properties gidecek
            properties.load(fileInputStream); //Yapilan tek islem hersey poperties obj ustunde yuklendi

            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //simdi properties e  yuklenen bilgiden specific olanini cekicem
    //bi metod olcak, ben key yollucam o bana value gondercek
    public static String  getProperty(String key){

        String value= properties.getProperty(key);
        return value;
    }
}
//Test datasini conf.properties yaparak dynamik yaparim
