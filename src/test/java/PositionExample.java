import com.emrage.latex.LatexDocument;
import com.emrage.latex.position.Center;
import com.emrage.latex.position.Left;
import com.emrage.latex.position.Right;
import com.emrage.latex.text.Text;

import java.io.IOException;
import java.nio.file.Path;

public class PositionExample {

    public static void main(String[] args) throws IOException {
        var document = new LatexDocument();

        var center = new Center();
        var textCenter = new Text();
        textCenter.addln("Centered");
        center.add(textCenter);

        var right = new Right();
        var textRight = new Text();
        textRight.addln("Right");
        right.add(textRight);

        var left = new Left();
        var textLeft = new Text();
        textLeft.addln("Left");
        left.add(textLeft);

        document.add(center);
        document.add(right);
        document.add(left);

        document.save(Path.of("test"));
    }
}
