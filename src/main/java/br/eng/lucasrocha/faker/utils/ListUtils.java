/**
 * 
 */
package br.eng.lucasrocha.faker.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Lucas Rocha <lucas.diegorr@gmail.com>
 *
 */
public class ListUtils {

	public static List<String> randomSubList(List<String> list, Integer size){
		List<String> returnList = new ArrayList<String>();
		if (list != null) {
			for (int index = 0; index < size; index++) {
				returnList.add(list.get(new Random().nextInt(list.size())));
			}
		}
		return returnList;
	}
	
}
