package com.emrage.latex.bib;

import java.io.ByteArrayOutputStream;
import java.util.Map;

public class Bibliography {

    private BibliographyType bibliographyType;

    private String reference;

    private String author;

    private String title;

    public Bibliography setBibliographyType(BibliographyType bibliographyType) {
        this.bibliographyType = bibliographyType;
        return this;
    }

    public Bibliography setReference(String reference) {
        this.reference = reference;
        return this;
    }

    public Bibliography setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Bibliography setTitle(String title) {
        this.title = title;
        return this;
    }

    public byte[] toByteArray() {
        var output = new ByteArrayOutputStream();
        output.writeBytes(("@" + bibliographyType.name().toLowerCase() + "{" + reference + ",\n").getBytes());

        var values = Map.of(
                "author", author,
                "title", title
        );

        values.forEach((key, value) -> {
            if (!value.isBlank()) {
                output.writeBytes(("\t" + key + " = \t \"" + value + "\",\n").getBytes());
            }
        });

        output.writeBytes("}\n".getBytes());
        return output.toByteArray();
    }
}
