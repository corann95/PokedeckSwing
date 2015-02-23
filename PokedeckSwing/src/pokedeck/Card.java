package pokedeck;

import java.io.Serializable;


public abstract class Card implements Serializable{
	String card_name;
	protected String card_type;
	public String description;
	protected int collector_card_number;
	private String image_path;
	
	public Card (String card_name, String card_type,
			int collector_card_number ){
		
			this.card_name=card_name;
			this.card_type=card_type;
			this.collector_card_number=collector_card_number;
			this.image_path="images/imageTestDefault.jpg"; // default image for test
	}
	public String getCardName(){
		return card_name;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public void setImagePath(String path){
		this.image_path = path;
	}
	public String getImagePath(){
		return image_path;	
	}
	public abstract String toString();

}