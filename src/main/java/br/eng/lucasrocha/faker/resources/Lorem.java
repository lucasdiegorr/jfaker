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

	/**
	 * 
	 */
	public Lorem() {
		ApplicationContext.getInstance(Faker.getInstance().getLocale());
	}
	
	private List<String> loadResource(String resource){
		return LoadResource.load( this.base + resource);
	}
	
	public String paragraphs() {
		Integer quantity = new Random().nextInt(10);
		return paragraphs(quantity);
	}
	
	public String paragraphs(Integer quantity) {
		StringBuilder paragraphsStringBuiler = new StringBuilder();
		for (int index = 0; index < quantity; index++) {
			paragraphsStringBuiler.append(paragraph() + "\n");
		}
		return paragraphsStringBuiler.toString();
	}
	
	public String paragraph() {
		List<String> listWords = words();
		StringBuilder stringBuilderParagraph = new StringBuilder();
		Integer numberWords = new Random().nextInt(listWords.size());
		for (int index = 0; index < numberWords; index++) {
			stringBuilderParagraph.append(" " + listWords.get(new Random().nextInt(listWords.size())));
		}
		return stringBuilderParagraph.append(".").toString();
	}
	
	public List<String> words(){
		return loadResource("words");
	}
	
	public List<String> words(Integer quantity) {
		return ListUtils.randomSubList(words(), quantity);
	}
}
