package de.fi.streams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

/**
 * NICE (JavaDoc)
 *
 * @author Hannes
 */
public class StreamDojoTest {

	private static final List<String> NAMES = Arrays.asList("Homer Simpson", "Bart Simpson", "Lisa Simpson",
			"Marge Simpson", "Ned Flanders", "Montgomery Burns", "Waylon Smithers", "Lenny Leonard", "Carl Carlson",
			"Seymour Skinner");
	
	private static final List<Konto> KONTEN = new ArrayList<>();
	
	static {
		Konto k1 = new Konto("Homer Simpson", 50100, new BigDecimal("-1000"));
		k1.getUnterkonten().add(new Konto("Homer Simpson", 950101, new BigDecimal("-600")));
		k1.getUnterkonten().add(new Konto("Homer Simpson", 950102, new BigDecimal("-400")));
		KONTEN.add(k1);
		KONTEN.add(new Konto("Homer Simpson", 50200, new BigDecimal("6.50")));
		
		KONTEN.add(new Konto("Bart Simpson", 50300, new BigDecimal("24.50")));
		
		KONTEN.add(new Konto("Ned Flanders", 50400, new BigDecimal("57000.00")));
		KONTEN.add(new Konto("Ned Flanders", 50500, new BigDecimal("1235.00")));
		
		Konto k2 = new Konto("Montgomery Burns", 100, new BigDecimal("113000"));
		k2.getUnterkonten().add(new Konto("Montgomery Burns", 900101, new BigDecimal("120000")));
		k2.getUnterkonten().add(new Konto("Montgomery Burns", 900102, new BigDecimal("-70000")));
		KONTEN.add(k2);
		KONTEN.add(new Konto("Montgomery Burns", 200, new BigDecimal("-90000")));
		KONTEN.add(new Konto("Montgomery Burns", 300, new BigDecimal("5000000")));
		
	}

	private IStreamDojo dojo = new StreamDojo();

	@Test
	public void testStreamOfNames() throws Exception {
		Stream<String> names = dojo.streamOfNames();
		assertEquals("Homer Simpson, Bart Simpson, Lisa Simpson", names.collect(Collectors.joining(", ")));
	}

	@Test
	public void testStreamOfInts() throws Exception {
		IntStream ints = dojo.streamOfInts(1, 2, 3, 4, 5);
		assertEquals("1, 2, 3, 4, 5", ints.boxed().map(i -> i.toString()).collect(Collectors.joining(", ")));
	}

	@Test
	public void testListOfPowersOfTwo() throws Exception {
		List<Integer> powers = dojo.listOfPowersOfTwo();
		assertEquals(20, powers.size());
		assertEquals(1, powers.stream().findFirst().get().intValue());
		assertEquals(524288, powers.stream().skip(19).findFirst().get().intValue());
	}

	@Test
	public void testFindByName() throws Exception {
		assertEquals("Homer Simpson", dojo.findByName(NAMES, "Homer Simpson"));
		assertEquals("unbekannt", dojo.findByName(NAMES, "Somer Himpson"));
	}

	@Test
	public void testContainsName() throws Exception {
		assertTrue(dojo.containsName(NAMES, "Homer Simpson"));
		assertFalse(dojo.containsName(NAMES, "Somer Himpson"));
	}

	@Test
	public void testContainsNamePart() throws Exception {
		assertTrue(dojo.containsNamePart(NAMES, "Smithers"));
		assertFalse(dojo.containsNamePart(NAMES, "Watson"));
	}

	@Test
	public void testContainsKontoNummer_MethodReference() throws Exception {
		assertTrue(dojo.containsKontoNummer_MethodReference(KONTEN, Long.valueOf(100)));
		assertFalse(dojo.containsKontoNummer_MethodReference(KONTEN, Long.valueOf(101)));
	}

	@Test
	public void testContainsKontoNummer_LambdaFunction() throws Exception {
		assertTrue(dojo.containsKontoNummer_LambdaFunction(KONTEN, Long.valueOf(100)));
		assertFalse(dojo.containsKontoNummer_LambdaFunction(KONTEN, Long.valueOf(101)));
	}

	@Test
	public void testCollectKontoInhaber() throws Exception {
		assertEquals("Homer Simpson, Bart Simpson, Ned Flanders, Montgomery Burns", dojo.collectKontoInhaber(KONTEN).stream().collect(Collectors.joining(", ")));
	}

	@Test
	public void testCollectKontoInhaberSorted() throws Exception {
		assertEquals("Bart Simpson, Homer Simpson, Montgomery Burns, Ned Flanders", dojo.collectKontoInhaberSorted(KONTEN).stream().collect(Collectors.joining(", ")));
	}

	@Test
	public void testCollectKontoInhaberAsString() throws Exception {
		assertEquals("Homer Simpson, Bart Simpson, Ned Flanders, Montgomery Burns", dojo.collectKontoInhaberAsString(KONTEN));
	}

	@Test
	public void testCollectUeberzogeneKonten() throws Exception {
		List<Konto> ueberzogene = dojo.collectUeberzogeneKonten(KONTEN);
		assertEquals(2, ueberzogene.size());
		assertTrue(ueberzogene.stream().anyMatch(k -> k.getKontoNummer().intValue() == 50100));
		assertTrue(ueberzogene.stream().anyMatch(k -> k.getKontoNummer().intValue() == 200));
	}

	@Test
	public void testCollectKontenZuPersonen() throws Exception {
		Map<String, List<Konto>> kontenZuPersonen = dojo.collectKontenZuPersonen(KONTEN);
		
		assertEquals(4, kontenZuPersonen.size());
		assertTrue(kontenZuPersonen.containsKey("Bart Simpson"));
		assertTrue(kontenZuPersonen.containsKey("Homer Simpson"));
		assertTrue(kontenZuPersonen.containsKey("Montgomery Burns"));
		assertTrue(kontenZuPersonen.containsKey("Ned Flanders"));
	}

	@Test
	public void testCollectUeberzogeneKontenSorted() throws Exception {
		List<Konto> ueberzogene = dojo.collectUeberzogeneKontenSorted(KONTEN);
		assertEquals(2, ueberzogene.size());
		assertEquals(200, ueberzogene.get(0).getKontoNummer().intValue());
		assertEquals(50100, ueberzogene.get(1).getKontoNummer().intValue());
	}

	@Test
	public void testComputeAnzahlUnterkonten() throws Exception {
		assertEquals(0.5, dojo.computeAnzahlUnterkonten(KONTEN), 0.01);
	}

	@Test
	public void testComputeSummeSaldo() throws Exception {
		assertEquals(new BigDecimal("5080266.00"), dojo.computeSummeSaldo(KONTEN));
	}

	@Test
	public void testComputeSummeSaldoParallel() throws Exception {
		assertEquals(new BigDecimal("5080266.00"), dojo.computeSummeSaldoParallel(KONTEN));
	}

	@Test
	public void testComputeSummeSaldoNichtUeberzogene() throws Exception {
		assertEquals(new BigDecimal("5171266.00"), dojo.computeSummeSaldoNichtUeberzogene(KONTEN));
	}

	@Test
	public void testComputeSummeSaldoNichtUeberzogeneMitUnterkonten() throws Exception {
		assertEquals(new BigDecimal("113000"), dojo.computeSummeSaldoNichtUeberzogeneMitUnterkonten(KONTEN));
	}

}