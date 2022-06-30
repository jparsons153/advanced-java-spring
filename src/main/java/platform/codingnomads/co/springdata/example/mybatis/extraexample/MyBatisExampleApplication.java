package platform.codingnomads.co.springdata.example.mybatis.extraexample;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.mappers.ChapterMapper;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.mappers.ImageMapper;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.mappers.LessonMapper;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.mappers.SectionMapper;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.models.Chapter;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.models.Image;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.models.Section;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MyBatisExampleApplication implements CommandLineRunner {

    /* Before running this app, be sure to:

        * create a new empty schema in the mysql database named "mybatis"

        * execute the SQL found "database_structure.sql" on the mybatis schema

        * update the "spring.datasource.url" property in your application.properties file to
          jdbc:mysql://localhost:3306/mybatis?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC

     */

    @Autowired
    ImageMapper imageMapper;

    @Autowired
    LessonMapper lessonMapper;

    @Autowired
    ChapterMapper chapterMapper;

    @Autowired
    SectionMapper sectionMapper;

    public static void main(String[] args) {
        SpringApplication.run(MyBatisExampleApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {

    // Image mapper CRUD
        byte[] byteArray1 = {80, 65, 78, 75, 65, 74};
        imageMapper.insertNewImage("IMM02",byteArray1);
     //   imageMapper.getImageByName("image one"));
     //   imageMapper.renameImage("image one", "IM002");
     //   imageMapper.deleteImageByName("IM002");

        //Section section01 = new Section();
       // section01.setName("section 01");
//        section01.setId(1L);
        Long section01Id = sectionMapper.insertNewSection("section 01");
Section section01 = sectionMapper.getSectionById(section01Id);
        System.out.println("section 01 id" + section01.getId());

//        Chapter chapter01 = new Chapter();
//        chapter01.setName("chapter 01");
//        chapterMapper.insertNewChapter("chapter 01", 1L);

     //   lessonMapper.insertNewLesson("Lesson number one","this is lesson one",chapter01.getId());


    }
}
