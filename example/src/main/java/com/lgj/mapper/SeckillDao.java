package com.lgj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lgj.entity.Seckill;
import com.lgj.mymapper.MyMapper;



public interface SeckillDao extends MyMapper<Seckill>{
	
	/**减库存
	 * @param seckillId
	 * @param killTime
	 * @return
	 */
	@Update("<script>"
	+ "update seckill set inventory = inventory -1 where seckill_Id = #{seckillId} "
	+ "and start_time <![CDATA[ <= ]]> #{killTime} "
	+ "and end_time >= #{killTime} "
	+ "and inventory > 0 "
    + "</script>")
	
	int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") String killTime);
	
	/**根据id查询秒杀对象
	 * @param sckillId
	 * @return
	 */
	@Select("<script> SELECT " +

          "    sckill_id as sckillId, " +
          "   name," +
          "   number," +
          "   start_time as startTime," +
          "   end_time as endTime," +
          "   create_time as createTime," +
          "    FROM" +
          "    sckill "+
          " WHERE sckillId = #{seckillId}"
          
          + "</script>")
	Seckill queryById(long seckillId);
	
	/**根据偏移量查询秒杀商品列表
	 * @param offet
	 * @param limit
	 * @return
	 */
	@Select("<script> SELECT " +

          "   sckill_id as sckillId, " +
          "   name," +
          "   number," +
          "   start_time as startTime," +
          "   end_time as endTime," +
          "   create_time as createTime," +
          "   FROM" +
          "   sckill "+
          " order by create_time desc"+
          " limit #{offset},#{limit}"
          
          + "</script>")
	List<Seckill> queryAll(@Param("offset") int offet,@Param("limit") int limit);

}
