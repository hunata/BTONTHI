import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class App {
    private static final String ALPHABET = "alphabet.dat";
    private static final String LINE_BREAKE= "\n";

    public static void main(String[] args) {
        List<String> alphabets = readFile(ALPHABET);
        Collections.sort(alphabets);
        writeFile(alphabets,"alphabet.dat" );
        Collections.sort(alphabets, Collections.reverseOrder());
        writeFile(alphabets, "alphabet-descending.dat");
    }

    private static void writeFile(List<String> data, String fileName ){
        try{
            File file = new File(fileName);
            if(!file.exists()){
                File fp = file .getParentFile().getCanonicalFile();
                if (fp !=null){
                    fp.mkdirs();
                }
                file.createNewFile();
            }

            try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
                for (String val: data){
                    bw.write(val);
                    bw.write(LINE_BREAKE);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static List<String> readFile(String fileName) {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    result.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return result;
    }

}
