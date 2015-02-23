package actionListener;

import humanMachineInterface.JListLabelCards;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pokedeck.Card;
import pokedeck.Pokedeck;

/*
 * Listener which open a Form for adding a card
 */

public class WindowsAddCardListener implements ActionListener {
	private  JFrame window_AddCard;
	private  JPanel panel_AddCard;
	private ArrayList<Card> cards_list;
	private Pokedeck pokedeck;
	private JListLabelCards labels_cards;


	public WindowsAddCardListener(Pokedeck pokedeck, ArrayList<Card> cards_list, JListLabelCards labels_cards ) {
		this.cards_list = cards_list;
		this.pokedeck=pokedeck;
		this.labels_cards = labels_cards;
		window_AddCard = new JFrame (" Adding a Card ");
		panel_AddCard = new JPanel ( new FlowLayout ());
		window_AddCard.add ( panel_AddCard);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		window_AddCard.setSize (700, 125);
		window_AddCard.setVisible ( true );
		initialize();

	}
	public void initialize(){
		JLabel name_lb = new JLabel("Name ");
		JTextField name_tf = new JTextField(7);
		panel_AddCard.add ( name_lb);
		panel_AddCard.add ( name_tf);

		JLabel collector_num_lb = new JLabel("Collector number ");
		JTextField  collector_num_tf= new JTextField(7);
		panel_AddCard.add (collector_num_lb);
		panel_AddCard.add (collector_num_tf);

		/*	JLabel type_lb = new JLabel("Type ");
        JTextField  type_tf= new JTextField(7);
		panel_AddCard.add (type_lb);
		panel_AddCard.add (type_tf);*/

		JLabel desc_lb = new JLabel("Description");
		JTextField  desc_tf= new JTextField(7);
		panel_AddCard.add (desc_lb);
		panel_AddCard.add (desc_tf);

		JButton valid_btn = new JButton ("Add this PokemonCard");
		valid_btn.addActionListener(new AddCardListener(pokedeck, labels_cards, name_tf, collector_num_tf, desc_tf));	
		panel_AddCard.add(valid_btn);
		panel_AddCard.repaint();
	}

}
