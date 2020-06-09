import com.emrage.latex.LatexDocument;
import com.emrage.latex.figure.Figure;

import java.io.IOException;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        var document = new LatexDocument();

        document.save(Path.of("test"));
    }
}
