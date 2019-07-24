/**
 * Copyright (c) 2017 Baozun All Rights Reserved.
 * <p>
 * This software is the confidential and proprietary information of Baozun. You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms of the license agreement
 * you entered into with Baozun.
 * <p>
 * BAOZUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE, EITHER EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. BAOZUN SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY
 * LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */
package com.lgj.redis;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redis操作客户端
 * @version 1.7.0
 * @date 2018/8/24 14:56
 * @since JDK 1.8  
 * @author 李高杰
 *
 */
@Component
public class RedisClient {

    private static Logger log = LoggerFactory.getLogger(RedisClient.class);
    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String REDIS_ERROR = "redis服务异常";

    /**
     * 获取String类型的value
     * @param key key
     * @return 为空返回null
     */
    public String getString(String key){
        String value = null;
        try{
            value = redisTemplate.opsForValue().get(key);
        }catch (Exception e){
            log.error(REDIS_ERROR, e);
        }
        return value;
    }

    /**
     * 获取int类型的value
     * @param key key
     * @return 如果为空，返回0
     */
    public int getInt(String key) {
        int value = 0;
        try{
            String valueStr = redisTemplate.opsForValue().get(key);
            if (Strings.isNotBlank(valueStr)){
                value = Integer.parseInt(valueStr);
            }
        }catch (Exception e){
            log.error(REDIS_ERROR, e);
        }
        return value;
    }

    /**
     * 获取zset集合的size
     * @param key key
     * @return size
     */
    public long getZSetSize(String key){
        try {
            return redisTemplate.opsForZSet().size(key);
        } catch (Exception e){
            log.error(REDIS_ERROR, e);
        }
        return 0;
    }

    
    /**
     * 获取有相同的key的集合
     * @param keyPattern
     * @return
     */
    public Set<String> scan(String keyPattern){
        RedisConnection redisConnection = null;
        try{
            redisConnection = redisTemplate.getConnectionFactory().getConnection();
            ScanOptions scanOptions = ScanOptions.scanOptions().match(keyPattern).count(Integer.MAX_VALUE).build();
            Cursor<byte[]> scan = redisConnection.scan(scanOptions);
            Set<String> set = new HashSet<>();
            if (null != scan){
                while (scan.hasNext()){
                    set.add(new String(scan.next()));
                }
            }
            return set;
        } catch (Exception e){
            log.error(REDIS_ERROR, e);
        } finally {
            if (null != redisConnection){
                redisConnection.close();
            }
        }
        return Collections.emptySet();
    }

    /**
     * 设置字符串的缓存(带过期时间)
     * @param key key
     * @param value value
     * @param time 过期时间
     * @param unit 过期时间单位
     */
    public void setStringValue(String key, String value, Long time, TimeUnit unit){
        try {
            if (time == null){
                redisTemplate.opsForValue().set(key, value);
                return;
            }else if (time < 0){
                time = 1000L;
                unit = TimeUnit.MILLISECONDS;
            }
            redisTemplate.opsForValue().set(key, value, time, unit);
        } catch (Exception e){
            log.error(REDIS_ERROR, e);
        }
    }

    /**
     * 设置字符串的缓存（不带过期时间）
     * @param key key
     * @param value value
     */
    public void setStringValue(String key, String value){
        setStringValue(key, value, null, null);
    }

    public long increment(String key, long delta){
        try {
            return redisTemplate.opsForValue().increment(key, delta);
        } catch (Exception e){
            log.error(REDIS_ERROR, e);
        }
        return delta;
    }

    /**
     * 添加ZSet缓存
     * @param key key
     * @param set set
     * @return 被成功添加的新成员的数量，不包括那些被更新的、已经存在的成员。
     */
    public long addZSet(String key, Set set){
        try {
            return redisTemplate.opsForZSet().add(key, set);
        } catch (Exception e){
            log.error(REDIS_ERROR, e);
        }
        return 0;
    }

    /**
     * 设置过期时间
     * @param key key
     * @param time 过期时间
     * @param unit 过期时间单位
     */
    public void expire(String key,Long time,TimeUnit unit){
        if (time < 0){
            time = 1000L;
            unit = TimeUnit.MILLISECONDS;
        }
        try {
            redisTemplate.expire(key, time, unit);
        } catch (Exception e){
            log.error(REDIS_ERROR, e);
        }
    }

    /**
     * 删除缓存
     * @param key key
     */
    public void delete(String key) {
        try {
            redisTemplate.delete(key);
        } catch (Exception e){
            log.error(REDIS_ERROR, e);
        }
    }

    public void putHash(String key,String hashKey, String value) {
        try {
            redisTemplate.opsForHash().put(key, hashKey, value);
        } catch (Exception e){
            log.error(REDIS_ERROR, e);
        }
    }
    
    /**
     * 设置hash类缓存
     * @param key key
     * @param templateTagMap hash类value
     */
    public void putAllHash(String key, Map<?, ?> templateTagMap) {
        try {
            redisTemplate.opsForHash().putAll(key, templateTagMap);
        } catch (Exception e){
            log.error(REDIS_ERROR, e);
        }
    }

    /**
     * 根据hash的key获取hashMap
     * @param key 缓存的key
     * @return 对应的hashMap
     */
    public Map<Object, Object> getHashMap(String key) {
        try {
            return redisTemplate.opsForHash().entries(key);
        } catch (Exception e){
            log.error(REDIS_ERROR, e);
        }
        return null;
    }
    
    /**
     * 根据hash的key获取hash缓存的value
     * @param key 缓存的key
     * @param hashKey hash类value的key
     * @return 对应的value
     */
    public Object getHashValue(String key, String hashKey) {
        try {
            return redisTemplate.opsForHash().get(key, hashKey);
        } catch (Exception e){
            log.error(REDIS_ERROR, e);
        }
        return hashKey;
    }

    public String getFirstStringValueFormZSet(String key) {
        try {
            Set<String> range = redisTemplate.opsForZSet().range(key, 0L, 0L);
            if (null == range || range.isEmpty()){
                return null;
            }
            return range.iterator().next();
        } catch (Exception e){
            log.error(REDIS_ERROR, e);
        }
        return key;
    }

    public void addSet(String key, String value) {
        try {
            redisTemplate.opsForSet().add(key, value);
        } catch (Exception e){
            log.error(REDIS_ERROR, e);
        }
    }

    public void removeFromSet(String key, String value) {
        try {
            redisTemplate.opsForSet().remove(key, value);
        } catch (Exception e){
            log.error(REDIS_ERROR, e);
        }
    }
}
