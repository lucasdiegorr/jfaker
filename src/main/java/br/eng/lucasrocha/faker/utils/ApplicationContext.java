/**
 * 
 */
package br.eng.lucasrocha.faker.utils;

/**
 * @author Lucas Rocha <lucas.diegorr@gmail.com>
 *
 */
public class ApplicationContext {

	private String locale;
	
	private String appName;

	private static ApplicationContext instance;
	
	/**
	 * Constructor
	 * @param locale
	 */
	public ApplicationContext(String locale) {
		this.setLocale(locale);
		this.setAppName("faker");
	}

	/**
	 * Constructor Default
	 */
	public ApplicationContext() {
		this.setLocale(Locale.PT_BR);
		this.setAppName("faker");
	}
	
	/**
	 * Return a default instance
	 * @return
	 */
	public static ApplicationContext getInstance() {
		return getInstance(Locale.PT_BR);
	}
	
	/**
	 * Return a default instance
	 * @return
	 */
	public static ApplicationContext getInstance(String locale) {
		if (instance == null) {
			instance = new ApplicationContext(locale);
			return instance;
		}else {
			return instance;
		}
	}

	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	private void setLocale(String locale) {
		this.locale = locale;
	}

	/**
	 * @return the appName
	 */
	public String getAppName() {
		return appName;
	}

	/**
	 * @param appName the appName to set
	 */
	private void setAppName(String appName) {
		this.appName = appName;
	}
}
