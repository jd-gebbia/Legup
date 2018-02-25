package puzzles.sudoku;

import model.gameboard.GridCell;
import ui.boardview.GridElement;

import java.awt.*;

public class SudokuElement extends GridElement
{
    private static final Font FONT = new Font("TimesRoman", Font.BOLD, 16);
    private static final Color FONT_COLOR = Color.BLACK;
    private static final Color BORDER_COLOR = Color.BLACK;

    public SudokuElement(GridCell cell)
    {
        super(cell);
    }

    /**
     * Draws the sudoku element to the screen
     *
     * @param graphics2D graphics object
     * @param location position on the board
     */
    public void draw(Graphics2D graphics2D, Point location)
    {
        graphics2D.setColor(BORDER_COLOR);
        if(isHover())
        {
            graphics2D.setColor(new Color(63,101,244));
            graphics2D.setStroke(new BasicStroke(3));
            graphics2D.drawRect(location.x * size.width, location.y * size.height, size.width, size.height);
        }
        else
        {
            graphics2D.setStroke(new BasicStroke(1));
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawRect(location.x * size.width, location.y * size.height, size.width, size.height);
        }

        if(data.getValueInt() != 0)
        {
            graphics2D.setColor(FONT_COLOR);
            graphics2D.setFont(FONT);
            FontMetrics metrics = graphics2D.getFontMetrics(FONT);
            String value = String.valueOf(data.getValueInt());
            int xText = (location.x * size.width) + (size.width - metrics.stringWidth(value)) / 2;
            int yText = (location.y * size.width) + ((size.height - metrics.getHeight()) / 2) + metrics.getAscent();
            graphics2D.drawString(String.valueOf(data.getValueInt()), xText, yText);
        }
    }
}
