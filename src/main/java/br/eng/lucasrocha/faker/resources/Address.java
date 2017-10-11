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
public class Address {

	private final String base = "address."; 


	/**
	 * 
	 */
	public Address() {
		ApplicationContext.getInstance(Faker.getInstance().getLocale());
	}
	
	private List<String> loadResource(String resource){
		return LoadResource.load( this.base + resource);
	}
	
	public List<String> cityPrefixes(){
		return loadResource("city_prefix");
	}
	
	public List<String> cityPrefixes(Integer quantity){
		return ListUtils.randomSubList(cityPrefixes(), quantity);
	}
	
	public String cityPrefix() {
		List<String> cityPrefixes = cityPrefixes();
		return cityPrefixes.get(new Random().nextInt(cityPrefixes.size()));
	}
	
	public List<String> citySuffixes(){
		return loadResource("city_suffix");
	}
	
	public List<String> citySuffixes(Integer quantity){
		return ListUtils.randomSubList(citySuffixes(), quantity);
	}
	
	public String citySuffix() {
		List<String> citySuffixes = citySuffixes();
		return citySuffixes.get(new Random().nextInt(citySuffixes.size()));
	}
	
	public List<String> cityNames(){
		Integer quantity = new Random().nextInt();
		return cityNames(quantity);
	}
	
	public List<String> cityNames(Integer quantity){
		List<String> cityNames = new ArrayList<String>();
		for (int i = 0; i < quantity; i++) {
			cityNames.add(cityName());
		}
		return cityNames;
	}
	
	public String cityName() {
		return cityPrefix() + citySuffix();
	}
	
	public List<String> countries(){
		return loadResource("city_suffix");
	}
	
	public List<String> countries(Integer quantity){
		return ListUtils.randomSubList(countries(), quantity);
	}
	
	public String country() {
		List<String> citySuffixes = countries();
		return citySuffixes.get(new Random().nextInt(citySuffixes.size()));
	}
	
	public List<String> states(){
		return loadResource("state");
	}
	
	public List<String> states(Integer quantity){
		return ListUtils.randomSubList(states(), quantity);
	}
	
	public String state() {
		List<String> states = states();
		return states.get(new Random().nextInt(states.size()));
	}
	
	public List<String> statesAbbrs(){
		return loadResource("state_abbr");
	}
	
	public List<String> statesAbbrs(Integer quantity){
		return ListUtils.randomSubList(statesAbbrs(), quantity);
	}
	
	public String stateAbbr() {
		List<String> stateAbbrs = statesAbbrs();
		return stateAbbrs.get(new Random().nextInt(stateAbbrs.size()));
	}
	
	public String postCodeByState(String state) {
		List<String> loadResource = loadResource("postcode_by_state." + state);
		String postCodeTemplate = loadResource != null ? loadResource.get(0) : "";
		while (postCodeTemplate.contains("#")) {
			postCodeTemplate = postCodeTemplate.replaceFirst("#", Integer.toString(new Random().nextInt(10)));
		}
		return postCodeTemplate;
	}
	
	public List<String> postCodesByState(String state, Integer quantity){
		List<String> postCodes = new ArrayList<String>();
		for (int i = 0; i < quantity; i++) {
			postCodes.add(postCodeByState(state));
		}
		return postCodes;
	}
	
	public List<String> postCodesByState(String state){
		Integer quantity = new Random().nextInt();
		return postCodesByState(state, quantity); 
	}
	
	public String defaultCountry() {
		return loadResource("default_country").get(0);
	}
	
	public List<String> streetSufixes() {
		return loadResource("street_suffix");
	}
	
	public List<String> streetSufixes(Integer quantity) {
		return ListUtils.randomSubList(loadResource("street_suffix"), quantity);
	}
	
	public String streetSufix() {
		List<String> streetSufixes = streetSufixes();
		return streetSufixes.get(new Random().nextInt(streetSufixes.size()));
	}
	
	public String streetName() {
		String templateStreetName = loadResource("street_name").get(new Random().nextInt(2));
		templateStreetName = templateStreetName.replaceFirst("\\#\\{street_suffix\\}", streetSufix());
		templateStreetName = templateStreetName.replaceFirst("\\#\\{Name\\.first_name\\}", Faker.name.firstName());
		templateStreetName = templateStreetName.replaceFirst("\\#\\{Name\\.last_name\\}", Faker.name.lastName());
		return templateStreetName;
	}
	
	public List<String> streetNames(){
		Integer quantity = new Random().nextInt();
		return streetNames(quantity);
	}
	
	public List<String> streetNames(Integer quantity){
		List<String> streetNames = new ArrayList<String>();
		for (int i = 0; i < quantity; i++) {
			streetNames.add(streetName());
		}
		return streetNames;
	}
	
	public String buildingNumber() {
		String templateBuildingNumber = loadResource("building_number").get(new Random().nextInt(4));
		while (templateBuildingNumber.contains("#")) {
			templateBuildingNumber = templateBuildingNumber.replaceFirst("#", Integer.toString(new Random().nextInt(10)));
		}
		return templateBuildingNumber;
	}
	
	public List<String> buildingNumbers(Integer quantity){
		List<String> buildingNumbers = new ArrayList<String>();
		for (int i = 0; i < quantity; i++) {
			buildingNumbers.add(buildingNumber());
		}
		return buildingNumbers;
	}
	
	public List<String> buildingNumbers(){
		Integer quantity = new Random().nextInt();
		return buildingNumbers(quantity);
	}
	
	public String secondaryAddress() {
		String templateSecondaryAddress = loadResource("secondary_address").get(new Random().nextInt(5));
		while (templateSecondaryAddress.contains("#")) {
			templateSecondaryAddress = templateSecondaryAddress.replaceFirst("#", Integer.toString(new Random().nextInt(10)));
		}
		return templateSecondaryAddress;
	}
	
	public List<String> secondaryAddresses(Integer quantity){
		List<String> secondaryAddress = new ArrayList<String>();
		for (int i = 0; i < quantity; i++) {
			secondaryAddress.add(secondaryAddress());
		}
		return secondaryAddress;
	}
	
	public List<String> secondaryAddresses(){
		Integer quantity = new Random().nextInt();
		return secondaryAddresses(quantity);
	}
	
	public String postCode() {
		List<String> loadResource = loadResource("postcode");
		String templatePostCode = loadResource != null ? loadResource.get(0) : "";
		while (templatePostCode.contains("#")) {
			templatePostCode = templatePostCode.replaceFirst("#", Integer.toString(new Random().nextInt(10)));
		}
		return templatePostCode;
	}
	
	public List<String> postCodes(Integer quantity){
		List<String> postCodes = new ArrayList<String>();
		for (int i = 0; i < quantity; i++) {
			postCodes.add(postCode());
		}
		return postCodes;
	}
	
	public List<String> postCodes(){
		Integer quantity = new Random().nextInt();
		return postCodes(quantity);
	}
	
	public String fullAddress() {
		String fullAddress = streetName() + ", " + buildingNumber(); 
		String secondary = secondaryAddress();
		if (secondary.hashCode()%2 == 0) {
			fullAddress += ", " + secondary; 
		}
		return  fullAddress + ", " + postCode();
	}
	
	public List<String> fullAddresses(Integer quantity){
		List<String> fullAddress = new ArrayList<String>();
		for (int i = 0; i < quantity; i++) {
			fullAddress.add(fullAddress());
		}
		return fullAddress;
	}
}
