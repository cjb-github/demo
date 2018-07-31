package com.example.demo.controller;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Student;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/students")
public class SwaggerController {
    private static Map<String, Student> students=new HashMap<String, Student>();
    @ApiOperation(value="添加",notes="根据提交的信息加入一个学生")
   @ApiImplicitParam(name="student",value="要增加的学生信息",required=true,dataType="Student")
    @RequestMapping(value="addStudent",method=RequestMethod.POST)
    public String addStudent(@RequestBody Student student){
    students.put(student.getStId(), student);
    return "add student to students successfully";
    }
    @RequestMapping(value="/removeStudent/{stId}",method=RequestMethod.DELETE)
    @ApiImplicitParam(name="id",required=true,dataType="String")
    @ApiOperation(value="删除",notes="根据学生id删除学生")
    public String removeStudent(@PathVariable("stId") String stId){
    students.remove(stId);
    return "remove student from students successfully";
    }
    @RequestMapping(value={""},method=RequestMethod.GET)
    @ApiOperation(value="获取学生列表",notes="获取所有学生列表")
    public String getAllStudent(){
    return JSONObject.toJSONString(students);
    }
}
