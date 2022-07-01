/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trabajo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import Trabajo.Figura;

/**
 *
 * @author HP
 */
public class PanelPrincipal extends JPanel implements MouseListener{
    
    private final int CIRCLE = 0;
    private final int STAR = 1;
    private final int SQUARE = 2;
    private final int RECTANGLE = 3;
    private final int TRIANGLE = 4;
    
    private final Figura figura;
    private Color color;
    private int height;
    private int width;
    private Point point;

    public PanelPrincipal(Figura figura) {
        this.figura = figura;
        point = new Point(-200, -200);
        this.addMouseListener(this);
    }
    public Figura getFigura() {
        return figura;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        
        g.setColor(figura.getColor());
        
        switch (figura.getFigura()) {
            case CIRCLE:
                g.fillOval(point.x, point.y, figura.getWidth(),figura.getHeight());
                break;
            case SQUARE:
                g.fillRect(point.x, point.y, figura.getWidth(),figura.getWidth());
                break;
            case RECTANGLE:
                g.fillRect(point.x, point.y, figura.getWidth(),figura.getHeight());
                break;
            case TRIANGLE:
                int[] pointsX = {(point.x - (figura.getWidth()/2)), point.x, (point.x + (figura.getWidth()/2))};
                int[] pointsY = {(point.y + figura.getHeight()),point.y, (point.y + (figura.getHeight()))};
                g.fillPolygon(pointsX, pointsY, 3);
                break;
            case STAR:
             
                int[] pointsX1 = { point.x,point.x - figura.getWidth()/2, point.x, point.x + figura.getWidth()/2};
                int[] pointsY1 = { point.y, point.y + figura.getHeight(), point.y + 2*(figura.getHeight()/3),point.y + figura.getHeight() };
                
                int[] pointsX2 = { point.x - figura.getWidth()/2,point.x,point.x + figura.getWidth()/2};
                int[] pointsY2 = { point.y + figura.getHeight()/3,point.y+ 2*(figura.getHeight()/3),point.y + figura.getHeight()/3 };
                
                g.fillPolygon(pointsX1,pointsY1, 4);
                g.fillPolygon(pointsX2, pointsY2,3);
                
                break;
            default:
                break;
        }  
     
    }
    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        setPoint(e.getPoint());
        System.out.println("evento: "+e.getPoint());
        this.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}