/**
 * 
 */
package br.eng.lucasrocha.faker.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Random;

import org.junit.Test;

import br.eng.lucasrocha.faker.Faker;

/**
 * @author Lucas Rocha
 *
 */
public class LoremTest {

	/**
	 * Test method for {@link br.eng.lucasrocha.faker.resources.Lorem#paragraphs()}.
	 */
	@Test
	public void testParagraphs() {
		assertNotNull(Faker.lorem.paragraphs());
	}

	/**
	 * Test method for {@link br.eng.lucasrocha.faker.resources.Lorem#paragraphs(java.lang.Integer)}.
	 */
	@Test
	public void testParagraphsQuantity() {
		int quantity = new Random().nextInt(10);
		assertEquals(quantity, Faker.lorem.paragraphs(quantity).split("\n").length);
	}

	/**
	 * Test method for {@link br.eng.lucasrocha.faker.resources.Lorem#paragraph()}.
	 */
	@Test
	public void testParagraph() {
		assertNotNull(Faker.lorem.paragraph());
	}

	/**
	 * Test method for {@link br.eng.lucasrocha.faker.resources.Lorem#word()}.
	 */
	@Test
	public void testWord() {
		assertNotNull(Faker.lorem.word());
	}

	/**
	 * Test method for {@link br.eng.lucasrocha.faker.resources.Lorem#words()}.
	 */
	@Test
	public void testWords() {
		assertNotNull(Faker.lorem.words());
	}

	/**
	 * Test method for {@link br.eng.lucasrocha.faker.resources.Lorem#words(java.lang.Integer)}.
	 */
	@Test
	public void testWordsQuantity() {
		int quantity = new Random().nextInt(10);
		assertEquals(quantity, Faker.lorem.words(quantity).size());
	}

	/**
	 * Test method for {@link br.eng.lucasrocha.faker.resources.Lorem#letter()}.
	 */
	@Test
	public void testLetter() {
		assertNotNull(Faker.lorem.letter());
	}

	/**
	 * Test method for {@link br.eng.lucasrocha.faker.resources.Lorem#letters(java.lang.Integer)}.
	 */
	@Test
	public void testLetters() {
		int quantity = new Random().nextInt(10);
		assertEquals(quantity, Faker.lorem.letters(quantity).length());
	}

	/**
	 * Test method for {@link br.eng.lucasrocha.faker.resources.Lorem#letterUpperCase()}.
	 */
	@Test
	public void testLetterUpperCase() {
		assertNotNull(Faker.lorem.letterUpperCase());
	}

	/**
	 * Test method for {@link br.eng.lucasrocha.faker.resources.Lorem#lettersUpperCase(java.lang.Integer)}.
	 */
	@Test
	public void testLettersUpperCase() {
		int quantity = new Random().nextInt(10);
		assertEquals(quantity, Faker.lorem.lettersUpperCase(quantity).length());
	}

	/**
	 * Test method for {@link br.eng.lucasrocha.faker.resources.Lorem#letterLowerCase()}.
	 */
	@Test
	public void testLetterLowerCase() {
		assertNotNull(Faker.lorem.letterLowerCase());
	}

	/**
	 * Test method for {@link br.eng.lucasrocha.faker.resources.Lorem#lettersLowerCase(java.lang.Integer)}.
	 */
	@Test
	public void testLettersLowerCase() {
		int quantity = new Random().nextInt(10);
		assertEquals(quantity, Faker.lorem.lettersLowerCase(quantity).length());
	}

	/**
	 * Test method for {@link br.eng.lucasrocha.faker.resources.Lorem#digit()}.
	 */
	@Test
	public void testNumeric() {
		assertNotNull(Faker.lorem.digit());
	}

	/**
	 * Test method for {@link br.eng.lucasrocha.faker.resources.Lorem#digits(java.lang.Integer)}.
	 */
	@Test
	public void testNumerics() {
		int quantity = new Random().nextInt(10);
		assertEquals(quantity, Faker.lorem.digits(quantity).length());
	}

	/**
	 * Test method for {@link br.eng.lucasrocha.faker.resources.Lorem#alphaNumeric()}.
	 */
	@Test
	public void testAlphaNumeric() {
		assertNotNull(Faker.lorem.alphaNumeric());
	}

	/**
	 * Test method for {@link br.eng.lucasrocha.faker.resources.Lorem#alphaNumerics(java.lang.Integer)}.
	 */
	@Test
	public void testAlphaNumerics() {
		int quantity = new Random().nextInt(10);
		assertEquals(quantity, Faker.lorem.alphaNumerics(quantity).length());
	}

}
