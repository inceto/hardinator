/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unibe.scs.into.evaluators;

import java.util.AbstractMap;
import java.util.Set;

/**
 *
 * @author reto
 */
public class LogarythmicWordFrequencyMap extends AbstractMap<String, Integer> implements FrequencyMap  {
    private final FrequencyMap wrapped;

    public LogarythmicWordFrequencyMap(FrequencyMap wrapped) {
        this.wrapped = wrapped;
    }

    
    public int getMaxFrequency() {
        return (int) Math.log(wrapped.getMaxFrequency());
    }

    @Override
    public int size() {
        return wrapped.size();
    }

    @Override
    public boolean isEmpty() {
        return wrapped.isEmpty();
    }

    @Override
    public boolean containsKey(Object o) {
        return wrapped.containsKey(o);
    }

   
    @Override
    public Integer get(Object o) {
        return (int)Math.log(wrapped.get(o));
    }

    public Set entrySet() {
        return wrapped.keySet();
    }

    
    
    
}
