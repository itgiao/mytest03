package com.itheima.mm.controller;

import com.alibaba.fastjson.JSON;

import com.annotation.Controller;
import com.annotation.RequestMapping;
import com.itheima.mm.entity.PageResult;
import com.itheima.mm.entity.QueryPageBean;
import com.itheima.mm.entity.Result;
import com.itheima.mm.pojo.Course;
import com.itheima.mm.pojo.User;
import com.itheima.mm.service.CourseService;
import com.itheima.mm.utils.DateUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
public class CourseController {

    @RequestMapping("/course/update")
    public void update(HttpServletRequest req, HttpServletResponse resp) {

        try {
            //1. 获取参数
            Course course = JSON.parseObject(req.getInputStream(), Course.class);

            //2. 交代service
            CourseService cs = new CourseService();
            int row = cs.update(course);

            //3. 响应
            Result result = null;
            if (row > 0) {
                result = new Result(true, "更新成功");
            } else { //添加失败
                result = new Result(false, "更新失败");
            }
            resp.getWriter().write(JSON.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 分页：学科列表
     *
     * @param req
     * @param resp
     */
    @RequestMapping("/course/findByPage")
    public void findByPage(HttpServletRequest req, HttpServletResponse resp) {

        try {
            //1. 获取请求参数
            QueryPageBean bean = JSON.parseObject(req.getInputStream(), QueryPageBean.class);

            //2. 交代service
            CourseService cs = new CourseService();
            PageResult pr = cs.findByPage(bean);

            //3. 响应
            Result result = new Result(true, "查询成功", pr);
            resp.getWriter().write(JSON.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();

            try {
                Result result = new Result(false, "查询失败");
                resp.getWriter().write(JSON.toJSONString(result));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }


    /**
     * 新增学科
     *
     * @param req
     * @param resp
     */
    @RequestMapping("/course/add")
    public void add(HttpServletRequest req, HttpServletResponse resp) {

        try {
            //1. 获取参数
            Course course = JSON.parseObject(req.getInputStream(), Course.class);

            //1.1 补充上来缺少的数据
            //设置排序序号
            course.setOrderNo(1);
            //设置添加学科的日期事件
            course.setCreateDate(DateUtils.parseDate2String(new Date()));
            //设置添加的用户id
            User user = (User) req.getSession().getAttribute("user");
            course.setUserId(user.getId());

            //2. 交代service
            CourseService cs = new CourseService();
            int row = cs.add(course);

            //3. 响应
            Result result = null;
            if (row > 0) { //添加成功
                result = new Result(true, "添加成功");
            } else { //添加失败
                result = new Result(false, "添加失败");
            }
            resp.getWriter().write(JSON.toJSONString(result));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
