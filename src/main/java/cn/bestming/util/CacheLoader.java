package cn.bestming.util;

import java.util.function.*;

/**
 * 缓存数据加载器
 *
 * @author bestming
 * @date 2021-4-23
 * @since 0.4.3
 */
public interface CacheLoader<E> extends Supplier<E> {

	boolean flushRequired();

	E flush(boolean lazy);

}
