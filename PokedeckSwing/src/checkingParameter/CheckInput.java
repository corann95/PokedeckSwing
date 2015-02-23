package checkingParameter;
/*
 * Class for checking input or parameter
 * 
 */
public class CheckInput {

	public CheckInput() {

	}
	/*
	 * return true if the string is empty: null, or containing just space(s) charactere
	 */
	public static boolean checkIsEmpty(String string){

		if(string == null || "".equals(string.replaceAll("[\\s\\u00A0]+$", "")) ){
			System.err.println("A string is empty, Fill the fields!");
			return true;
		}
		return false;
	}
	/*
	 * return true if the string is a number
	 */

	public static boolean checkIsInteger(String string){
		try {
			int number = Integer.parseInt(string);
			return true;
		} catch (NumberFormatException number_e) {
			System.err.println("A parameter is not a integer, Fill the fields" );

		}
		return false;
	}

}
