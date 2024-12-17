package article.jdbc.dao;

import java.util.Collection;

public interface DaoInterface<T, K> {
	Collection<T> retrieveAll();

	T retrieveOne(K key);

	void create(T t);

	void update(T t);

	void delete(K key);
}
