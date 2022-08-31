package views;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;
import constants.Constants;
import models.Node;

public class PnlCenterWithBuffer extends Canvas{

	private static final long serialVersionUID = 1L;
	private BufferStrategy bufferStrategy;
	
	public PnlCenterWithBuffer() {
		setBackground(Constants.COLOR_WHITE_LIGHT);
	}
	
	public void init() {
		createBufferStrategy(2);
		bufferStrategy = getBufferStrategy();
		setIgnoreRepaint(true);
	}
	
	public void paintList(Node head) {
		Graphics2D backgroundGraphics = (Graphics2D) bufferStrategy.getDrawGraphics();
		backgroundGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		backgroundGraphics.setRenderingHint( RenderingHints.  KEY_STROKE_CONTROL,
				RenderingHints.VALUE_STROKE_PURE);
		try {
			paintNodes(head, backgroundGraphics);
			paintArrow(backgroundGraphics);
			paintTitleHead(backgroundGraphics);
		} finally {
			backgroundGraphics.dispose();
		}
		bufferStrategy.show();
	}
	
	private void paintNodes(Node head, Graphics2D graphics2d) {
		Node current = head;
		int posY = Constants.POINT_50;
		while(current != null) {
			graphics2d.setColor(Constants.COLOR_NODE_YELLOW);
			graphics2d.fillOval(getWidth()/2, posY, Constants.SIZE_OVAL, Constants.SIZE_OVAL);
			graphics2d.setColor(Color.BLACK);
			paintData(graphics2d, current, posY);
			current = current.getNext();
			posY = posY + Constants.INCREASE_120;
			System.out.println(posY);
		}
	}
	
	private void paintArrow(Graphics2D graphics2d) {
		graphics2d.drawLine((getWidth() / 2) - (Constants.POINT_110 + 40), Constants.POINT_110, (getWidth() / 2) - Constants.POINT_50, Constants.POINT_110);
		graphics2d.drawLine((getWidth() / 2) - Constants.POINT_50, Constants.POINT_110,(getWidth() / 2) - (Constants.POINT_50 + 10), Constants.POINT_110 - 5);
		graphics2d.drawLine((getWidth() / 2) - Constants.POINT_50, Constants.POINT_110,(getWidth() / 2) - (Constants.POINT_50 + 10), Constants.POINT_110 + 5);
	}
	
	private void paintTitleHead(Graphics2D graphics2d) {
		graphics2d.setFont(Constants.INK_FREE_FONT);
		graphics2d.drawString(Constants.HEAD_TEXT, (getWidth() / 2) - (Constants.POINT_110 *2 ),Constants.POINT_110);
	}
	
	private void paintData(Graphics2D graphics2d, Node current, int posY) {
		graphics2d.setFont(Constants.FONT_CALIBRI_18);
		graphics2d.drawString(current.getData(), (getWidth() / 2) + (Constants.SIZE_OVAL/3), posY + (Constants.SIZE_OVAL/2) + 5);
	}
}