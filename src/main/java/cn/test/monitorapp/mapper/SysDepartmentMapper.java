package cn.test.monitorapp.mapper;

import cn.test.monitorapp.entity.SysDepartment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liumou
 * @since 2024-12-25
 */
@Mapper
public interface SysDepartmentMapper extends BaseMapper<SysDepartment> {
    @Update("update sys_dept set worker_count = worker_count + #{workerCount} where department_id = #{departmentId}")
    int updateWorkerCount(Integer departmentId, Integer workerCount);
}
