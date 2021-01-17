package utility;

import  java.io.*;
import javax.sound.sampled.*;

/* Classe qui permet de jouer le son 
 * 
 * Sous classe de Thread car se joue en même temps que le jeu
 * et est nécessaire pour arrêter / lancer le son
 * */ 
 
public class Audio extends Thread{  
     
    private String son;
    AudioInputStream audioInputStream = null;
    SourceDataLine line;
    public Audio(String son)
    {
    	this.son=son;
    }
    public void run(){							// On redefinit run de la classe de thread
        File fichier = new File(son);
        try {
        AudioFileFormat format = AudioSystem.getAudioFileFormat(fichier);
        } catch (UnsupportedAudioFileException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
         
        try {
            audioInputStream = AudioSystem.getAudioInputStream(fichier);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
         
         AudioFormat audioFormat = audioInputStream.getFormat();
         DataLine.Info info = new DataLine.Info(SourceDataLine.class,audioFormat);
          
         try {
             line = (SourceDataLine) AudioSystem.getLine(info);
                        
             } catch (LineUnavailableException e) {
               e.printStackTrace();
               return;
             }
          
        try {
                line.open(audioFormat);
        } catch (LineUnavailableException e) {
                    e.printStackTrace();
                    return;
        }
        line.start();
        
        try {
            byte bytes[] = new byte[1024];
            int bytesRead=0;
            while ((bytesRead = audioInputStream.read(bytes, 0, bytes.length)) != -1) {
                 line.write(bytes, 0, bytesRead);
                }
        } catch (IOException io) {
            io.printStackTrace();
            return;
        }
    }
}