package com.orderfood.config;


import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

public class RedisUtil {
    private static final Logger LOGGER = Logger.getLogger(RedisUtil.class);
    private static JedisPool pool = null;

    private static RedisUtil ru = new RedisUtil();

    private RedisUtil() {
        if (pool == null) {
            String ip = "127.0.0.1";
            int port = 6379;
            JedisPoolConfig config = new JedisPoolConfig();
            // 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
            // 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
            config.setMaxTotal(10000);
            // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
            config.setMaxIdle(2000);
            // 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
            config.setMaxWaitMillis(1000 * 100);
            config.setTestOnBorrow(true);
            pool = new JedisPool(config, ip, port, 100000);
        }
    }

    /**
     * <p>向redis存入key和value,并释放连接资源</p>
     * <p>如果key已经存在 则覆盖</p>
     *
     * @param key
     * @param value
     * @return 成功 返回OK 失败返回 0
     */
    public String set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.set(key, value);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
            return "0";
        } finally {
            returnResource(pool, jedis);
        }
    }


    /**
     * <p>通过key获取储存在redis中的value</p>
     * <p>并释放连接</p>
     * @param key
     * @return 成功返回value 失败返回null
     */
    public String get(String key){
        Jedis jedis = null;
        String value = null;
        try {
            jedis = pool.getResource();
            value = jedis.get(key);
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        } finally {
            returnResource(pool, jedis);
        }
        return value;
    }


        /**
         * 返还到连接池
         *
         * @param pool
         * @param jedis
         */
    public static void returnResource(JedisPool pool, Jedis jedis) {
        if (jedis != null) {
            pool.returnResource(jedis);
        }
    }

    public static RedisUtil getRu() {
        return ru;
    }

    public static void setRu(RedisUtil ru) {
        RedisUtil.ru = ru;
    }
}