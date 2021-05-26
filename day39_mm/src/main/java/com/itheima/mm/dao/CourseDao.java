package com.itheima.mm.dao;

import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.pojo.Course;

import java.util.List;

public interface CourseDao {


    /**
     * 更新学科
     * @param course 更新的学科对象
     * @return 影响的行数
     */
    int update(Course course);

    /**
     * 添加学科
     * @param course
     * @return 影响的行数
     */
    int add(Course course);


    /**
     * 获取总记录数
     * @param bean 查询的总记录数，也必须要受到查询条件的影响。不能一概而论就是查询整张表的总记录数。
     * @return
     */
    long findCount(QueryPageBean bean);

    /**
     * 当前这一页的集合数据
     * @param bean  查询的参数也要往下传，比如：要查询第几页，每页查询多少条，
     *              有什么样的过滤条件，都要往这里传。
     * @return
     */
    List<Course> findByPage(QueryPageBean bean);
}
