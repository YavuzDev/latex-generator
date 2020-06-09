import com.emrage.latex.LatexDocument;
import com.emrage.latex.section.Section;
import com.emrage.latex.section.SubSection;
import com.emrage.latex.text.Text;

import java.io.IOException;
import java.nio.file.Path;

public class SectionExample {

    public static void main(String[] args) throws IOException {
        var document = new LatexDocument();

        var helper = document.getLatexHelper();
        helper.addTableOfContents();
        helper.addNewPage();

        var section = new Section("Main section");
        var sectionText = new Text();
        sectionText.addln("Main section");
        document.add(section);

        var subSection = new SubSection("Sub section");
        var subSectionText = new Text();
        subSectionText.addln("Sub section");
        document.add(subSection);

        var subSubSection = new SubSection("Sub Sub section");
        var subSubSectionText = new Text();
        subSubSectionText.addln("Sub Sub section");
        document.add(subSubSection);

        document.save(Path.of("test"));
    }
}
