/**
 * 
 */
package br.eng.lucasrocha.faker.resources;

import java.util.List;
import java.util.Random;

import br.eng.lucasrocha.faker.Faker;
import br.eng.lucasrocha.faker.utils.ApplicationContext;
import br.eng.lucasrocha.faker.utils.ListUtils;
import br.eng.lucasrocha.faker.utils.LoadResource;

/**
 * @author Lucas Rocha <lucas.diegorr@gmail.com>
 *
 */
public class Lorem {
	
	private final String base = "lorem.";

	private final String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private final String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
	
	private final String numeric = "0123456789";
	
	/**
	 * 
	 */
	public Lorem() {
		ApplicationContext.getInstance(Faker.getInstance().getLocale());
	}
	
	/**
	 * @param resource - Name of resource for search in file
	 * @return - List with the request resource
	 */
	private List<String> loadResource(String resource){
		return LoadResource.load( this.base + resource);
	}
	
	/**
	 * @return - A text with a size between 0 and 10 paragraphs
	 */
	public String paragraphs() {
		Integer quantity = new Random().nextInt(10);
		return paragraphs(quantity);
	}
	
	/**
	 * @param quantity - Quantity of paragraphs
	 * @return - A text with number of paragrahps request
	 */
	public String paragraphs(Integer quantity) {
		StringBuilder paragraphsStringBuiler = new StringBuilder();
		for (int index = 0; index < quantity; index++) {
			paragraphsStringBuiler.append(paragraph() + "\n");
		}
		return paragraphsStringBuiler.toString();
	}
	
	/**
	 * @return - A text with one paragrahp
	 */
	public String paragraph() {
		List<String> listWords = words();
		StringBuilder stringBuilderParagraph = new StringBuilder();
		Integer numberWords = new Random().nextInt(listWords.size());
		for (int index = 0; index < numberWords; index++) {
			stringBuilderParagraph.append(" " + listWords.get(new Random().nextInt(listWords.size())));
		}
		return stringBuilderParagraph.append(".").toString();
	}
	
	/**
	 * @return - A random word
	 */
	public String word() {
		return words(1).get(0);
	}
	
	/**
	 * @return - Random words
	 */
	public List<String> words(){
		return loadResource("words");
	}
	
	/**
	 * @param quantity - Number of request words
	 * @return - A list with random words with the requested quantity.
	 */
	public List<String> words(Integer quantity) {
		return ListUtils.randomSubList(words(), quantity);
	}
	
	/**
	 * @return - A letter
	 */
	public char letter() {
		return (this.upperAlphabet+this.lowerAlphabet).charAt(new Random().nextInt(52));
	}
	
	/**
	 * @param quantity - Number of letter request
	 * @return - A word of quantity letter request
	 */
	public String letters(Integer quantity) {
		String result = "";
		for (int index = 0; index < quantity; index++) {
			result += letter();
		}
		return result;
	}
	
	/**
	 * @return - A letter in upper case
	 */
	public char letterUpperCase() {
		return this.upperAlphabet.charAt(new Random().nextInt(26));
	}
	
	/**
	 * @param quantity - Number of letter request
	 * @return - A word of quantity letter request
	 */
	public String lettersUpperCase(Integer quantity) {
		String result = "";
		for (int index = 0; index < quantity; index++) {
			result += letterUpperCase();
		}
		return result;
	}
	
	/**
	 * @return - A letter in lower case
	 */
	public char letterLowerCase() {
		return this.lowerAlphabet.charAt(new Random().nextInt(26));
	}
	
	/**
	 * @param quantity - Number of letter request
	 * @return - A word of quantity letter request
	 */
	public String lettersLowerCase(Integer quantity) {
		String result = "";
		for (int index = 0; index < quantity; index++) {
			result += letterLowerCase();
		}
		return result;
	}
	
	/**
	 * @return - A numeric
	 */
	public char numeric() {
		return this.numeric.charAt(new Random().nextInt(10));
	}
	
	/**
	 * @param quantity - Number of numerics request
	 * @return - A word of quantity numerics request
	 */
	public String numerics(Integer quantity) {
		String result = "";
		for (int index = 0; index < quantity; index++) {
			result += numeric();
		}
		return result;
	}
	
	/**
	 * @return -  A alphanumeric
	 */
	public char alphaNumeric() {
		return (this.upperAlphabet+this.lowerAlphabet+this.numeric).charAt(new Random().nextInt(62));
	}
	
	/**
	 * @param quantity - Number of alphanumerics request
	 * @return - A word of quantity alphanumerics request
	 */
	public String alphaNumerics(Integer quantity) {
		String result = "";
		for (int index = 0; index < quantity; index++) {
			result += alphaNumeric();
		}
		return result;
	}
}
