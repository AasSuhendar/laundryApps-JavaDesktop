package id.aas.apps.mvc.usuDesign;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author echo
 */
public class PanelAlpha extends JPanel {

    private Color warna;

    public PanelAlpha() {
        setOpaque(false);
        warna = new Color(getBackground().getRed(), getBackground().getGreen(), getBackground().getBlue(), 127);
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);

        warna = new Color(getBackground().getRed(), getBackground().getGreen(), getBackground().getBlue(), 127);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D gd = (Graphics2D) g.create();

        gd.setColor(warna);
        gd.fillRect(0, 0, getWidth(), getHeight());

        gd.dispose();
    }
}
