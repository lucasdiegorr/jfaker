/**
 * 
 */
package br.eng.lucasrocha.faker.resources;

import java.util.ArrayList;
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
public class Name {

	private final String base = "name."; 
	
	private final Integer quantityLastNames = 10;
	
	/**
	 * 
	 */
	public Name() {
		ApplicationContext.getInstance(Faker.getInstance().getLocale());
	}
	
	private List<String> loadResource(String resource){
		return LoadResource.load( this.base + resource);
	}
	
	public List<String> firstNames(){
		return loadResource("first_name");
	}
	
	public String firstName() {
		List<String> firstNames = firstNames();
		return firstNames.get(new Random().nextInt(firstNames.size()));
	}
	
	public List<String> lastNames() {
		return loadResource("last_name");
	}
	
	public List<String> lastNames(Integer quantity) {
		return ListUtils.randomSubList(lastNames(), quantity);
	}
	
	public String lastName() {
		List<String> lastNames = lastNames();
		return lastNames.get(new Random().nextInt(lastNames.size()));
	}
	
	public List<String> fullNames() {
		Integer quantity = new Random().nextInt();
		return fullNames(quantity);
	}

	/**
	 * @param quantity
	 * @return
	 */
	public List<String> fullNames(Integer quantity) {
		ArrayList<String> fullNames = new ArrayList<String>();
		
		for (int index = 0; index < quantity; index++) {
			StringBuilder fullNameStringBuilder = new StringBuilder();
			fullNameStringBuilder.append(firstName());
			List<String> lastNames = lastNames(new Random().nextInt(quantityLastNames));
			for (String lastName : lastNames) {
				fullNameStringBuilder.append(" " + lastName);
			}
			fullNames.add(fullNameStringBuilder.toString());
		}
		return fullNames;
	}

	public String fullName() {
		return fullNames(1).get(0);
	}
	
}
