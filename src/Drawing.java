import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Drawing extends JFrame
{
    private JPanel panel;
    private Color color = Color.BLACK;
    private Color bgColor = Color.WHITE;
    private int thickness = 5;

    public Drawing()
    {
        panel = new JPanel()
        {
            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.setColor(bgColor);
                g.fillRect(0,0,getWidth(),getHeight());
            }
        };
        panel.addMouseMotionListener(new MouseAdapter()
        {
            public void mouseDragged(MouseEvent e)
            {
                Graphics g = panel.getGraphics();
                g.setColor(color);
                g.fillOval(e.getX() - thickness / 2, e.getY() - thickness / 2, thickness, thickness);
            }
        });
        add(panel);

        JMenuBar mb = new JMenuBar();
        JMenu colorMenu = new JMenu("Цвет");

        JMenuItem blackItem = new JMenuItem("Чёрный");
        blackItem.addActionListener(e -> color = Color.BLACK);
        colorMenu.add(blackItem);

        JMenuItem redItem = new JMenuItem("Красный");
        redItem.addActionListener(e -> color = Color.RED);
        colorMenu.add(redItem);

        mb.add(colorMenu);

        JMenu thicknessMenu = new JMenu("Толщина");

        JMenuItem thin = new JMenuItem("Тонкая");
        thin.addActionListener(e -> thickness = 5);
        thicknessMenu.add(thin);

        JMenuItem thick = new JMenuItem("Толстая");
        thick.addActionListener(e -> thickness = 10);
        thicknessMenu.add(thick);

        mb.add(thicknessMenu);
        setJMenuBar(mb);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Drawing();
    }
}
