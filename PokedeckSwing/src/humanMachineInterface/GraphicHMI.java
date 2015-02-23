package humanMachineInterface;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import actionListener.NextCardListener;
import actionListener.WindowsAddCardListener;
import pokedeck.Card;
import pokedeck.Pokedeck;
/*
 * Human Machine Interface (or GUI)
 */
public  class GraphicHMI {
	public static Pokedeck pokedeck;
	private static JFrame window;
	private static JPanel flow_panel;
	private static GridBagConstraints grid;
	private static JListLabelCards labels_cards;


	public GraphicHMI() {
		pokedeck = new Pokedeck();
		flow_panel = new JPanel ( new FlowLayout ());
		flow_panel.setLayout(new GridBagLayout());
		grid = new GridBagConstraints();
		grid.weightx=6; //grid weight: number of cases 
		grid.weighty=6;
		grid.anchor=GridBagConstraints.WEST; //constraint position
		grid.insets = new Insets(10, 10, 10, 10); // margin, new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite)
		labels_cards = new JListLabelCards(pokedeck.collectionList());

	}
	/*
	 * initialize the Frame
	 */

	public static void launchWindows(){
		window = new JFrame (" Pokedeck ");
		window.setSize (1000, 700);
		window.add ( flow_panel );
		window.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
		window.setVisible ( true );
	}
	/*
	 * paint and launch the graphic interface with buttons
	 */

	public void createInterface() {

		addMenuButtonInterface();
		launchWindows();
	}		
	/*
	 * adding menu's buttons to panel
	 */
	public  void addMenuButtonInterface(){
		gridBagConstraintsXY(0, 0);
		JButton button_add = new JButton (" Add a Card ");
		button_add.addActionListener ( new WindowsAddCardListener(pokedeck, pokedeck.collectionList(), labels_cards));
		flow_panel.add(button_add ,grid);
		gridBagConstraintsXY(0, 1);
		flow_panel.add( new JButton ("-----" ),grid);
		gridBagConstraintsXY(0, 2);
		flow_panel.add( new JButton ("-----" ),grid);
		gridBagConstraintsXY(1, 3);
		flow_panel.add( new JButton ("-----" ),grid);

		JButton button_next = new JButton (" Next ");
		button_next.addActionListener ( new NextCardListener(flow_panel,pokedeck.collectionList(), labels_cards));
		gridBagConstraintsXY(2, 3);
		flow_panel.add(button_next ,grid);

	}

	/*
	 * return a GridBagConstraints object with gridx and gridy setted by parameters
	 */
	public static void gridBagConstraintsXY(int gridx, int gridy){	
		grid.gridx = gridx;
		grid.gridy = gridy;
	}
	/*
	 * paint a card with its informations
	 */

	public void showACard(int index){
		ArrayList<Card> cards_list = pokedeck.collectionList();
		Card card = cards_list.get(index);
		Font font = new Font("Arial",Font.BOLD,14);
		JLabel label = new JLabel(card.toString());
		JLabel labelImage = createImage(card.getImagePath());
		label.setFont(font);
		label.setOpaque(true);
		label.setBackground(Color.white);
		gridBagConstraintsXY(1, 2);
		flow_panel.add(label, grid);
		gridBagConstraintsXY(1, 1);
		flow_panel.add(labelImage, grid);
		refreshWindows();
	}

	public  void refreshWindows(){
		flow_panel.revalidate();
		flow_panel.repaint();
	}

	public static JLabel createImage(String imagePath){
		ImageIcon image= new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(210, 300, Image.SCALE_DEFAULT));
		JLabel card_pic = new JLabel (image);
		return card_pic;
	}
	/*
	 * execute and show a card and the list of card
	 */

	public void executeCardHMI(int indexCard){
		showListCards(indexCard);
		showACard(indexCard);

		refreshWindows();
	}

	public void executeHMI(){
		// first card begin with index 0
		executeCardHMI(labels_cards.index_card);
	}
	/*
	 * create and show Jlist of card ( list of String, card's name) 
	 */
	public void showListCards(int indexCurrentCard){
		gridBagConstraintsXY(2, 1);
		flow_panel.add(labels_cards.getJListCardLabels(), grid);
		labels_cards.getJListCardLabels().setSelectedIndex(indexCurrentCard); //overline current card

	}

	public GraphicHMI getHMIObject(){
		return this;
	}

	public static void main(String[] args){
		GraphicHMI pokedeckHMI = new GraphicHMI();
		pokedeckHMI.createInterface();
		pokedeckHMI.executeHMI();
	}


}