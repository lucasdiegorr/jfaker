/**
 * 
 */
package br.eng.lucasrocha.faker;

import br.eng.lucasrocha.faker.resources.Lorem;
import br.eng.lucasrocha.faker.utils.Locale;

/**
 * @author Lucas Rocha <lucas.diegorr@gmail.com>
 *
 */
public class Faker {

	private String locale;

	public static Lorem lorem = new Lorem();
	
	private static Faker instance; 
	
	/**
	 * 
	 */
	public Faker() {
		this.setLocale(Locale.ptBR);
	}
	
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
		if (instance == null) {
			instance = new Faker();
			return instance;
		}else {
			return instance;
		}
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
