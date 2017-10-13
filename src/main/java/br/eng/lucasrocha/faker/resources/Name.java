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
	
	private final Integer quantityLastNames = 5;
	
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
	
	public List<String> firstNames(Integer quantity){
		return ListUtils.randomSubList(firstNames(), quantity);
	}
	
	public String firstName() {
		return firstNames(1).get(0);
	}
	
	public List<String> lastNames() {
		return loadResource("last_name");
	}
	
	public List<String> lastNames(Integer quantity) {
		return ListUtils.randomSubList(lastNames(), quantity);
	}
	
	public String lastName() {
		return lastNames(1).get(0);
	}
	
	public List<String> simpleNames() {
		Integer quantity = new Random().nextInt();
		return simpleNames(quantity);
	}

	/**
	 * @param quantity
	 * @return
	 */
	public List<String> simpleNames(Integer quantity) {
		List<String> fullNames = new ArrayList<String>();
		
		for (int index = 0; index < quantity; index++) {
			StringBuilder fullNameStringBuilder = new StringBuilder();
			fullNameStringBuilder.append(firstName());
			List<String> lastNames = lastNames(new Random().nextInt(this.quantityLastNames));
			for (String lastName : lastNames) {
				fullNameStringBuilder.append(" " + lastName);
			}
			fullNames.add(fullNameStringBuilder.toString());
		}
		return fullNames;
	}

	public String simpleName() {
		return simpleNames(1).get(0);
	}
	
	public List<String> prefixes(){
		return loadResource("prefix");
	}
	
	public List<String> prefixes(Integer quantity){
		return ListUtils.randomSubList(prefixes(), quantity);
	}
	
	public String prefix() {
		return prefixes(1).get(0);
	}
	
	public List<String> suffixes(){
		return loadResource("suffix");
	}
	
	public List<String> suffixes(Integer quantity){
		return ListUtils.randomSubList(suffixes(), quantity);
	}
	
	public String suffix() {
		return suffixes(1).get(0);
	}
	
	public String simpleNameWithPrefix() {
		return prefix() + " " + simpleName();
	}
	
	public List<String> simpleNamesWithPrefix(Integer quantity){
		List<String> simpleNamesWithPrefix = new ArrayList<String>();
		for (int index = 0; index < quantity; index++) {
			simpleNamesWithPrefix.add(simpleNameWithPrefix());
		}
		return simpleNamesWithPrefix;
	}
	
	public List<String> simpleNamesWithPrefix() {
		Integer quantity = new Random().nextInt();
		return simpleNamesWithPrefix(quantity);
	}
	
	public String simpleNameWithSuffix() {
		return simpleName() + " " + suffix();
	}
	
	public List<String> simpleNameWithSuffixes(Integer quantity){
		List<String> simpleNamesWithSuffix = new ArrayList<String>();
		for (int index = 0; index < quantity; index++) {
			simpleNamesWithSuffix.add(simpleNameWithSuffix());
		}
		return simpleNamesWithSuffix;
	}
	
	public List<String> simpleNameWithSuffixes() {
		Integer quantity = new Random().nextInt();
		return simpleNameWithSuffixes(quantity);
	}
	
	public String simpleNameWithPrefixAndSuffix() {
		return prefix() + " " + simpleName() + " " + suffix();
	}
	
	public List<String> simpleNamePrefixAndSuffixes(Integer quantity){
		List<String> fullNamesWithSuffix = new ArrayList<String>();
		for (int index = 0; index < quantity; index++) {
			fullNamesWithSuffix.add(simpleNameWithPrefixAndSuffix());
		}
		return fullNamesWithSuffix;
	}
	
	public List<String> fullNameWithPrefixAndSuffixes() {
		Integer quantity = new Random().nextInt();
		return simpleNameWithSuffixes(quantity);
	}
	
	public String fullName() {
		Integer random = new Random().nextInt(4);
		if (random == 0) {
			return simpleName();
		} else if(random == 1) {
			return simpleNameWithPrefix();
		} else if(random == 2) {
			return simpleNameWithSuffix();
		} else {
			return simpleNameWithPrefixAndSuffix();
		}
	}
	
	public List<String> fullNames(Integer quantity){
		List<String> fullNames = new ArrayList<String>();
		for (int index = 0; index < quantity; index++) {
			fullNames.add(fullName());
		}
		return fullNames;
	}
	
	public List<String> fullNames(){
		Integer quantity = new Random().nextInt();
		return fullNames(quantity > 0 ? quantity : 1);
	}
}
