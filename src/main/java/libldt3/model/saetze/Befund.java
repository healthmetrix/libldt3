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
package libldt3.model.saetze;

import java.util.List;

import libldt3.annotations.Datenpaket;
import libldt3.annotations.Feld;
import libldt3.annotations.Feldart;
import libldt3.annotations.Regelsatz;
import libldt3.model.enums.Satzart;
import libldt3.model.objekte.Anhang;
import libldt3.model.objekte.Befundinformationen;
import libldt3.model.objekte.Einsenderidentifikation;
import libldt3.model.objekte.Fliesstext;
import libldt3.model.objekte.Koerperkenngroessen;
import libldt3.model.objekte.Laborergebnisbericht;
import libldt3.model.objekte.Laborkennung;
import libldt3.model.objekte.Material;
import libldt3.model.objekte.Mutterschaft;
import libldt3.model.objekte.Patient;
import libldt3.model.objekte.Schwangerschaft;
import libldt3.model.objekte.Tier;
import libldt3.model.objekte.Veranlassungsgrund;
import libldt3.model.regel.kontext.K005;
import lombok.Getter;
import lombok.Setter;

/**
 * Befund "8205"
 */
@Datenpaket(value = Satzart.Befund, kontextregeln = K005.class)
public @Getter @Setter class Befund implements Satz {

	@Feld(value = "8136", feldart = Feldart.kann)
	@Regelsatz(laenge = 12)
	private List<Laborkennung> laborkennung;
	@Feld(value = "8122", feldart = Feldart.muss)
	@Regelsatz(laenge = 23)
	private Einsenderidentifikation senderIdentification;
	@Feld(value = "8145", feldart = Feldart.bedingt_muss)
	@Regelsatz(laenge = 7)
	private Patient patient;
	@Feld(value = "8169", feldart = Feldart.bedingt_kann)
	@Regelsatz(laenge = 19)
	private Koerperkenngroessen koerperkenngroessen;
	@Feld(value = "8150", feldart = Feldart.bedingt_kann)
	@Regelsatz(laenge = 15)
	private Schwangerschaft schwangerschaft;
	@Feld(value = "8140", feldart = Feldart.bedingt_kann)
	@Regelsatz(laenge = 12)
	private Mutterschaft mutterschaft;
	@Feld(value = "8153", name = "Tier_Sonstiges", feldart = Feldart.bedingt_muss)
	@Regelsatz(laenge = 14)
	private Tier tier;
	@Feld(value = "8117", feldart = Feldart.muss)
	@Regelsatz(laenge = 19)
	private Befundinformationen befundinformationen;
	@Feld(value = "8127", feldart = Feldart.kann)
	@Regelsatz(laenge = 18)
	private List<Veranlassungsgrund> veranlassungsgrund;
	@Feld(value = "8137", feldart = Feldart.muss)
	@Regelsatz(laenge = 8)
	private List<Material> material;
	@Feld(value = "8135", feldart = Feldart.muss)
	@Regelsatz(laenge = 20)
	private Laborergebnisbericht laborergebnisbericht;
	@Feld(value = "8167", name = "Zusaetzliche_Informationen", feldart = Feldart.kann)
	@Regelsatz(laenge = 26)
	private List<Fliesstext> text;
	@Feld(value = "8110", feldart = Feldart.kann)
	@Regelsatz(laenge = 6)
	private List<Anhang> anhang;

}
