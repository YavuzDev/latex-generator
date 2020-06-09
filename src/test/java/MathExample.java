import com.emrage.latex.LatexDocument;
import com.emrage.latex.math.DisplayMathExpression;
import com.emrage.latex.math.InlineMathExpression;
import com.emrage.latex.math.SquareRootExpression;

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

        var squareRootExpression = new SquareRootExpression();
        squareRootExpression.addText("5 + 5");
        displayMath.addSquareRoot(squareRootExpression);

        document.add(displayMath);

        var inlineMath = new InlineMathExpression();
        inlineMath.addCharacter('x');
        inlineMath.addPowerOf('n');
        inlineMath.addText(" + ");
        inlineMath.addCharacter('y');
        inlineMath.addPowerOf('n');
        inlineMath.addText(" = ");
        inlineMath.addCharacter('z');
        inlineMath.addPowerOf('n');
        document.add(inlineMath);

        document.save(Path.of("test"));
    }
}
