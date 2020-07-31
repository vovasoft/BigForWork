package com.vova.demo_oracle;

import com.vova.demo_oracle.Dept;
import java.util.List;

public interface DeptMapper {
    int deleteByPrimaryKey(Short eptno);

    int insert(Dept record);

    Dept selectByPrimaryKey(Short eptno);

    List<Dept> selectAll();

    int updateByPrimaryKey(Dept record);
}