import com.emrage.latex.LatexDocument;
import com.emrage.latex.text.Flush;
import com.emrage.latex.text.Paragraph;
import com.emrage.latex.text.Text;

import java.io.IOException;
import java.nio.file.Path;

public class TextExample {

    public static void main(String[] args) throws IOException {
        var document = new LatexDocument();
        var helper = document.getLatexHelper();

        var text = new Text();
        text.addln("This is a text");
        text.addln(helper.bold("This is a bold text"));
        text.addln(helper.italic("This is an italic text"));
        text.addln(helper.underline("This is an underline text"));
        text.addln("Escaping character " + helper.escape('~'));
        document.add(text);

        var paragraph = new Paragraph();
        paragraph.setFlush(Flush.RIGHT);
        paragraph.addln("This is a paragraph");
        document.add(paragraph);

        document.save(Path.of("test"));
    }
}
