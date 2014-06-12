/*
 *  BACA DENGAN TELITI !!!
 * 
 *  Anda boleh menggunakan, mengubah, menghapus, menambah, dan
 *  melakukan hal yang anda inginkan ke dalam source code ini.
 * 
 *  Dan saya tidak bertanggung jawab atas kesalahan,
 *  bug, atau keanehan yang ada dalam source code ini, dan
 *  saya juga TIDAK MENERIMA PERTANYAAN dari Anda
 *  mengenai isi source code ini.
 * 
 *  Semoga source code ini bermanfaat bagi Anda, dan juga
 *  bermanfaat bagi project yang sedang Anda buat.
 * 
 *  Salam saya, Eko Kurniawan Khannedy
 */
package id.aas.apps.mvc.usuDesign;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author echo
 */
public class PanelImage extends JPanel {

    private Image image;

    public PanelImage() {
        image = new ImageIcon(getClass().getResource("/kumpulanswingmakeover/image.jpg")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D gd = (Graphics2D) g.create();

        gd.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        gd.dispose();
    }
}
