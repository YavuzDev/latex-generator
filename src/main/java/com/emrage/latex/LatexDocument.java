package com.emrage.latex;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LatexDocument {

    private final List<LatexNode> nodes;

    private final LatexHelper latexHelper;

    private final LatexBibliography latexBibliography;

    public LatexDocument() {
        this.nodes = new ArrayList<>();
        this.latexHelper = new LatexHelper(nodes);
        this.latexBibliography = new LatexBibliography();
    }

    public void save(Path directory) throws IOException {
        var generator = new LatexGenerator(latexBibliography);
        nodes.forEach(n -> n.write(generator));
        generator.generate(directory);
        generator.saveFiles(directory);

        latexBibliography.create(directory);
    }

    public void add(LatexNode node) {
        nodes.add(node);
    }

    public LatexHelper getLatexHelper() {
        return latexHelper;
    }

    public LatexBibliography getLatexBibliography(boolean includedInReferences) {
        latexBibliography.setIncludedInReferences(includedInReferences);
        return latexBibliography;
    }

    public LatexBibliography getLatexBibliography() {
        return latexBibliography;
    }
}
