package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.entities.Vehicle;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    
    public CourseServiceImpl(){
        // list=new ArrayList<>();
        // list.add(new Course(145,"Java Course by Furquan ","Java in deatailed explaination"));
        // list.add(new Course(149, "Python by Furquan ", "python in detail explaination"));

        
    }

    @Override
    public List<Course> getCourses() {
        
        return courseDao.findAll();
    }

    // @Override
    // public List<Vehicle> getVehicles() {
    //     //TODO Auto-generated method stub
    //     return null;
    // }

    
    @Override
    public Course getCourse(long courseId){
        // Course c=null;
        // for(Course course:list){
        //     if(course.getId()==courseId){
        //         c=course;
        //         break;
        //     }
        // }

        return courseDao.getOne(courseId);
    }

    @Override
    public Course updateCourse(Course course) {
        // list.forEach(e->{
        //     if(e.getId()==course.getId()){
        //         e.setTitle(course.getTitle());
        //         e.setDescription(course.getDescription());
        //     }
        // });
        courseDao.save(course);
        return course;
    }

    @Override
    public Course addCourse(Course course) {
        // list.add(course);
        courseDao.save(course);
        return course;
    }

    @Override
    public Course deleteCourse(long parseLong) {
        //list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
        Course entity=courseDao.getOne(parseLong);
        courseDao.delete(entity);
        return entity;
    }
    
}
