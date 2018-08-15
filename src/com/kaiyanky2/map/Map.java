package com.kaiyanky2.map;

public interface Map<K, V> {

    /**
     * 添加操作
     *
     * @param key   键
     * @param value 值
     */
    void add(K key, V value);

    /**
     * 移除操作
     *
     * @param key 键
     * @return 移除的值
     */
    V remove(K key);

    /**
     * 是否包含
     *
     * @param key 键
     * @return true: 包含
     */
    boolean contains(K key);

    /**
     * 通过键获取值
     *
     * @param key 键
     * @return 键对应的值
     */
    V get(K key);

    /**
     * 更新键所对应的值
     *
     * @param key   键
     * @param value 值
     */
    void set(K key, V value);

    /**
     * Map 大小
     *
     * @return 大小
     */
    int getSize();

    /**
     * 是否为空
     *
     * @return true: 空
     */
    boolean isEmpty();
}
