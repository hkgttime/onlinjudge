package org.oj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.oj.entity.Problem;
import org.oj.entity.ProblemList;

import java.util.ArrayList;

@Mapper
public interface ProblemMapper {

    @Select("SELECT * FROM PROBLEMS WHERE pid = #{pid}")
    Problem getProblemById(String pid);

    @Select("")
    ArrayList<ProblemList> getProblemList(int page);
}
