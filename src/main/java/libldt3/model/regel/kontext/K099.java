/*
 * Copyright 2016-2017  Christoph Brill <egore911@gmail.com>
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
package libldt3.model.regel.kontext;

import libldt3.model.enums.Grenzwertindikator;
import libldt3.model.enums.GrenzwertindikatorErweitert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static libldt3.model.regel.kontext.KontextregelHelper.containsAnyString;
import static libldt3.model.regel.kontext.KontextregelHelper.findFields;

public class K099 implements Kontextregel {

    private static final Logger LOG = LoggerFactory.getLogger(K099.class);

    private static final Set<String> FIELDTYPES = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("8422")));

    @Override
    public boolean isValid(Object owner) throws IllegalAccessException {

        Map<String, Field> fields = findFields(owner, FIELDTYPES);
        if (fields.size() != FIELDTYPES.size()) {
            LOG.error("Class of {} must have fields {}", owner, FIELDTYPES);
            return false;
        }

        Object o = fields.get("8422").get(owner);
        if (o instanceof Collection) {
            for (GrenzwertindikatorErweitert grenzwertindikatorErweitert : (Collection<GrenzwertindikatorErweitert>) o) {
                Grenzwertindikator grenzwertindikator = grenzwertindikatorErweitert.getValue();
                if ((grenzwertindikator == Grenzwertindikator.EXTREM_L ||
                        grenzwertindikator == Grenzwertindikator.EXTREM_MINUS ||
                        grenzwertindikator == Grenzwertindikator.EXTREM_H ||
                        grenzwertindikator == Grenzwertindikator.EXTREM_PLUS) &&
                        !containsAnyString(fields.get("8126"), grenzwertindikatorErweitert)) {
                    return false;
                }
            }
            return true;
        } else {
            Grenzwertindikator grenzwertindikator = ((GrenzwertindikatorErweitert) o).getValue();
            if ((grenzwertindikator == Grenzwertindikator.EXTREM_L ||
                    grenzwertindikator == Grenzwertindikator.EXTREM_MINUS ||
                    grenzwertindikator == Grenzwertindikator.EXTREM_H ||
                    grenzwertindikator == Grenzwertindikator.EXTREM_PLUS) &&
                    !containsAnyString(fields.get("8126"), o)) {
                return false;
            }
        }



        return true;
    }

}
