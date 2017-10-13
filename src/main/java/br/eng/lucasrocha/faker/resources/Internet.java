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
public class Internet {
	
	private final String base = "internet.";
	
	/**
	 * 
	 */
	public Internet() {
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
	 * @return
	 */
	public List<String> freeEmailSuffixes(){
		return loadResource("free_email");
	}
	
	/**
	 * @param quantity
	 * @return
	 */
	public List<String> freeEmailSuffixes(Integer quantity) {
		return ListUtils.randomSubList(freeEmailSuffixes(), quantity);
	}

	/**
	 * @return
	 */
	public String freeEmailSuffix() {
		return freeEmailSuffixes(1).get(0);
	}

	public String email() {
		Integer quantity = new Random().nextInt(20);
		return Faker.lorem.lettersLowerCase(quantity > 0 ? quantity : 1) + "@" + freeEmailSuffix();
	}
	
	public List<String> emails(Integer quantity){
		List<String> listEmails = new ArrayList<String>();
		for (int index = 0; index < quantity; index++) {
			listEmails.add(email());
		}
		return listEmails;
	}
	
	public List<String> emails(){
		Integer quantity = new Random().nextInt();
		return emails(quantity > 0 ? quantity : 1);
	}
	
	/**
	 * @return
	 */
	public List<String> domainSuffixes(){
		return loadResource("domain_suffix");
	}
	
	/**
	 * @param quantity
	 * @return
	 */
	public List<String> domainSuffixes(Integer quantity) {
		return ListUtils.randomSubList(domainSuffixes(), quantity);
	}

	/**
	 * @return
	 */
	public String domainSuffix() {
		return domainSuffixes(1).get(0);
	}
	
	public String domain() {
		Integer quantity = new Random().nextInt(20);
		return Faker.lorem.lettersLowerCase(quantity > 0 ? quantity : 1) + "." + domainSuffix();
	}
	
	public List<String> domains(Integer quantity){
		List<String> listDomains = new ArrayList<String>();
		for (int index = 0; index < quantity; index++) {
			listDomains.add(domain());
		}
		return listDomains;
	}
	
	public List<String> domains(){
		Integer quantity = new Random().nextInt();
		return domains(quantity > 0 ? quantity : 1);
	}
	
}
