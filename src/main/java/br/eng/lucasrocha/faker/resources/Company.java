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
public class Company {

	private final String base = "company.";
	
	private Integer resourceNameSize;
	
	/**
	 * 
	 */
	public Company() {
		ApplicationContext.getInstance(Faker.getInstance().getLocale());
		this.resourceNameSize = loadResource("name").size();
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
	public List<String> suffixes(){
		return loadResource("suffix");
	}
	
	/**
	 * @param quantity
	 * @return
	 */
	public List<String> suffixes(Integer quantity) {
		return ListUtils.randomSubList(loadResource("suffix"), quantity);
	}

	/**
	 * @return
	 */
	public String suffix() {
		return suffixes(1).get(0);
	}
	
	/**
	 * @return
	 */
	public String companyName() {
		String templateCompanyName = loadResource("name").get(new Random().nextInt(this.resourceNameSize));
		templateCompanyName = templateCompanyName.replaceFirst("\\#\\{suffix\\}", suffix());
		while (templateCompanyName.contains("#{Name.last_name}")) {
			templateCompanyName = templateCompanyName.replaceFirst("\\#\\{Name\\.last_name\\}", Faker.name.lastName());
		}
		return templateCompanyName;
	}
	
	/**
	 * @param quantity
	 * @return
	 */
	public List<String> companyNames(Integer quantity){
		List<String> companyNames = new ArrayList<String>();
		for (int i = 0; i < quantity; i++) {
			companyNames.add(companyName());
		}
		return companyNames;
	}
	
	/**
	 * @return
	 */
	public List<String> companyNames(){
		Integer quantity = new Random().nextInt();
		return companyNames(quantity);
	}
}
