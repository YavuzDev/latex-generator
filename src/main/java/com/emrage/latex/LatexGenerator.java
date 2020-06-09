package com.emrage.latex;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LatexGenerator {

    private final List<String> text;

    private final LatexBibliography latexBibliography;

    private final List<Path> images;

    protected LatexGenerator(LatexBibliography latexBibliography) {
        this.text = new ArrayList<>();
        this.latexBibliography = latexBibliography;
        this.images = new ArrayList<>();
    }

    public void add(String line) {
        text.add(line);
    }

    public void addln(String line) {
        text.add(line + "\n");
    }

    public void addAll(List<String> lines) {
        text.addAll(lines);
    }

    protected void generate(Path path) throws IOException {
        if (!Files.exists(path)) {
            Files.createDirectory(path);
        }

        var output = new ByteArrayOutputStream();
        initializeStart(output);

        text.forEach(t -> output.writeBytes(t.getBytes()));

        initializeEnd(output);
        Files.write(path.resolve("test.tex"), output.toByteArray());
    }

    protected void initializeStart(ByteArrayOutputStream output) {
        output.writeBytes("\\documentclass{article}\n".getBytes());
        output.writeBytes("\\usepackage[utf8]{inputenc}\n".getBytes());
        if (latexBibliography.isIncludedInReferences()) {
            output.writeBytes("\\usepackage[nottoc]{tocbibind}\n".getBytes());
        }
        if (!images.isEmpty()) {
            output.writeBytes("\\usepackage{graphicx}\n".getBytes());
            output.writeBytes("\\graphicspath{{./images/}}\n".getBytes());
        }
        output.writeBytes("\n\\begin{document}\n".getBytes());
    }

    protected void initializeEnd(ByteArrayOutputStream output) {
        output.writeBytes(latexBibliography.getDeclaration().getBytes());
        output.writeBytes("\\end{document}\n".getBytes());
    }

    public void addImage(Path imagePath) {
        images.add(imagePath);
    }

    protected void saveFiles(Path directory) throws IOException {
        var imagesDirectory = directory.resolve("images");
        if (!Files.exists(imagesDirectory)) {
            Files.createDirectory(imagesDirectory);
        }

        images.forEach(i -> {
            try {
                Files.write(imagesDirectory.resolve(i.getFileName()), Files.readAllBytes(i));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
