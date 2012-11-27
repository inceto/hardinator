/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unibe.scs.into.evaluators;

import java.util.Map;

/**
 *
 * @author reto
 */
public interface FrequencyMap extends Map<String, Integer> {

    int getMaxFrequency();
    
}
