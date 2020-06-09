package com.emrage.latex.image;

import com.emrage.latex.LatexGenerator;
import com.emrage.latex.LatexNode;

import java.nio.file.Path;
import java.util.Map;

public class Image extends LatexNode {

    private final Path imagePath;

    public Image(Path imagePath) {
        this.imagePath = imagePath;
    }

    private double scale;

    private int width;

    private int height;

    private int angle;

    @Override
    public void write(LatexGenerator generator) {
        generator.addImage(imagePath);
        var attributes = new StringBuilder();
        var values = Map.of(
                "scale", scale,
                "width", width,
                "height", height,
                "angle", angle
        );
        attributes.append("[");
        values.forEach((key, value) -> {
            if (value.doubleValue() != 0) {
                attributes.append(key).append("=").append(value).append(" ");
            }
        });
        attributes.append("]");
        var fileName = imagePath.getFileName().toString();
        generator.addln("\\includegraphics" + attributes + "{" + fileName.substring(0, fileName.lastIndexOf('.')) + "}");
    }

    public Image setScale(double scale) {
        this.scale = scale;
        return this;
    }

    public Image setWidth(int width) {
        this.width = width;
        return this;
    }

    public Image setHeight(int height) {
        this.height = height;
        return this;
    }

    public Image setAngle(int angle) {
        this.angle = angle;
        return this;
    }
}
