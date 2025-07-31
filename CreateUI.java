import javax.swing.*;
import java.awt.*;
import javax.swing.border.AbstractBorder;
import java.awt.geom.RoundRectangle2D;

public class CreateUI 
{
    /**
     * Initializes the user interface for the application.
     * This method creates a window and adds all necessary UI components to it.
     */
    public static void initUI()
    {
        // Create a window for the application
        JFrame window = new JFrame("My App");
        window.setSize(560, 315);
        window.setAutoRequestFocus(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBackground(Color.LIGHT_GRAY);
        window.setLayout(null);

        // Add the button components
        window.add(CreateUI.createButton("Fix mistakes", "#F5F5F5", "#2C2C2C", 110, 32, 8, 20, 226));
        window.add(CreateUI.createButton("Improve readability", "#F5F5F5", "#2C2C2C", 161, 32, 8, 149, 226));
        window.add(CreateUI.createButton("Write this better", "#F5F5F5", "#2C2C2C", 139, 32, 8, 329, 226));
        window.add(CreateUI.createButton("Save", "#F5F5F5", "#14AE5C", 53, 32, 8, 487, 226));

        // Make all components visible
        window.setVisible(true);
    }

    /**
     * Creates a button with specified text, font color, background color, width, height, corner radius, and position.
     * This method creates a button with the specified properties.
     * 
     * @param text the text to display on the button
     * @param fontColor the color of the font
     * @param backgroundColor the background color of the button
     * @param width the width of the button
     * @param height the height of the button
     * @param cornerRadius the radius of the button's corners
     * @param xPos the x position of the button
     * @param yPos the y position of the button
     * @return A JButton object with the specified properties
     */
    private static JButton createButton(String text, String fontColor, String backgroundColor, int width, int height, int cornerRadius, int xPos, int yPos)
    {
        JButton button = new RoundedButton(text, cornerRadius, Color.decode(backgroundColor));
        button.setBounds(xPos, yPos, width, height);
        button.setForeground(Color.decode(fontColor));
        button.setBorder(new RoundedBorder(cornerRadius, Color.decode(backgroundColor)));
        button.setFocusPainted(false);
        return button;
    }
}

/**
 * A custom JButton that has rounded corners and a specified background color.
 * This class extends JButton to create a button with rounded corners and a custom background color.
 */
class RoundedButton extends JButton {
    private int radius;
    private Color bgColor;

    /**
     * Constructs a RoundedButton with the specified text, corner radius, and background color.
     * 
     * @param text the text to display on the button
     * @param radius the radius of the button's corners
     * @param bgColor the background color of the button
     */
    public RoundedButton(String text, int radius, Color bgColor) {
        super(text);
        this.radius = radius;
        this.bgColor = bgColor;
        setContentAreaFilled(false);
        setOpaque(false);
    }

    /**
     * Paints the button with rounded corners and the specified background color.
     * This method overrides the paintComponent method to draw a rounded rectangle as the button's background.
     * 
     * @param g the Graphics object used for painting
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fill rounded rectangle background
        g2.setColor(this.bgColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), this.radius, this.radius);

        g2.dispose();
        super.paintComponent(g);
    }
}

/**
 * A custom border that creates a rounded rectangle border with a specified radius and color.
 * This class extends AbstractBorder to create a border with rounded corners.
 */
class RoundedBorder extends AbstractBorder 
{
    private int radius;
    private Color borderColor;

    /**
     * Constructs a RoundedBorder with the specified radius and border color.
     * 
     * @param radius the radius of the border's corners
     * @param borderColor the color of the border
     */
    public RoundedBorder(int radius, Color borderColor) {
        this.radius = radius;
        this.borderColor = borderColor;
    }

    /**
     * Paints the border of the component with rounded corners.
     * This method overrides the paintBorder method to draw a rounded rectangle as the border.
     * 
     * @param c the component for which the border is being painted
     * @param g the Graphics object used for painting
     * @param x the x position of the border
     * @param y the y position of the border
     * @param width the width of the border
     * @param height the height of the border
     */
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(this.borderColor);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, this.radius, this.radius));
        g2d.dispose();
    }

    /**
     * Returns the insets of the border, which are equal to the radius on all sides.
     * This method overrides the getBorderInsets method to provide the insets for the border.
     * 
     * @param c the component for which the border insets are being requested
     * @return Insets object representing the insets of the border
     */
    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius, this.radius, this.radius, this.radius);
    }

    /**
     * Returns the insets of the border, which are equal to the radius on all sides.
     * This method overrides the getBorderInsets method to provide the insets for the border.
     * 
     * @param c the component for which the border insets are being requested
     * @param insets an Insets object to be filled with the border insets
     * @return Insets object representing the insets of the border
     */
    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.top = insets.right = insets.bottom = this.radius;
        return insets;
    }
}