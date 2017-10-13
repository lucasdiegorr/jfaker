/**
 * 
 */
package br.eng.lucasrocha.faker.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.eng.lucasrocha.faker.Faker;
import br.eng.lucasrocha.faker.utils.ApplicationContext;
import br.eng.lucasrocha.faker.utils.LoadResource;

/**
 * @author Lucas Rocha <lucas.diegorr@gmail.com>
 *
 */
public class Phone {

private final String base = "phone_number.";
	
	private Integer resourceFormatsSize;
	
	/**
	 * 
	 */
	public Phone() {
		ApplicationContext.getInstance(Faker.getInstance().getLocale());
		this.resourceFormatsSize = loadResource("formats").size();
	}
	
	/**
	 * @param resource - Name of resource for search in file
	 * @return - List with the request resource
	 */
	private List<String> loadResource(String resource){
		return LoadResource.load( this.base + resource);
	}
	
	
	/**
	 * @return
	 */
	public List<String> phones(){
		Integer quantity = new Random().nextInt();
		return phones(quantity);
	}
	
	/**
	 * @param quantity
	 * @return
	 */
	public List<String> phones(Integer quantity) {
		List<String> listPhones = new ArrayList<String>();
		for (int index = 0; index < quantity; index++) {
			listPhones.add(phone());
		}
		return listPhones;
	}

	/**
	 * @return
	 */
	public String phone() {
		String templatePhoneNumber = loadResource("formats").get(new Random().nextInt(this.resourceFormatsSize));
		while (templatePhoneNumber.contains("#")) {
			templatePhoneNumber = templatePhoneNumber.replaceFirst("#", Integer.toString(new Random().nextInt(10)));
		}
		return templatePhoneNumber;
	}
}
