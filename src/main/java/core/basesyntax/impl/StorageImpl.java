package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ELEMENTS = 10;
    private K[] arrayOfKeys = (K[]) new Object[MAX_NUMBER_OF_ELEMENTS];
    private V[] arrayOfValues = (V[]) new Object[MAX_NUMBER_OF_ELEMENTS];
    private int sizeOfStorage = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < sizeOfStorage; i++) {
            if (key == arrayOfKeys[i] || key != null && key.equals(arrayOfKeys[i])) {
                arrayOfValues[i] = value;
                return;
            }
        }
        arrayOfKeys[sizeOfStorage] = key;
        arrayOfValues[sizeOfStorage] = value;
        sizeOfStorage++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < sizeOfStorage; i++) {
            if (key == arrayOfKeys[i] || key != null && key.equals(arrayOfKeys[i])) {
                return arrayOfValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeOfStorage;
    }
}
