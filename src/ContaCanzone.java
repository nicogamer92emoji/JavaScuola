import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ContaCanzone {
    public static void main(String[] args) {
        System.out.println("I will survive di Gloria Gaynor\n");
        try {
            File file = new File("IWillSurvive.txt");
            if (!file.exists())
                file.createNewFile();
            
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("""
                            At first I was afraid, I was petrified\r
                            Kept thinkin' I could never live without you by my side\r
                            But then I spent so many nights thinkin' how you did me wrong\r
                            And I grew strong and I learned how to get along\r
                            \r
                            And so you're back, from outer space\r
                            I just walked in to find you here with that sad look upon your face\r
                            I should have changed that stupid lock\r
                            I should have made you leave your key\r
                            If I'd have known for just one second you'd be back to bother me\r
                            \r
                            Go on now, go, walk out the door\r
                            Just turn around now, 'cause you're not welcome anymore\r
                            Weren't you the one who tried to hurt me with goodbye?\r
                            Did you think I'd crumble? Did you think I'd lay down and die?\r
                            \r
                            Oh no, not I, I will survive\r
                            Oh, as long as I know how to love, I know I'll stay alive\r
                            I've got all my life to live, and I've got all my love to give\r
                            And I'll survive, I will survive, hey hey\r
                            \r
                            See Gloria Gaynor Live\r
                            Get tickets as low as $78\r
                            \r
                            It took all the strength I had not to fall apart\r
                            Just tryin' hard to mend the pieces of my broken heart\r
                            And I spent oh so many nights just feeling sorry for myself\r
                            I used to cry, but now I hold my head up high\r
                            And you see me, somebody new\r
                            I'm not that chained up little person still in love with you\r
                            And so you felt like droppin' in and just expect me to be free\r
                            Now I'm saving all my lovin' for someone who's lovin' me\r
                            \r
                            Go on now, go, walk out the door\r
                            Just turn around now, 'cause you're not welcome anymore\r
                            Weren't you the one who tried to break me with goodbye?\r
                            Did you think I'd crumble? Did you think I'd lay down and die?\r
                            \r
                            Oh no, not I, I will survive\r
                            Oh, as long as I know how to love, I know I'll stay alive\r
                            I've got all my life to live, and I've got all my love to give\r
                            And I'll survive, I will survive, oh\r
                            \r
                            Go on now go, walk out the door\r
                            Just turn around now, 'cause you're not welcome anymore\r
                            Weren't you the one who tried to break me with goodbye?\r
                            Did you think I'd crumble? Did you think I'd lay down and die?\r
                            """
                );
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                int caratteri = 0;
                int parole = 0;
                do {
                    line = reader.readLine();
                    
                    if (line != null) {
                        String[] paroleLine = line.split(" ");
                        for (String parola: paroleLine) {
                            if (parola.length() > 0) {
                                parole++;
                            }
                        }
                    }
                    if (line != null) {
                        caratteri += line.length();
                    }
                } while (line != null);

                reader.close();
                
                System.out.println("Caratteri totali nel testo: " + caratteri);
                System.out.println("Parole totali del testo: " + parole);

                File copiaFile = new File("IWillSurviveCopia.txt" + parole + ".txt");
                
                try (FileWriter writer = new FileWriter(copiaFile); BufferedReader originalReader = new BufferedReader(new FileReader(file))) {
                    String originalLine;
                    while ((originalLine = originalReader.readLine()) != null) {
                        writer.write(originalLine + System.lineSeparator());
                    }
                }

                if (file.delete())
                    System.out.println("File originale eliminato");
                else
                    System.out.println("File originale non eliminato");

                if (!copiaFile.exists()) 
                    copiaFile.createNewFile();
            }
        } catch(IOException e) {
            System.out.println("File non trovato");
        }
    }
}
