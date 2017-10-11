/**
 * 
 */
package br.eng.lucasrocha.faker.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

/**
 * @author Lucas Rocha <lucas.diegorr@gmail.com>
 *
 */
public class LoadResource {

	public static List<String> load(String resource) {
		Map<?,?> valuesMapResource = new Yaml().loadAs(ApplicationContext.getInstance().getClass().getResourceAsStream("/"+ ApplicationContext.getInstance().getLocale() +".yml"), Map.class);
        Map<?,?> localeBasedMapResource = (Map<?, ?>) valuesMapResource.get(ApplicationContext.getInstance().getLocale());
        Map<?,?> appMapResource = (Map<?, ?>) localeBasedMapResource.get(ApplicationContext.getInstance().getAppName());
        
		return loadResource(appMapResource, resource);
	}
	
	private static List<String> loadResource(Map<?, ?> valuesMapResource, String resourcePath){
		String[] splitPath = resourcePath.split("\\.", 2);
		if (splitPath.length > 1) {
			Map<?,?> map = (Map<?,?>) valuesMapResource.get(splitPath[0]);
			return loadResource(map, splitPath[1]);
		}
		List<?> listFromMap = Arrays.asList(valuesMapResource.get(resourcePath));
		List<String> returnList = new ArrayList<String>();
		for (Object object : listFromMap) {
			returnList .add(object.toString());
		}
		return returnList;
	}
}
