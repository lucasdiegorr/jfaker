/**
 * 
 */
package br.eng.lucasrocha.faker.utils;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.NoSuchElementException;

import br.eng.lucasrocha.faker.Faker;

/**
 * @author Lucas Rocha <lucas.diegorr@gmail.com>
 *
 */
public class Mock {

	public Object generateInstance(Class<?> clazz) {
		
		Object object = null;

		try {
			if (!(clazz.isInterface() || clazz.isArray())) {
				object = clazz.newInstance();
				for (Field field : clazz.getDeclaredFields()) {
					field.setAccessible(true);
					if (isJavaType(field.getType())) {
						field.set(object, generateValue(field.getType()));
					} else {
						field.set(object,generateInstance(field.getType()));
					}
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return object;
	}
	
	private static boolean isJavaType(Class<?> clazz) throws InstantiationException, IllegalAccessException{
		return 	clazz.isPrimitive()  ||
				clazz.isInstance(String.class.newInstance()) || 
				clazz.isInstance(new Boolean(true)) ||
				clazz.isInstance(new Integer(0)) || 
				clazz.isInstance(new Double(0)) ||
				clazz.isInstance(new Float(0)) ||
				clazz.isInstance(new Long(0)) ||
				clazz.isInstance(new Character('0')) ||
				clazz.isInstance(new Date());
	}
	
	private static Object generateValue(Class<?> clazz) throws InstantiationException, IllegalAccessException{
		
		if (clazz.isInstance(String.class.newInstance())) {
			return Faker.lorem.paragraphs();
		} else if (clazz.isInstance(new Boolean(true)) || clazz.isInstance(boolean.class)){
			return new Date().getTime() % 2 == 0;
		} else if (clazz.isInstance(new Integer(0)) || clazz.isInstance(int.class)) {
			return new Integer(String.valueOf(Faker.lorem.digit()));
		} else if (clazz.isInstance(new Double(0)) || clazz.isInstance(double.class)) {
			return new Integer(String.valueOf(Faker.lorem.digit()));
		} else if(clazz.isInstance(new Float(0)) || clazz.isInstance(float.class)) {
			return new Float(String.valueOf(Faker.lorem.digit()));
		} else if (clazz.isInstance(new Long(0)) || clazz.isInstance(long.class)) {
			return new Long(String.valueOf(Faker.lorem.digits(10)));
		} else if(clazz.isInstance(new Character('0')) || clazz.isInstance(char.class)){
			return Faker.lorem.letter();
		} else if (clazz.isInstance(new Date())) {
			return new Date();
		}
		return null;
	}
}
