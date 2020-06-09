package com.emrage.latex;

import com.emrage.latex.helper.Break;
import com.emrage.latex.helper.NewLine;
import com.emrage.latex.helper.NewPage;
import com.emrage.latex.section.TableOfContents;
import com.emrage.latex.text.Flush;
import com.emrage.latex.text.Text;

import java.util.List;
import java.util.Map;

public class LatexHelper {

    private final List<LatexNode> nodes;

    public LatexHelper(List<LatexNode> nodes) {
        this.nodes = nodes;
    }

    public void addTableOfContents() {
        this.nodes.add(new TableOfContents());
    }

    public void addNewPage() {
        this.nodes.add(new NewPage());
    }

    public void addNewLine() {
        this.nodes.add(new NewLine());
    }

    public void addBreak() {
        this.nodes.add(new Break());
    }

    public void addFlushLeft() {
        var text = new Text();
        text.setFlush(Flush.LEFT);
        this.nodes.add(text);
    }

    public void addFlushRight() {
        var text = new Text();
        text.setFlush(Flush.RIGHT);
        this.nodes.add(text);
    }

    public void addCentering() {
        var text = new Text();
        text.setFlush(Flush.CENTER);
        this.nodes.add(text);
    }

    public String italic(String text) {
        return "\\emph{" + text + "}";
    }

    public String bold(String text) {
        return "\\textbf{" + text + "}";
    }

    public String underline(String text) {
        return "\\underline{" + text + "}";
    }

    public String escape(char toEscape) {
        var map = Map.of(
                '#', "\\#",
                '$', "\\$",
                '%', "\\%",
                '&', "\\&",
                '\\', "\\textbackslash{}",
                '^', "\\textasciicircum{}",
                '_', "\\_",
                '{', "\\{",
                '}', "\\}",
                '~', "\\textasciitilde{}"
        );
        return String.valueOf(map.getOrDefault(toEscape, String.valueOf(toEscape)));
    }
}
