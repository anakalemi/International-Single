package algorithms.utils;

import algorithms.JukeboxData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author : Ana Kalemi
 **/
public class FileReaderUtils {

    private final String TEST_FILE_03 = "src/algorithms/resources/input03.txt";
    private final String TEST_FILE_04 = "src/algorithms/resources/input04.txt";
    private final String TEST_FILE_05 = "src/algorithms/resources/input05.txt";

    public FileReaderUtils() {
        getAndProcessFileDataInAGraph();
    }

    public void getAndProcessFileDataInAGraph() {
        File file = new File(TEST_FILE_05);
        try {
            Scanner scanner = new Scanner(file).useDelimiter("\\s+");
            processFileData(scanner);
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void processFileData(Scanner scanner) {
        try {
            processFirstLine(scanner);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        initializeGraph();

        while (scanner.hasNext() && getJukeboxData().getNumberOfLines() > 0) {
            getJukeboxData().allArtistsGraph.addEdge(scanner.nextInt(), scanner.nextInt());
            getJukeboxData().setNumberOfLines(getJukeboxData().getNumberOfLines() - 1);
        }
    }

    private void processFirstLine(Scanner scanner) throws RuntimeException {
        if (scanner.hasNextLine()) {
            int n = scanner.nextInt();
            int p = scanner.nextInt();

            if ((n >= 1 && n <= Math.pow(10, 5)) && (p >= 1 && p <= Math.pow(10, 4))) {
                getJukeboxData().setNumberOfArtists(n);
                getJukeboxData().setNumberOfLines(p);
            } else {
                throw new RuntimeException("The first line of input is out of range!");
            }
        }
    }

    private void initializeGraph() {
        for (int i = 0; i < getJukeboxData().getNumberOfArtists(); i++) {
            getJukeboxData().allArtistsGraph.addEdge(i, i);
        }
    }

    public JukeboxData getJukeboxData() {
        return JukeboxData.getInstance();
    }
}