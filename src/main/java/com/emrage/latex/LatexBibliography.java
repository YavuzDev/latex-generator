package com.emrage.latex;

import com.emrage.latex.bib.Bibliography;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LatexBibliography {

    private final List<Bibliography> bibliographies;

    private boolean includedInReferences;

    protected LatexBibliography() {
        this.bibliographies = new ArrayList<>();
    }

    public String cite(String citation) {
        return "\\cite{" + citation + "}";
    }

    public String getDeclaration() {
        if (bibliographies.isEmpty()) {
            return "";
        }
        return "\\bibliographystyle{unsrt}\n\\bibliography{bibliography}\n";
    }

    protected void create(Path directory) throws IOException {
        if (bibliographies.isEmpty()) {
            return;
        }

        var output = new ByteArrayOutputStream();
        bibliographies.forEach(b -> output.writeBytes(b.toByteArray()));

        Files.write(directory.resolve("bibliography.bib"), output.toByteArray());
    }

    public void addBibliography(Bibliography bibliography) {
        this.bibliographies.add(bibliography);
    }

    public boolean isIncludedInReferences() {
        return includedInReferences;
    }

    public void setIncludedInReferences(boolean includedInReferences) {
        this.includedInReferences = includedInReferences;
    }
}
