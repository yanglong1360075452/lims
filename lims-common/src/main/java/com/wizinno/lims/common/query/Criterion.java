package com.wizinno.lims.common.query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * 条件接口
 * 用户提供条件表达式接口
 *  @author LiuMei
 */
public interface Criterion{
    enum Operator {
        /**
         * equal
         */
        EQ,
        /**
         * not equal
         */
        NE,
        /**
         * like
         */
        LIKE,
        /**
         * greater than
         */
        GT,
        /**
         * less than
         */
        LT,
        /**
         * greater than or equal
         */
        GTE,
        /**
         * less than or equal
         */
        LTE,
        /**
         * and
         */
        AND,
        /**
         * or
         */
        OR
    }

    /**
     * 运行
     * @param root
     * @param query
     * @param builder
     * @return
     */
    Predicate toPredicate(Root<?> root, CriteriaQuery<?> query,
                          CriteriaBuilder builder);
}
