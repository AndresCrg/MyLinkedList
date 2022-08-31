package views;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import constants.Constants;
import presenter.Action;
import presenter.Presenter;

public class PnlHeader extends JPanel{

	private static final long serialVersionUID = 1L;
	private GridSystem gridSystem;
	private JTextField txtInputData;
	private JButton btnAddNode;
	private JButton btnFindSimilar;
	private JButton btnDeleteNode;
	
	public PnlHeader(Presenter presenter) {
		setBackground(Constants.COLOR_BLACK);
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		gridSystem = new GridSystem(this);
		
		txtInputData = new JTextField(5);
		txtInputData.setBorder(BorderFactory.createTitledBorder(null, Constants.INPUT_DATA_TEXT, TitledBorder.LEFT,
				TitledBorder.TOP, Constants.INK_FREE_FONT, Color.BLACK));
		add(txtInputData, gridSystem.insertComponent(1, 1, 1, 1));
		
		btnAddNode = configBtn(Constants.IMG_ADD_NODE, 40, 58, Action.ADD_NODE, presenter);
		add(btnAddNode, gridSystem.insertComponent(1, 3, 1, 1));
		
		btnFindSimilar = configBtn(Constants.IMG_SEARCH_NODE, 80, 58, Action.SEARCH_SIMILAR_NODE, presenter);
		add(btnFindSimilar, gridSystem.insertComponent(1, 6, 1, 1));
		
		btnDeleteNode = configBtn(Constants.IMG_DELETE_NODE, 50, 58, Action.DELETE_NODE, presenter);
		add(btnDeleteNode, gridSystem.insertComponent(1, 9, 1, 1));
	}
	
	public JButton configBtn(String imgPath, int widthBtn, int heightBtn, Action action, Presenter presenter) {
		JButton btn = new JButton(new ImageIcon(createImageIcon(imgPath).getImage()));
		btn.setOpaque(true);
		btn.setFocusable(false);
		btn.setPreferredSize(new Dimension(widthBtn, heightBtn));
		btn.setBorder(Constants.EMPTY_BORDER_BTN_MAIN_MENU);
		btn.setBackground(Constants.COLOR_BLACK);
		btn.setMargin(Constants.INSETS_BTN_MAIN_MENU);
		btn.setActionCommand(action.toString());
		btn.addActionListener(presenter);
		return btn;
	}
	
	public String getTxtDataNode() {
		return txtInputData.getText();
	}
	
	public void cleanTxt() {
		txtInputData.setText("");
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