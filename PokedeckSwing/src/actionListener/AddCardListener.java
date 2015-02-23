package actionListener;

import humanMachineInterface.JListLabelCards;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JTextField;

import checkingParameter.CheckInput;
import pokedeck.Card;
import pokedeck.Pokedeck;
import pokedeck.PokemonCard;
/*
 * Listener for adding a card to pokedeck
 */

public class AddCardListener implements ActionListener {
	private Pokedeck pokedeck;
	private JListLabelCards labels_cards;
	private JButton valid_btn = new JButton ("Add this Card");
	private JTextField card_nametf;
	private JTextField collector_numbertf;
	//private JTextField card_typetf;
	private JTextField descriptiontf;


	AddCardListener(Pokedeck pokedeck,JListLabelCards labels_cards,JTextField card_nametf,JTextField collector_numbertf, JTextField descriptiontf) {
		this.pokedeck=pokedeck;
		this.labels_cards=labels_cards;
		this.card_nametf= card_nametf;
		this.collector_numbertf=collector_numbertf;
		//this.card_typetf=card_typetf;
		this.descriptiontf=descriptiontf;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()!=valid_btn){
			if(!CheckInput.checkIsEmpty(card_nametf.getText()) || CheckInput.checkIsInteger(collector_numbertf.getText())){
				//add the card in pokedeck
				pokedeck.addAndCreateCard("pokemon", card_nametf.getText(), Integer.parseInt(collector_numbertf.getText()), "fire", "", 100);
				pokedeck.addCardDescription(card_nametf.getText(), descriptiontf.getText());
			}



		}
	}

}
