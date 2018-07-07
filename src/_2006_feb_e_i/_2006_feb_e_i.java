/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2006_feb_e_i;
import java.io.*;
/**
 *
 * @author Dávid
 */
public class _2006_feb_e_i {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            RandomAccessFile raf=new RandomAccessFile("HIVASOK.txt", "r");
            String sor;
            int db=0;
            while((sor=raf.readLine())!=null){
                db++;
            }
            db=db/2;
            String[][] t=new String[db][9];
            db=0;
            raf.seek(0);
            while((sor=raf.readLine())!=null){
                String[] sz=sor.split(" ");
                //System.out.println(sor);
                int i=0;
                for (String string : sz) {
                    t[db][i++]=string;
                }
                double perc=(double)(Integer.parseInt(sz[3])*60*60+Integer.parseInt(sz[4])*60+Integer.parseInt(sz[5]))-(double)(Integer.parseInt(sz[0])*60*60+Integer.parseInt(sz[1])*60+Integer.parseInt(sz[2]));
                String telo=raf.readLine();
                t[db][i++]=telo;
                System.out.println(" "+telo.substring(0, 2));
                double perc_dij=(int)perc/60;
                System.out.println(perc/60+" "+perc_dij);
                if(perc/60==perc_dij){
                    perc_dij=(int)perc/60;
                }else{
                    perc_dij=(int)(perc/60)+1;
                }
                System.out.println(perc/60+" "+perc_dij);
                if(telo.substring(0, 2).equals("39") || telo.substring(0, 2).equals("40") ||telo.substring(0, 2).equals("71") ){
                    if(Integer.parseInt(sz[0])<=7 && Integer.parseInt(sz[1])==0 && Integer.parseInt(sz[3])>=18 && Integer.parseInt(sz[4])==0 ){
                        t[db][i++]=perc_dij*69.175+"";
                    }else{
                         t[db][i++]=perc_dij*46.675+"";
                    }
                }else{
                    if(Integer.parseInt(sz[0])<=7 && Integer.parseInt(sz[1])==0 && Integer.parseInt(sz[3])>=18 && Integer.parseInt(sz[4])==0 ){
                        t[db][i++]=perc_dij*30+"";
                    }else{
                         t[db][i++]=perc_dij*15+"";
                    }
                }
                t[db][i++]=perc/60+"";
                db++;
                //sor=raf.readLine();
            }
            raf.close();
            
            for (String[] strings : t) {
                for (String string : strings) {
                    System.out.print(string+" ");
                }
                System.out.println("");
            }
        } catch (Exception e) {
            System.err.println("hiba");
        }
    }
    
}
