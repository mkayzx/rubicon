package com.gabriel.draw.service;

import com.gabriel.draw.model.Ellipse;
import com.gabriel.drawfx.service.RendererService;
import com.gabriel.drawfx.model.Shape;
import java.awt.*;


public class EllipseRendererService implements RendererService{

    @Override
    public void render(Graphics g, Shape shape, boolean xor) {
        Point start = shape.getLocation();
        Point end = shape.getEnd();

        int x = Math.min(start.x, end.x);
        int y = Math.min(start.y, end.y);
        int width = Math.abs(end.x - start.x);
        int height = Math.abs(end.y - start.y);

        if (xor) {
            g.setXORMode(shape.getColor());
        } else {
            g.setColor(shape.getColor());
        }

        g.drawOval(x, y, width, height);

        if (xor) {
            g.setPaintMode();
        }
    }
}
