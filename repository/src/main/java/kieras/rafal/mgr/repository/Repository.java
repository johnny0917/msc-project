package kieras.rafal.mgr.repository;

public interface Repository<E, K> {
    public void add(E entity);
    public E find(K key);
    public void remove(K key);
    public void update(E entity);
}
