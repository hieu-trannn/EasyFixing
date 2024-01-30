/**
 * @author delini
 */

package swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;


public class PasswordText extends JPasswordField {

    /**
     * @return the borderFocus
     */
    public Color getBorderFocus() {
        return borderFocus;
    }

    /**
     * @param borderFocus the borderFocus to set
     */
    public void setBorderFocus(Color borderFocus) {
        this.borderFocus = borderFocus;
    }

    /**
     * @return the borderOff
     */
    public Color getBorderOff() {
        return borderOff;
    }
    
    /**
     * @return the iconGap
     */
    public int getIconGap() {
        return iconGap;
    }

    /**
     * @param iconGap the iconGap to set
     */
    public void setIconGap(int iconGap) {
        this.iconGap = iconGap;
    }

    /**
     * @param borderOff the borderOff to set
     */
    public void setBorderOff(Color borderOff) {
        this.borderOff = borderOff;
    }
    public Icon getPrefixIcon() {
        return prefixIcon;
    }

    public void setPrefixIcon(Icon prefixIcon) {
        this.prefixIcon = prefixIcon;
        initBorder();
    }

    public Icon getSuffixIcon() {
        return suffixIcon;
    }

    public void setSuffixIcon(Icon suffixIcon) {
        this.suffixIcon = suffixIcon;
        initBorder();
    }

    private Icon prefixIcon;
    private Icon suffixIcon;
    private Color borderFocus = new Color(43, 150, 148);
    private Color borderOff = new Color(164, 171, 171);
    private int iconGap = 7;
    
    public PasswordText() {
        setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 5, 7, 5));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintIcon(g);

        //  Border colour
        if (isFocusOwner()) {
            g.setColor(getBorderFocus());
            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
            g.drawRect(1, 1, getWidth() - 3, getHeight() - 3);
        } else {
            g.setColor(getBorderOff());
            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
            g.drawRect(1, 1, getWidth() - 3, getHeight() - 3);
        }
    }

    private void paintIcon(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (prefixIcon != null) {
            Image prefix = ((ImageIcon) prefixIcon).getImage();
            int y = (getHeight() - prefixIcon.getIconHeight()) / 2;
            g2.drawImage(prefix, getIconGap(), y, this);
        }
        if (suffixIcon != null) {
            Image suffix = ((ImageIcon) suffixIcon).getImage();
            int y = (getHeight() - suffixIcon.getIconHeight()) / 2;
            g2.drawImage(suffix, getWidth() - suffixIcon.getIconWidth() - getIconGap(), y, this);
        }
    }

    private void initBorder() {
        int left = 5;
        int right = 5;
        //  5 is default
        if (prefixIcon != null) {
            //  prefix is left
            left = prefixIcon.getIconWidth() + getIconGap() + 5;
        }
        if (suffixIcon != null) {
            //  suffix is right
            right = suffixIcon.getIconWidth() + getIconGap() +  5;
        }
        setBorder(javax.swing.BorderFactory.createEmptyBorder(7, left, 7, right));
    }

}
