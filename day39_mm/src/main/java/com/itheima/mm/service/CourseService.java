package com.itheima.mm.service;

import com.itheima.mm.dao.CourseDao;
import com.itheima.mm.entity.PageResult;
import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.pojo.Course;
import com.itheima.mm.pojo.User;
import com.itheima.mm.utils.DateUtils;
import com.itheima.mm.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class CourseService {

    /**
     * 分页查询学科列表
     * 1. 这个方法返回的是PageResult
     * 2. 平常我们的service方法的返回值一般都是怎么来的？一般都是问Dao要。
     * 3. Dao里面的数据又怎么来的？ 一般都是查询数据库来的！
     * 3. 但是现在的pageResult问不了了！
     * @param bean 查询的参数
     * @return PageResult
     * @throws IOException
     */
    public PageResult findByPage(QueryPageBean bean) throws IOException {

        //1. 获取sqlsession
        SqlSession session = SqlSessionFactoryUtils.openSqlSession();

        //2. 得到dao代理对象
        CourseDao dao = session.getMapper(CourseDao.class);

        //3. 调用方法准备数据
        long total = dao.findCount(bean) ;  //学科表的总记录数
        List rows = dao.findByPage(bean); // 当前这一页的集合数据。 那10条数据。

        //4. 创建PageResult对象
        PageResult pr = new PageResult(total , rows );


        //5. 关闭session
        session.close();

        //6. 返回pageResult;
        return pr;
    }

    /**
     * 更新学科
     * @param course 更新的数据
     * @return 影响的行数
     * @throws IOException
     */
    public int update( Course course) throws IOException {

        //1. 得到SqlSession
        SqlSession session = SqlSessionFactoryUtils.openSqlSession();

        //2. 得到代理对象
        CourseDao dao = session.getMapper(CourseDao.class);

        //3. 调用方法
        int row = dao.update(course);

        //4. 提交并且关闭session
        session.commit();
        session.close();

        //5. 返回影响的行数
        return row;
    }

    /**
     * 添加学科
     * @param course
     * @return 影响的行数
     */
    public int add( Course course) throws IOException {



        //1. 得到SqlSession
        SqlSession session = SqlSessionFactoryUtils.openSqlSession();

        //2. 得到代理对象
        CourseDao dao = session.getMapper(CourseDao.class);

        //3. 调用方法
        int row = dao.add(course);

        //4. 关闭session
        session.commit();
        session.close();

        //5. 返回结果
        return row;

    }
}
