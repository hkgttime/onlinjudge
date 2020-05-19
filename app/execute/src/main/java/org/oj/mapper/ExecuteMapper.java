package org.oj.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.oj.entity.RunCode;

@Mapper
public interface ExecuteMapper {

    @Insert("INSERT INTO EXETS(eid, pid, uid, language, data, status) VALUES(eid, pid, uid, language, data, status)")
    void insertExeLine(RunCode code);
}
