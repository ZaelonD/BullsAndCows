import java.io.*;

public class WriteFile {
    private final File file;
    private final PrintWriter pw;
    private final FileWriter fw;

    public WriteFile() {
        file = new File("logger.txt");
        try {
            fw = new FileWriter(file, true);
            pw = new PrintWriter(fw);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeMessageToFile(String message) {
        try {
            pw.write(message + "\n");
            pw.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public File getFile() {
        return file;
    }

    public void close() {
        pw.close();
        try {
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
