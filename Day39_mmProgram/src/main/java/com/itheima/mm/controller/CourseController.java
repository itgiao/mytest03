package com.itheima.mm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.annotation.Controller;
import com.annotation.RequestMapping;
import com.github.pagehelper.Page;
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
import java.util.List;

@Controller
public class CourseController {

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
            if (row > 0) {
                result = new Result(true, "添加成功");
            } else {
                result = new Result(false, "添加失败");
            }
            resp.getWriter().write(JSON.toJSONString(result));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/course/update")
    public void update(HttpServletRequest request, HttpServletResponse response) {
        try {
            //获取参数
            Course course = JSON.parseObject(request.getInputStream(), Course.class);
            //交代service
            CourseService courseService = new CourseService();
            int row = courseService.update(course);

            //响应
            Result result;
            if (row > 0) {
                result = new Result(true, "更新成功");
            } else {
                result = new Result(false, "更新失败");
            }
            System.out.println("result = " + result);
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/course/findByPage")
    public void pageByPage(HttpServletRequest request, HttpServletResponse response) {
        try {
            //获取请求参数
            QueryPageBean bean = JSON.parseObject(request.getInputStream(), QueryPageBean.class);
            //获取页面和每页显示条数
//            Integer currentPage = bean.getCurrentPage();
//            Integer pageSize = bean.getPageSize();
            //调用业务处理
            CourseService service = new CourseService();

            Page<Course> page= service.findByPage(bean);
            System.out.println("page = " + page);
            long total = page.getTotal();
            List<Course> list = page.getResult();
            PageResult pr=new PageResult(total,list);

//            pr.setTotal();
//            pr.setRows(list);


            //通过自定义将所需分页数据进行封装
            //响应
            Result result = new Result(true, "查询成功", pr);
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
            try {
                Result result = new Result(false, "查询失败");
                response.getWriter().write(JSON.toJSONString(result));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }

    @RequestMapping("/course/delete")
    public void deleteById(HttpServletRequest request, HttpServletResponse response) {
        try {
            Course course = JSON.parseObject(request.getInputStream(), Course.class);
            System.out.println("course.getId() = " + course.getId());
            CourseService courseService = new CourseService();
            System.out.println("course = " + course);
            int row = courseService.deleteById(course);
            Result result;
            if (row > 0) {
                result = new Result(true, "删除成功");
            } else {
                result = new Result(false, "删除失败");
            }
            System.out.println("result = " + result);
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}