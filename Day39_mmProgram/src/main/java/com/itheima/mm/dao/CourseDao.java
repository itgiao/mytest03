package com.itheima.mm.dao;

import com.github.pagehelper.Page;
import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.pojo.Course;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface CourseDao {
    /**
     * 添加学科
     * @param course
     * @return
     */
    int add(Course course);

    /**
     * 修改学科
     * @param course
     *
     *@return
     */
    int update(Course course);

    /**
     * 分页
     * @
     */
    Page<Course> findByPage( Map map);



    /**
     * 删除学科
     * @param course
     * @return
     */
    int deleteById(Course course);
}


