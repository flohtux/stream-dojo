package de.fi.streams;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * NICE (JavaDoc)
 *
 * @author Hannes
 */
public interface IStreamDojo {

	/**
	 * Erzeuge einen Stream mit folgenden Namen: Homer Simpson, Bart Simpson, Lisa Simpson
	 */
	Stream<String> streamOfNames();

	/**
	 * Erzeuge einen int-Stream mit den �bergebenen Eintr�gen
	 */
	IntStream streamOfInts(int... i);

	/**
	 * Erzeuge einen Integer-Liste mit den ersten 20 2er-Potenzen. Nutze daf�r
	 * stream-Mittel.
	 */
	List<Integer> listOfPowersOfTwo();

	/**
	 * Finde in der Liste einen entsprechenden Namen. Liefere "unbekannt", falls der
	 * Name nicht gefunden wird.
	 */
	String findByName(List<String> names, String nameToFind);

	/**
	 * Pr�fe, ob die Liste einen Eintrag mit dem Namen enth�lt
	 */
	boolean containsName(List<String> names, String nameToFind);

	/**
	 * Pr�fe, ob die Liste einen Eintrag enth�lt, der den �bergebenen Namensteil
	 * enth�lt
	 */
	boolean containsNamePart(List<String> names, String namePartToFind);

	/**
	 * Pr�fe, ob die Liste eine Konto mit der �bergebenen Kontonummer enth�lt. Nutze
	 * f�r die �berpr�fung eine Lambda-Funktion.
	 */
	boolean containsKontoNummer_LambdaFunction(List<Konto> konten, Long kontoNrToFind);

	/**
	 * Pr�fe, ob die Liste eine Konto mit der �bergebenen Kontonummer enth�lt. Nutze
	 * f�r die �berpr�fung eine Methodenreferenz.
	 */
	boolean containsKontoNummer_MethodReference(List<Konto> konten, Long kontoNrToFind);

	/**
	 * Liefere eine Liste aller Kontoinhaber. Achte darauf, dass die Liste keine
	 * Duplikate enth�lt!
	 */
	List<String> collectKontoInhaber(List<Konto> konten);

	/**
	 * Liefere eine sortierte Liste aller Kontoinhaber. Achte darauf, dass die Liste
	 * keine Duplikate enth�lt!
	 */
	List<String> collectKontoInhaberSorted(List<Konto> konten);

	/**
	 * Liefere eine Liste aller Kontoinhaber als komma-separatierter String.
	 */
	String collectKontoInhaberAsString(List<Konto> konten);

	/**
	 * Liefere nur die Konten mit einem negativen Saldo (echt kleiner 0).
	 */
	List<Konto> collectUeberzogeneKonten(List<Konto> konten);

	/**
	 * Liefere nur die Konten mit einem negativen Saldo (echt kleiner 0), sortiert
	 * aufsteigend nach Kontonummer. �berlegt, wie die Bedingung f�r den negativen
	 * Saldo sinnvoll an einer Stelle gehalten werden kann.
	 */
	List<Konto> collectUeberzogeneKontenSorted(List<Konto> konten);

	/**
	 * Liefere die durchschnittliche Anzahl von Unterkonten
	 */
	double computeAnzahlUnterkonten(List<Konto> konten);

	/**
	 * Liefere die Summe aller Salden
	 */
	BigDecimal computeSummeSaldo(List<Konto> konten);

	/**
	 * Liefere die Summe aller Salden. Nutze dazu einen parallelen Stream. Welche
	 * Aufgabe hat der "combiner", der der Methode reduce �bergeben werden kann?
	 */
	BigDecimal computeSummeSaldoParallel(List<Konto> konten);

	/**
	 * Liefere die Summe aller Salden der nicht �berzogenen Konten (Saldo gr��er
	 * gleich 0)
	 */
	BigDecimal computeSummeSaldoNichtUeberzogene(List<Konto> konten);

	/**
	 * Liefere die Summe aller Salden der nicht �berzogenen Konten (Saldo gr��er
	 * gleich 0), die mindestens ein Unterkonto haben. Nutze und verkn�pfe bereits
	 * vorhandene Predicates.
	 */
	BigDecimal computeSummeSaldoNichtUeberzogeneMitUnterkonten(List<Konto> konten);

	/**
	 * Liefere alle Konten, zugeordnet zu ihren Kontoinhabern.
	 */
	Map<String, List<Konto>> collectKontenZuPersonen(List<Konto> konten);
}
