import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface BoardReader {
    List<List<Character>> boardRead(File fileName) throws FileNotFoundException;
}