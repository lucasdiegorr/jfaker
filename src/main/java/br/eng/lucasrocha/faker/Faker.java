/**
 * 
 */
package br.eng.lucasrocha.faker;

import br.eng.lucasrocha.faker.resources.Address;
import br.eng.lucasrocha.faker.resources.Lorem;
import br.eng.lucasrocha.faker.resources.Name;
import br.eng.lucasrocha.faker.utils.Locale;

/**
 * @author Lucas Rocha <lucas.diegorr@gmail.com>
 *
 */
public class Faker {

	private String locale;

	public static Lorem lorem = new Lorem();
	
	public static Name name = new Name();
	
	public static Address address = new Address();
	
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

	public static void main(String[] args) {
		
//		System.out.println(Faker.address.fullAddress());
//		System.out.println(Faker.address.cityName());
//		System.out.println(Faker.address.state());
		
		System.out.println(Faker.address.defaultCountry());
	}
	
}
