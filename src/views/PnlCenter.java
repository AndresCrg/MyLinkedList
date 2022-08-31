package views;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import constants.Constants;
import models.Node;

public class PnlCenter extends JPanel{

	private static final long serialVersionUID = 1L;
	
	
	public PnlCenter() {
	}
	
	public void paintList(Node head) {
		Graphics2D graphics2d = (Graphics2D) getGraphics();
		paintNodes(head, graphics2d);
		paintArrow(graphics2d);
		paintTitleHead(graphics2d);
	}
	
	private void paintNodes(Node head, Graphics2D graphics2d) {
		Node current = head;
		int posX = getWidth()/2;
		int posY = Constants.POINT_50;
		while(current != null) {
			graphics2d.setColor(Constants.COLOR_NODE_YELLOW);
			graphics2d.fillOval(posX, posY, Constants.SIZE_OVAL, Constants.SIZE_OVAL);
			graphics2d.setColor(Color.BLACK);
			graphics2d.drawString(current.getData(), posX + (Constants.SIZE_OVAL/4), posY + (Constants.SIZE_OVAL/2) + 5);
			current = current.getNext();
			posY = posY + Constants.INCREASE_120;
			System.out.println(posY);
		}
	}
	
	public void paintArrow(Graphics2D graphics2d) {
		graphics2d.drawLine((getWidth() / 2) - (Constants.POINT_110 + 40), Constants.POINT_110, (getWidth() / 2) - Constants.POINT_50, Constants.POINT_110);
		graphics2d.drawLine((getWidth() / 2) - Constants.POINT_50, Constants.POINT_110,(getWidth() / 2) - (Constants.POINT_50 + 10), Constants.POINT_110 - 5);
		graphics2d.drawLine((getWidth() / 2) - Constants.POINT_50, Constants.POINT_110,(getWidth() / 2) - (Constants.POINT_50 + 10), Constants.POINT_110 + 5);
	}
	
	public void paintTitleHead(Graphics2D graphics2d) {
		graphics2d.setFont(Constants.INK_FREE_FONT);
		graphics2d.drawString(Constants.HEAD_TEXT, (getWidth() / 2) - (Constants.POINT_110 *2 ),Constants.POINT_110);
	}
}