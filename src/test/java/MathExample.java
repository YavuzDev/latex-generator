import com.emrage.latex.LatexDocument;
import com.emrage.latex.math.DisplayMathExpression;
import com.emrage.latex.math.InlineMathExpression;

import java.io.IOException;
import java.nio.file.Path;

public class MathExample {

    public static void main(String[] args) throws IOException {
        var document = new LatexDocument();

        var displayMath = new DisplayMathExpression();
        displayMath.addCharacter('x');
        displayMath.addPowerOf('n');
        displayMath.addText(" + ");
        displayMath.addCharacter('y');
        displayMath.addPowerOf('n');
        displayMath.addText(" = ");
        displayMath.addCharacter('z');
        displayMath.addPowerOf('n');
        document.add(displayMath);


        var inlineMath = new InlineMathExpression();
        displayMath.addCharacter('x');
        displayMath.addPowerOf('n');
        displayMath.addText(" + ");
        displayMath.addCharacter('y');
        displayMath.addPowerOf('n');
        displayMath.addText(" = ");
        displayMath.addCharacter('z');
        displayMath.addPowerOf('n');
        document.add(inlineMath);

        document.save(Path.of("test"));
    }
}
