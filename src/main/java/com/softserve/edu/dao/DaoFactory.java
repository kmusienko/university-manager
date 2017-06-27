package com.softserve.edu.dao;


import com.softserve.edu.model.Plan;

/**
 * Created by Kostya on 10.06.2017.
 */
public class DaoFactory {
    private FacultyDao facultyDao;
    private SpecialityDao specialityDao;
    private CathedraDao cathedraDao;
    private TeacherDao teacherDao;
    private GroupDao groupDao;
    private StudentDao studentDao;
    private SubjectDao subjectDao;
    private PlanDao planDao;

    private static DaoFactory instance;

    private DaoFactory() {
        facultyDao = new FacultyDao();
        specialityDao = new SpecialityDao();
        cathedraDao = new CathedraDao();
        teacherDao = new TeacherDao();
        groupDao = new GroupDao();
        studentDao = new StudentDao();
        subjectDao = new SubjectDao();
        planDao = new PlanDao();
    }

    public static synchronized DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }
    public FacultyDao getFacultyDao() {
        return facultyDao;
    }
    public SpecialityDao getSpecialityDao() {
        return specialityDao;
    }
    public CathedraDao getCathedraDao() {
        return cathedraDao;
    }
    public TeacherDao getTeacherDao() {
        return teacherDao;
    }
    public GroupDao getGroupDao() {
        return groupDao;
    }
    public StudentDao getStudentDao() {
        return studentDao;
    }
    public SubjectDao getSubjectDao() {
        return subjectDao;
    }
    public PlanDao getPlanDao() {
        return planDao;
    }
}
