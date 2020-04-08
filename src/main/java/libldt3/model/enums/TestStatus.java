/*
 * Copyright 2016  Christoph Brill <egore911@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package libldt3.model.enums;

/**
 * E007
 */
public enum TestStatus {
    /**
     * Es ist keine gesicherte Information zum Ergebnis verfuegbar oder abzubilden und es wird auch keine
     * Information dazu ausgegeben oder angegeben werden koennen
     */
    KEINE_GESICHERTE_INFORMATION("01"),
    /**
     * Es liegt eine Untersuchungsanforderung vor, fuer die es aktuell noch kein Ergebnis gibt
     */
    ERGEBNIS_FOLGT("02"),
    /**
     * Ein technisch validiertes Ergebnis ist ermittelt
     */
    ERGEBNIS("03"),
    /**
     * Ein technisch validiertes Ergebnis wurde korrigiert. Die Korrektur ist zu dokumentieren. Es erfolgt keine weitere Abrechnung.
     */
    ERGEBNIS_KORRIGIERT("04"),
    /**
     * Ein aertzlich validiertes Ergebnis liegt vor, allerdings laeuft die Analytik zur Absicherung noch weiter. In Einzelfaellen
     * koennen sich noch Veraenderungen ergeben. Es folgt dann ein korrigiertes Ergebnis.
     */
    ERGEBNIS_ERMITTELT("05"),
    /**
     * Die Analytik dieser Untersuchungsanforderung ist abeschlossen und ein aerztlich validiertes Ergebnis liegt vor.
     */
    BEFUNDERGEBNIS("06"),
    /**
     * Das Befundergebnis ist unveraendert schon mindestens einmal uebermittelt worden (keine Abrechnung!)
     */
    BEFUNDERGEBNIS_BEREITS_BERICHTET("07"),
    /**
     * Das schon uebermittelte Befundergebnis ist korrigiert worden. Damit hat nur noch dieses korrigierte Befundergebnis
     * Gueltigkeit und alle bisherigen Befundergebnisse zu dieser Untersuchungsanforderung verlieren ihre Gueltigkeit. Die
     * Korrektur ist zu dokumentieren. Es erfolgt keine weiter Abrechnung.
     */
    BEFUNDERGEBNIS_KORRIGIERT("08"),
    /**
     * Das Ergebnis ist nicht vorhanden oder kann nicht mehr ermittelt werden. Weil das Ergebnis fehlt, kann auch kein
     * Befundergebnis erstellt werden.
     */
    ERGEBNIS_FEHLT("09"),
    /**
     * Eine erweiterte Untersuchungsanalytik zur besseren Beurteilung und Absicherung des bisher ermittelten aertzlich
     * validierten Befundes ist erforderlich. Die weiteren Ergebnisse werden in folgenden Befundberichten ergaenzt.
     * Kommentar: Diese Ergebnisse werden zu Befunden (einer Leistung). Der Befundbericht vor Einleitung der erweiterten
     * Analytik kann nur den Status "Auftrag nicht abgeschlossen" haben. Sollte dies nicht zutreffen ist ein neuer Auftrag
     * zu erstellen"!
     */
    ERWEITERTE_ANALYTIK_ERFORDERLICH("10"),
    /**
     * Fuer die Untersuchungsanforderung ist kein Material fuer die Analytik vorhanden.
     */
    MATERIAL_FEHLT("11"),
    /**
     * Die Untersuchungsanforderung wurde storniert.
     */
    STORNIERT("12");

    private final String code;

    TestStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}