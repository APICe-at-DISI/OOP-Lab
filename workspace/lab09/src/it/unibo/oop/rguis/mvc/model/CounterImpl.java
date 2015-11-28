package it.unibo.oop.rguis.mvc.model;

/**
 * Implementation of {@link CounterModel}}.
 *
 */
public class CounterImpl implements CounterModel {

    private int counter;

    /**
     * Constructs a new counter.
     */
    public CounterImpl() {
        this.counter = 0;
    }

    /**
     * {@inheritDoc}
     */
    public void increment() {
        this.counter++;
    }

    /**
     * {@inheritDoc}
     */
    public int getValue() {
        return this.counter;
    }

}
