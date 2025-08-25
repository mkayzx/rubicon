package com.gabriel.draw.view;

import com.gabriel.draw.controller.DrawingWindowController;
import com.gabriel.drawfx.ShapeMode;
import com.gabriel.drawfx.model.Drawing;
import com.gabriel.drawfx.service.AppService;

import javax.swing.*;
import java.awt.*;

public class DrawingFrame extends JFrame {


    public DrawingFrame(AppService appService){
        DrawingWindowController drawingWindowController = new DrawingWindowController(appService);
        this.addWindowListener(drawingWindowController);
        this.addWindowFocusListener(drawingWindowController);
        this.addWindowStateListener(drawingWindowController);

        DrawingView drawingView = new DrawingView(appService);
        this.getContentPane().add(drawingView, BorderLayout.CENTER);

        JToolBar toolBar = new JToolBar();

        JButton lineBtn = new JButton("Line");
        lineBtn.addActionListener(e -> appService.setShapeMode(ShapeMode.Line));

        JButton rectBtn = new JButton("Rectangle");
        rectBtn.addActionListener(e -> appService.setShapeMode(ShapeMode.Rectangle));

        JButton ellipseBtn = new JButton("Ellipse");
        ellipseBtn.addActionListener(e -> appService.setShapeMode(ShapeMode.Ellipse));

        toolBar.add(lineBtn);
        toolBar.add(rectBtn);
        toolBar.add(ellipseBtn);

        this.getContentPane().add(toolBar, BorderLayout.NORTH);
    }
}
