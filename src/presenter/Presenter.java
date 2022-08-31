package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import exceptions.NodeNotFoundException;
import models.MyLinkedList;
import models.Node;
import views.MainWindow;

public class Presenter implements ActionListener, KeyListener{
	private MyLinkedList myLinkedList;
	private MainWindow mainWindow;
	
	public Presenter() {
		myLinkedList = new MyLinkedList();
		mainWindow = new MainWindow(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Action.valueOf(e.getActionCommand())) {
		case ADD_NODE:
			addNode();
			break;
		case SEARCH_SIMILAR_NODE:
			searchSimilarNode();
			break;
		case DELETE_NODE:
			deleteNode();
			break;
		default:
			break;
		}
		
	}

	private void addNode() {
		Node node = myLinkedList.createNode(mainWindow.getTxtDataNode());
		myLinkedList.addNode(node);
		mainWindow.cleanTxt();
		mainWindow.init();
		mainWindow.paintList(myLinkedList.getHead());
	}

	private void searchSimilarNode() {
		JOptionPane.showMessageDialog(null, "El numero de coincidencias es: " + myLinkedList.findIdentical(mainWindow.getTxtDataNode()), "Number Of Matches", JOptionPane.INFORMATION_MESSAGE);
		mainWindow.cleanTxt();
	}
	
	private void deleteNode() {
		try {
			myLinkedList.deleteNode(mainWindow.getTxtDataNode());
			mainWindow.cleanTxt();
			mainWindow.init();
			mainWindow.paintList(myLinkedList.getHead());
		} catch (NodeNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			addNode();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}