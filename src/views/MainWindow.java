package views;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import constants.Constants;
import models.Node;
import presenter.Presenter;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private PnlHeader pnlHeader;
	private PnlCenterWithBuffer pnlCenter;
	
	public MainWindow(Presenter presenter) {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(createImageIcon(Constants.ICON_APP).getImage());
		setTitle(Constants.LINKED_LIST_TITLE);
		
		pnlHeader = new PnlHeader(presenter);
		add(pnlHeader, BorderLayout.PAGE_START);
		
		pnlCenter = new PnlCenterWithBuffer();
		add(pnlCenter, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public String getTxtDataNode() {
		return pnlHeader.getTxtDataNode();
	}
	
	public void cleanTxt() {
		pnlHeader.cleanTxt();
	}
	
	public void paintList(Node head) {
		pnlCenter.paintList(head);
	}
	
	public void init() {
		pnlCenter.init();
	}
	
	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}