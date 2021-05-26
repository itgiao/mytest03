package com.itheima.mm.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mm.dao.CourseDao;
import com.itheima.mm.entity.PageResult;
import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.pojo.Course;
import com.itheima.mm.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class CourseService {
    /**
     * 新增学科
     * @param course
     * @return
     */
    public int add(Course course) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        CourseDao dao=sqlSession.getMapper(CourseDao.class);
        int row=dao.add(course);
       SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return  row;
    }

    public int update(Course course) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        int row=courseDao.update(course);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return row;
    }

    public Page<Course> findByPage(QueryPageBean qpb) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        //查询之前设置一下，需要查询哪一页，每页查询多少条
        PageHelper.startPage(qpb.getCurrentPage(), qpb.getPageSize());
        Page<Course> page=courseDao.findByPage(qpb.getQueryParams());
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
       return page;

    }

    public int deleteById(Course course) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        int row=courseDao.deleteById(course);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return  row;
    }
}
