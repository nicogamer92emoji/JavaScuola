import java.io.*;

public class FileCartellaFinder {
    public static void main(String[] args) throws IOException {
        String percorso;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Inserisci il percorso: ");
            percorso = in.readLine();
        }

        File file;
        FileReader fr;
        BufferedReader fin;
        
        try {
            file = new File(percorso);
            fr = new FileReader(file);
            fin = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato: " + e.getMessage());
            return;
        }
        
        if (file.isDirectory()) {
            System.out.println("Il percorso è una cartella.");
            try {
                String[] files = file.list();
                try (FileWriter fw = new FileWriter("Eleco Files")) {
                    if (files != null) {
                        for (String fileName : files) {
                            fw.write(fileName + "\n");
                        }
                    } else {
                        System.out.println("La cartella è vuota.");
                    }
                }
            } catch (IOException e) {
                System.out.println("Errore durante la scrittura del file: " + e.getMessage());
            }
        }
        else if (file.isFile()) {
            System.out.println("Il percorso è un file.");
            String line;
            while ((line = fin.readLine()) != null) {
                System.out.println(line);
            }
        }
        else 
            System.out.println("Il percorso non esiste.");

        fin.close();
        fr.close();
    }
}
