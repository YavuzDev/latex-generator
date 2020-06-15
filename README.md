Java Library used for generating .tex and .bib files.

#  Example

```java
        var document = new LatexDocument();

        var bibliography = document.getLatexBibliography();
        bibliography.addBibliography(new Bibliography()
                .setBibliographyType(BibliographyType.ARTICLE)
                .setReference("test")
                .setAuthor("Test")
                .setTitle("Test title"));

        var paragraph = new Paragraph();
        paragraph.setFlush(Flush.LEFT);
        paragraph.addln("This is a paragraph " + bibliography.cite("test"));
        document.add(paragraph);

        document.save(Path.of("test"));
```

More examples can be found in the src/test directory.
