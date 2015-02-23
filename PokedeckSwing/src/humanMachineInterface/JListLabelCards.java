package humanMachineInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

import pokedeck.Card;

public class JListLabelCards 
{
	private JList list_card_labels;
	public int index_card = 0;

	public JListLabelCards(ArrayList<Card> cards_list) {
		initializeMap(cards_list);
		index_card = 0; // begin with 0,index of first card

	}
	public void initializeMap(ArrayList<Card> cards_list){	 
		DefaultListModel model = new DefaultListModel();
		for(Card card: cards_list)
		{	
			model.addElement( card.getCardName());
			list_card_labels = new JList (model);
		}
	}

	public JList getJListCardLabels(){
		return list_card_labels;
	}
	
	public void addCard(Card card){
		DefaultListModel model = new DefaultListModel();
		model.addElement( card.getCardName());
		list_card_labels = new JList (model);
	}


}
