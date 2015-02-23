package actionListener;

import humanMachineInterface.JListLabelCards;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pokedeck.Card;
import pokedeck.Pokedeck;
/*
 * Listener for show the image of the next card and overline its name in Jlist
 */

public class NextCardListener implements ActionListener {
	private JPanel panel;
	private JListLabelCards labels_cards;
	private ArrayList<Card> cards_list;
	public NextCardListener(JPanel panel,ArrayList<Card> cards_list , JListLabelCards labels_cards) {
		this.panel = panel;
		this.labels_cards = labels_cards;
		this.cards_list = cards_list;
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(cards_list.size()==labels_cards.index_card+1){
			labels_cards.index_card=-1;

		}
		showNextCard(labels_cards.index_card);
		showListCards(labels_cards.index_card);

	}

	public void showNextCard(int indexCurrentCard) {
		Card card = cards_list.get(indexCurrentCard+1);
		Font font = new Font("Arial",Font.BOLD,14);
		JLabel label = new JLabel(card.toString());
		JLabel labelImage = createImage(card.getImagePath());
		label.setFont(font);
		label.setOpaque(true);
		label.setBackground(Color.white);
		panel.remove(7);


		GridBagConstraints grid = new GridBagConstraints();
		grid.gridx = 1;
		grid.gridy = 1;
		panel.add(labelImage, grid);

		panel.remove(6);

		grid.gridx = 1;
		grid.gridy = 2;
		panel.add(label, grid);
		panel.revalidate();
		panel.repaint();
		labels_cards.index_card++;

	}
	public void showListCards(int indexCurrentCard){


		labels_cards.getJListCardLabels().setSelectedIndex(indexCurrentCard); //overline current card


	}
	public static JLabel createImage(String imagePath){
		ImageIcon image= new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(210, 300, Image.SCALE_DEFAULT));
		JLabel card_pic = new JLabel (image);
		return card_pic;
	}

}
