package com.galaxy.framework.criteria.parser;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.galaxy.framework.criteria.CriteriaContext;
import com.galaxy.framework.criteria.annotation.Eq;

/**
 * 等于条件解析
 *
 * @author chensj
 * @date 2018-4-17
 **/
public class EqParser extends AbstractGenericParser<Eq> {

    @Override
    public Object getDefaultValue(CriteriaContext<Eq> criteriaContext) {
        return criteriaContext.getType().defaultValue();
    }

    @Override
    public void doParse(CriteriaContext<Eq> criteriaContext, EntityWrapper entityWrapper, String column) {
        if (criteriaContext.getType().reverse()) {
            entityWrapper.ne(column, criteriaContext.getValue());
        } else {
            entityWrapper.eq(column, criteriaContext.getValue());
        }
    }

    @Override
    public String[] getColumns(CriteriaContext<Eq> criteriaContext) {
        return criteriaContext.getType().columns();
    }

    @Override
    public String getGroup(Eq eq) {
        return eq.group();
    }

    @Override
    public boolean allowEmpty(Eq eq) {
        return eq.allowEmpty() || StringUtils.isNotEmpty(eq.defaultValue());
    }

    @Override
    public boolean isEnable(Eq eq) {
        return eq.enable();
    }
}
