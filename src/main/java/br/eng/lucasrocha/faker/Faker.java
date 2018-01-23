/**
 * 
 */
package br.eng.lucasrocha.faker;

import br.eng.lucasrocha.faker.resources.Address;
import br.eng.lucasrocha.faker.resources.Company;
import br.eng.lucasrocha.faker.resources.Internet;
import br.eng.lucasrocha.faker.resources.Lorem;
import br.eng.lucasrocha.faker.resources.Name;
import br.eng.lucasrocha.faker.resources.Phone;
import br.eng.lucasrocha.faker.utils.Locale;
import br.eng.lucasrocha.faker.utils.Mock;

/**
 * @author Lucas Rocha <lucas.diegorr@gmail.com>
 *
 */
public class Faker {

	private String locale;

	public static Lorem lorem = new Lorem();
	
	public static Name name = new Name();
	
	public static Address address = new Address();
	
	public static Company company = new Company();
	
	public static Internet internet = new Internet();
	
	public static Phone phone = new Phone();
	
	public static Mock mock = new Mock();
	
	private static Faker instance; 
	
	public Faker(String locale) {
		this.setLocale(locale);
	}
	
	/**
	 * @return
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * Return a default instance
	 * @return
	 */
	public static Faker getInstance() {
		return getInstance(Locale.PT_BR);
	}
	
	/**
	 * Return a default instance
	 * @return
	 */
	public static Faker getInstance(String locale) {
		if (instance == null) {
			instance = new Faker(locale);
			return instance;
		}else {
			return instance;
		}
	}
	
	/**
	 * @param locale the locale to set
	 */
	private void setLocale(String locale) {
		this.locale = locale;
	}
}
