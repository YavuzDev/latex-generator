import com.emrage.latex.LatexDocument;
import com.emrage.latex.figure.Figure;
import com.emrage.latex.figure.FigureType;
import com.emrage.latex.image.Image;

import java.io.IOException;
import java.nio.file.Path;

public class FigureExample {

    public static void main(String[] args) throws IOException {
        var document = new LatexDocument();

        var image = new Image(Path.of("cat.png"))
                .setWidth(5)
                .setHeight(5);

        var figure = new Figure(FigureType.HERE);
        figure.add(image);

        document.add(figure);

        document.save(Path.of("test"));
    }
}
