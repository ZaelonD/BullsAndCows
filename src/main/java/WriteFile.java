import java.io.*;

public class WriteFile {
    private final String PATHNAME = "logger.txt";
    private final File file;

    public WriteFile() {
        file = new File(PATHNAME);
    }

    public void writeMessageToFile(String message) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(file, true));
            pw.write(message + "\n");
            pw.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getPATHNAME() {
        return PATHNAME;
    }

    public File getFile() {
        return file;
    }
}
